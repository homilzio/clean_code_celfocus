#!/bin/bash

set -o errexit

MYSQL_PASSWORD=admin
SONARQUBE_DB_NAME=sonar
SONARQUBE_DB_USER=sonar
SONARQUBE_DB_PASS=sonar

#
# Install MySQL
#
function installMySQL {
	# Install MySQL server
	sudo apt-get install -y mysql-server mysql-client
	# ensure skip-grant-tables
	cat > /etc/mysql/conf.d/skip-grant-tables.cnf << EOF
[mysqld]
skip-grant-tables
EOF
	# ensure mysql is on now with those grant tables being ignored
	if [ -f /var/run/mysql/mysql.pid ]; then
  	sudo systemctl restart mysql
	else
    sudo systemctl start mysql
	fi
	# Ensure that things aren't borked due to upgrade from mysql55 to mysql56u
	mysql_upgrade
}

#
#
#
function configureSonarDatabase {
	# SonarQube database
	mysql -e "CREATE DATABASE $SONARQUBE_DB_NAME DEFAULT CHARACTER SET utf8;"
	mysql -e "CREATE USER '$SONARQUBE_DB_USER'@'%' IDENTIFIED BY '$SONARQUBE_DB_PASS';"
	mysql -e "GRANT ALL ON $SONARQUBE_DB_NAME.* TO '$SONARQUBE_DB_USER'@'%';"
	# flush privileges
	mysql -e 'FLUSH PRIVILEGES;'
}

#
#
#
function removeGrantTableSkip {
	# Remove grant table skip
	sudo rm /etc/mysql/conf.d/skip-grant-tables.cnf
	# ensure mysql is on now with those grant tables being ignored
	if [ -f /var/run/mysql/mysql.pid ]; then
    sudo systemctl restart mysql
	else
    sudo systemctl start mysql
	fi
	# ensure mysql starts on restart
	systemctl enable mysql
}

echo "Setup MySQL"

installMySQL
configureSonarDatabase
removeGrantTableSkip

echo "MySQL setup complete"
