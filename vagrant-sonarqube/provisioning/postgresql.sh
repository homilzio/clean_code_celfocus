#!/bin/bash

set -o errexit

#
# Install the PostgreSQL server
#
function installPostgreSQL {
	# Configure the installation repository
	sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
	wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | sudo apt-key add -
	# Install the service
	sudo apt-get -y install postgresql postgresql-contrib
	# Start and enable the service
	sudo systemctl start postgresql
	sudo systemctl enable postgresql
}

echo "Setup PostgreSQL"

installPostgreSQL

echo "PostgreSQL setup complete"
