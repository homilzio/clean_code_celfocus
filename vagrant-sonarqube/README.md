
# Sonarqube Vagrant Server

Proyecto para aprovisionar un servidor de pruebas con Sonarqube instalado.

A continuación se pueden encontrar las instrucciones sobre como configurar y ejecutar el sandbox usando [Virtualbox](https://www.virtualbox.org/) y [Vagrant](http://vagrantup.com).

El objetivo del proyecto es contar con un entorno de pruebas automatizado, lo más parecido a unas instalación productiva, desde el cual se puedan hacer pruebas de forma controlada y realista.

## Información General y prerequisitos

Servicios y versiones empleadas para la ejecución del servidor:

 * Virtualbox 5.2
 * Vagrant 2.2.2
 * OS anfitrión: Ubuntu 18.04 LTS
 * OS VM: Ubuntu 18.04 LTS

Además de lo anterior, es necesario que tengamos instalado el siguiente plugin de Vagrant:

 * vagrant-hostmanager. Para instalarlo solamente es necesario ejecutar el siguiente comando, `$ vagrant plugin install vagrant-hostmanager`

## Creando el servidor

Creamos un directorio donde albergaremos todos los servidores Vagrant de nuestra infraestructura y nos movemos al mismo.

```
 $ mkdir /opt/vagrant-runtime
 $ cd /opt/vagrant-runtime
```

Hecho esto, clonamos este repositorio.

```
 $ git clone [REPO_URL]
```

## Configuramos el Entorno

Creamos el fichero ```config```. Podemos hacerlo copiando el fichero de template que acompaña al proyecto.

```
 $ cp config.json.template config.json
```

Una vez que hemos creado nuestro fichero podemos llevar a cabo la configuración de nuestro servidor.

### Configuración General

A continuación se pueden ver las principales opciones de configuración disponibles.

```
"devcircus-sonarqube-server": {
		"enabled": true,
		"guest-hostname": "devcircus-sonarqube-server.vm.server",
		"group": "DevCircus Infra Servers",
		"box": "ubuntu/bionic64",
		"timezone": "Europe/Madrid",
		"cpus": 1,
		"memory": 4096,
		"ssh-prv-key": "~/.ssh/id_rsa",
		"ssh-pub-key": "~/.ssh/id_rsa.pub",
		"network": {
			"interfaces": [
				{
					"network-type": "private",
					"if-adapter": "enp0s8",
					"if-inet-type": "static",
					"if-address": "10.0.13.21",
					"if-netmask": "255.255.0.0"
				},
				{
					"network-type": "public",
					"if-adapter": "enp0s3",
					"if-inet-type": "static",
					"if-address": "192.168.88.21",
					"if-netmask": "255.255.88.0",
					"bridge-adapter": "enp1s0"
				}
			]
		},
		"scripts": [
				"bootstrap.sh",
				"ssh.sh",
				"java.sh",
				"postgresql.sh",
				"sonarqube.sh",
				"nginx.sh"
		]
}
```

| Parámetro             |  Valor(es)                                                        |
| --------------------- | ----------------------------------------------------------------- |
| `enabled`             | `true` si queremos que Vagrant cree la instancia, en caso contrario ignora el bloque de configuración. Esto se usa sobre todo cuando aprovisionamos más de una máquina desde el mismo repositorio         |
| `guest-hostname`      | Hostname de la instancia                                          |
| `group`               | Si queremos agrupar las instancias. En VirtualBox esta opción se traduce en que las máquinas virtuales que tengan este label se agruparan juntas |
| `box`                 | Vagrant Box                                                       |
| `timezone`            | Server timezone                                                   |
| `cpus`                | Número de CPUs de la instancia                                    |
| `memory`              | Cantidad de memoria de la instancia                              |
| `ssh-prv-key`         | Clave privada para acceder a la instancia. Si no indicamos nada, Vagrant intenta inyectar una clave por defecto                         |
| `ssh-pub-key`         | Clave pública para acceder a la instancia. Si no indicamos nada, Vagrant intenta inyectar una clave por defecto                         |
| `scripts`             | Listado de scripts que queremos utilizar en la etapa de provisioning  |

### Configuración de Red

A continuación se muestra el bloque de configuración de red.

```
"network": {
	"interfaces": [
		{
			"network-type": "private",
			"if-adapter": "enp0s8",
			"if-inet-type": "static",
			"if-address": "10.0.13.21",
			"if-netmask": "255.255.0.0"
		},
		{
			"network-type": "public",
			"if-adapter": "enp0s3",
			"if-inet-type": "static",
			"if-address": "192.168.88.21",
			"if-netmask": "255.255.88.0",
			"bridge-adapter": "enp1s0"
		}
	]
},
```

Se han definido dos interfaces de red.

 * Una privada para comunicar esta instancia con otras a través de una red privada.
 * Una pública que usaremos como punto de entrada dentro de nuestra red corporativa.

Si es necesario, se pueden definir más interfaces siguiente el mismo esquema de configuración.

A continuación se muestran los parámetros más habituales para la configuración de red.

| Parámetro             |  Valor(es)                                                        |
| --------------------- | ----------------------------------------------------------------- |
| `network-type`        | `Private` ó `Public` [Vagrant documentation](https://www.vagrantup.com/docs/getting-started/networking.html) |
| `if-adapter`          | El nombre del adaptador de red, p.e. eth0, eth1, etc.    |
| `if-inet-type`        | `static` ó nada. [Vagrant documentation](https://www.vagrantup.com/docs/getting-started/networking.html) |
| `if-address`          | Dirección ip que queremos asignar a la interfaz                   |
| `if-netmask`          | Mascara de red                                                    |
| `bridge-adapter`      | Modo de configuración de la interfaz. [Vagrant documentation](https://www.vagrantup.com/docs/networking/public_network.html)    |

## Arrancando la Instancia

Una vez que tenemos el entorno configurado, podemos ejecutar la instancia ejecutando el siguiente comando:

```
 $ vagrant up
```

## Administrando la Instancia

A continuación se muestran los comandos más típicos necesarios para la gestión de las instancias.

| Comando                              |  Descripción                                      |
| ------------------------------------ | ------------------------------------------------- |
| `$ vagrant status`                   | Ver el estado de la instancia                     |
| `$ vagrant ssh [instance-id]`        | Conectarse a la instancia via SSH                 |
| `$ vagrant suspend [instance-id]`    | Suspender la instancia                            |
| `$ vagrant halt [instance-id]`       | Parar la instancia                                |
| `$ vagrant destroy [instance-id]`    | Destruir la instancia                             |

Si no queremos utilizar el identificador de la instancia en los comandos, debemos de movernos previamente al directorio de instalación.

```
 $ cd /opt/vagrant-runtime/vagrant-sonarqube
```

## Arrancar y parar la instancia como un servicio

Si queremos que la instancia se arranque y se pare automáticamente cuando iniciemos o paremos nuestro host, crearemos un scrtipt de inicio de sistema.

En nuestro caso, el script se distribuye con el repositorio de código, con lo que solamente debemos de copiarlo en el lugar adecuado y seguir una serie de pasos.

Como hemos dicho, lo primero es copiar el script en el lugar adecuado.

```
 $ cd /opt/vagrant-runtime/vagrant-sonarqube
 $ sudo cp ./config/init/vagrant-sonarqube /etc/init.d
```

Le asignamos los permisos adecuados al script para que sea ejecutable.

```
 $ sudo chmod a+x /etc/init.d/vagrant-sonarqube
```

Registramos el script para que sea ejecutado en el inicio y parada del sistema.

```
 $ sudo update-rc.d vagrant-sonarqube defaults
```

En este momento, podríamos reiniciar nuestro sistema host y verificar que efectivamente la imagen virtual se inicializa sola.

### Gestión de la instancia como Servicios

A continuación se muestran los comandos típicos que podemos usar para gestionar nuestra máquina virtual como un servicio del sistema:

| Comando                                    |  Descripción                                                       |
| ------------------------------------------ | ------------------------------------------------------------------ |
| `$ sudo /etc/init.d/vagrant-sonar start`   | Iniciar la máquina virtual. Equivalente a `vagrant up`             |
| `$ sudo /etc/init.d/vagrant-sonar stop`    | Parar la máquina virtual. Equivalente a `vagrant halt`             |
| `$ sudo /etc/init.d/vagrant-sonar restart` | Reiniciar la máquina virtual. Equivalente a `vagrant reload`       |
| `$ sudo /etc/init.d/vagrant-sonar status`  | Ver el etado de la máquina virtual. Equivalente a `vagrant status` |

### Eliminar la instancia como Servicios

Si se desea eliminar la instancia a nivel de servicio de nuestro host, lo único que tenemos que hacer es lo siguiente.

Eliminamos la configuración de inicio de la instancia:

```
 $ sudo update-rc.d -f vagrant-sonarqube remove
```

Eliminamos el script que hemos creado

```
 $ sudo rm /etc/init.d/vagrant-sonarqube
```
