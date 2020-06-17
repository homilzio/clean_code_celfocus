#!/bin/bash

set -o errexit

function installSoftwareBase {
  # Install software base
  sudo apt-get update
  sudo apt-get upgrade -y
	sudo apt-get install -y unzip software-properties-common	
}

echo "Provisioning the Server"

installSoftwareBase

echo "Server Successfully Provisioned"
