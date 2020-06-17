#!/bin/bash

set -o errexit

#
# Install Nginx server
#
function installNginx {
  # Install NGINX
  apt-get install -y nginx ssl-cert
  # Update the default vhost
  cat /vagrant/config/nginx/nginx.conf > /etc/nginx/nginx.conf
}

#
# Clean the default configuration
#
function cleanNginxConfiguration {
	# Link the sites enabled with the vagrant folder configuration.
  rm -Rf /etc/nginx/sites-enabled
  ln -fs /vagrant/config/nginx/sites-enabled /etc/nginx/
}

echo "Setup Nginx"

installNginx
cleanNginxConfiguration

echo "Nginx setup complete"
