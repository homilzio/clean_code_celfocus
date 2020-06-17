# -*- mode: ruby -*-
# vi: set ft=ruby :

require_relative "utils/network.rb"

module Template
  module Providers
    module Virtualbox
      class VirtualboxProvider

        #
        # Function that provision the servers using Virtualbox
        # Params:
        # +machine_instance+::
        # +server_config+::
        #
        def self.configVirtualBox(machine_instance, server_config)

          # Provide the Virtual Maniche
          # More Info See: http://docs.vagrantup.com/v2/vagrantfile/machine_settings.html
          machine_instance.vm.provider :virtualbox do |vb|
            vb.name = server_config['guest-hostname']
            vb.cpus = server_config['cpus'] || 2
            vb.memory = server_config['memory'] || 2048

            # SSH settings
            if server_config["ssh-pub-key"]
              machine_instance.ssh.insert_key = false
              machine_instance.vm.provision "file", source: server_config["ssh-pub-key"], destination: "~/.ssh/authorized_keys"
              machine_instance.ssh.private_key_path = [server_config["ssh-prv-key"], "~/.vagrant.d/insecure_private_key"]
            end

            # Configure the instance group
            if server_config["group"]
              vb.customize ["modifyvm", :id, "--groups", "/" + server_config["group"]]
            end

            # http://stackoverflow.com/questions/19490652/how-to-sync-time-on-host-wake-up-within-virtualbox
            vb.customize [ "guestproperty", "set", :id, "/VirtualBox/GuestAdd/VBoxService/--timesync-set-threshold", 10000 ]
            vb.gui = false
          end

          # [Workaround]
          # default: stdin: is not a tty
          # If you're using Vagrant with Ubuntu and getting this annoying (but not
          # impactful) error during provisioning, Just paste this into your Vagrantfile
          # as the first provisioner:
          machine_instance.vm.provision "fix-no-tty", type: "shell" do |s|
            s.privileged = false
            s.inline = "sudo sed -i '/tty/!s/mesg n/tty -s \\&\\& mesg n/' /root/.profile"
          end

          # Configure the hostname
          machine_instance.vm.hostname = server_config['guest-hostname']

          # Network configuration
          Template::Providers::Virtualbox::Utils::NetworkManager.configureNetwork(machine_instance, server_config)

          # custom hostname aliases
          if server_config['aliases']
            machine_instance.hostmanager.aliases = server_config['aliases'].join(' ').to_s
          end

          # Set box type based on configuration. Defaults to `precise64` (Ubuntu).
          if !server_config["box"]
            machine_instance.vm.box = "ubuntu/trusty64"
          else
            machine_instance.vm.box = server_config["box"]
          end
          # Set the box URL
          # The URL that you see below is from Vagrant's own list of available boxes:
          # http://www.vagrantbox.es/
          if server_config["box-url"]
            machine_instance.vm.box_url = server_config["box-url"]
          end

          # Provisioning the server
          if server_config.has_key?("scripts")
            # Execute the provisioning servers
            server_config["scripts"].each do |script, key|
              serverScript = "./provisioning/" + script
              machine_instance.vm.provision "shell", path: serverScript
            end
          end
        end
      end
    end
  end
end
