# -*- mode: ruby -*-
# vi: set ft=ruby :

require 'resolv'

module Template
  module Providers
    module Virtualbox
      module Utils
        class NetworkManager

          #
          # Function that configure the network interfaces
          # Params:
          # +machine_instance+::
          # +server_config+::
          #
          def self.configureNetwork(machine_instance, server_config)
            # Iterate over the network configuration
            if server_config.has_key?("network")
              network_config = server_config["network"]
              # Configure interfaces
              if network_config.has_key?("interfaces")
                interfaces_config = network_config["interfaces"]
                # Iterate over the network interfaces
                interfaces_config.each do |interface|
                  type = interface['network-type']
                  # We only handle private and public networks
                  next if type != "private" && type != "public"
                  # Configure it
                  if type == "public"
                    configureInterface("public_network", machine_instance, interface)
                  elsif type == "private"
                    configureInterface("private_network", machine_instance, interface)
                  end
                end
              end
              # Configure the gateway
              if network_config.has_key?("gw-ip")
                configureGateway(machine_instance, network_config)
              end
            end
          end

          #
          # Configure the gateway
          # Params:
          # +machine_instance+::
          # +network_config+::
          #
          private
          def self.configureGateway(machine_instance, network_config)
            # Get the gateway ip
            gwip = network_config["gw-ip"]
            # Compose command
            command = ["route", "add"]
            case gwip
            when Resolv::IPv6::Regex
              command += ["-A", "inet6"]
            end
            command += ["default", "gw", gwip]
            # Get and set the gw interface
            if network_config.has_key?("gw-if")
              command << network_config["gw-if"]
            end
            # Execute command
            machine_instance.vm.provision "shell",
              run: "always",
              inline: command.join(" ")
            # Delete default gw on eth0
            machine_instance.vm.provision "shell",
              run: "always",
              inline: "eval `route -n | awk '{ if ($8 ==\"eth0\" && $2 != \"0.0.0.0\") print \"route del default gw \" $2; }'`"
          end

          #
          # Configure a interface
          # Params:
          # +type+::
          # +machine_instance+::
          # +network_config+::
          #
          private
          def self.configureInterface(type, machine_instance, interface)
            # Parameters map
            parameters = {}
            if interface.has_key?("if-inet-type")
              if interface["if-inet-type"] == "dhcp"
                parameters[:type] = interface['if-inet-type']
                # Configure interface
                machine_instance.vm.network type, parameters
                return
              end
            end
            if interface.has_key?("if-address")
              parameters[:ip] = interface['if-address']
              if interface.has_key?("if-netmask")
                parameters[:netmask] = interface['if-netmask']
              end
              if interface.has_key?("if-adapter")
                parameters[:bridge] = interface['bridge-adapter']
              end
            else
              parameters[:type] = "dhcp"
            end
            # Configure interface
            machine_instance.vm.network type, parameters
          end

        end
      end
    end
  end
end
