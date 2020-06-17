#!/bin/bash

set -o errexit

#
# Install and set Java 8
#
function installJava8 {
	# Install Java
	sudo add-apt-repository ppa:webupd8team/java -y
	sudo apt-get update
	echo debconf shared/accepted-oracle-license-v1-1 select true | \
  	sudo debconf-set-selections
	echo debconf shared/accepted-oracle-license-v1-1 seen true | \
	  sudo debconf-set-selections
	sudo apt-get install -y oracle-java8-installer
	# Set the environment
	sudo apt-get install -y oracle-java8-set-default
}

echo "Setup Java"

installJava8

echo "Java setup complete"
