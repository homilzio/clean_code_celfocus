#!/bin/bash

set -o errexit

# URL = sonar.devcircus.com
SERVER_SUBDOMAIN="sonar"
SERVER_DOMAIN="devcircus.com"
SONAR_VERSION=7.4
SONAR_HOME=/opt/sonar
SONAR_DB_NAME=sonarqube
SONAR_DB_USER=sonarqube
SONAR_DB_PASS=sonarqube

#
# Create the system user
#
function createSystemUser {
	sudo addgroup --system sonar
	sudo adduser --system --shell /bin/bash --home $SONAR_HOME --ingroup sonar --disabled-login --disabled-password sonar
}

#
# Install SonarQube
#
function installSonarQube {
	wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-$SONAR_VERSION.zip
	sudo unzip sonarqube-$SONAR_VERSION.zip
	sudo cp -R sonarqube-$SONAR_VERSION/* $SONAR_HOME/
	rm -Rf sonarqube-$SONAR_VERSION
	rm -Rf sonarqube-$SONAR_VERSION.zip
}

#
# Configure the SonarQube server
#
function configureSonarQube {
	# Database configuration
	sudo echo 'sonar.jdbc.username='$SONAR_DB_USER >> $SONAR_HOME/conf/sonar.properties
	sudo echo 'sonar.jdbc.password='$SONAR_DB_PASS >> $SONAR_HOME/conf/sonar.properties
	sudo echo "sonar.jdbc.url=jdbc:postgresql://localhost/$SONAR_DB_NAME" >>$SONAR_HOME/conf/sonar.properties
	# Server configuration
	sudo echo 'sonar.web.host=0.0.0.0' >> $SONAR_HOME/conf/sonar.properties
	sudo echo 'sonar.web.port=9000' >> $SONAR_HOME/conf/sonar.properties
}

#
# Create the user and the database
#
function configureDatabase {
	sudo -u postgres createuser -D -A $SONAR_DB_USER
	sudo -u postgres psql -c "ALTER USER $SONAR_DB_USER WITH ENCRYPTED password '$SONAR_DB_PASS'"
	sudo -u postgres createdb -O $SONAR_DB_USER $SONAR_DB_NAME
}

#
# Configure SonarQube as a system service
#
function initSonarOnSystemStartup {
	sudo cp /vagrant/config/sonar/sonar /etc/init.d/sonar
	sudo sed -i 's/#RUN_AS_USER=/RUN_AS_USER=sonar/g' $SONAR_HOME/bin/linux-x86-64/sonar.sh
	sudo ln -s $SONAR_HOME/bin/linux-x86-64/sonar.sh /usr/bin/sonar
	sudo chmod 755 /etc/init.d/sonar
	sudo update-rc.d sonar defaults	
}

#
# Set the system permissions
#
function setSystemPermissions {
	sudo chown -R sonar:sonar $SONAR_HOME
}

#
# Configure the Nginx server
#
function configureNginx {
	# Link the configuration files
	ln -fs /vagrant/config/nginx/sites-enabled /etc/nginx/
	# Import the certificates
	cp /vagrant/config/certs/* /etc/ssl/private
	chmod 400 /etc/ssl/private/$SERVER_DOMAIN-keypair.pem
	cp /etc/ssl/private/$SERVER_DOMAIN-crt.pem /usr/local/share/ca-certificates/$SERVER_SUBDOMAIN.$SERVER_DOMAIN.crt
	update-ca-certificates --verbose
	# Link the certs
	ln -s /etc/ssl/private/$SERVER_DOMAIN-keypair.pem /etc/ssl/private/$SERVER_SUBDOMAIN.$SERVER_DOMAIN.key
	ln -s /etc/ssl/private/$SERVER_DOMAIN-crt.pem /etc/ssl/certs/$SERVER_SUBDOMAIN.$SERVER_DOMAIN.crt
}

#
# Restart the Nginx service
#
function restartNginx {
	# Restart nginx so it can pick up the new configuration
	service nginx restart
}

#
# Start the Sonaqube service
#
function startSonaqube {
	# Start the service
	sudo service sonar stop
	sudo service sonar start
}

echo "Setup SonarQube"

createSystemUser
installSonarQube
configureSonarQube
configureDatabase
initSonarOnSystemStartup
setSystemPermissions
configureNginx
restartNginx
startSonaqube

echo "SonarQube setup complete"
