# Taller Ruby On Rails

En este instructivo se detallan todos los pasos necesarios para realizar exitosamente este taller.

## 1. Guía de Instalación

Ruby On Rails utiliza una serie de dependencias que no son instaladas automáticamente, en este instructivo se incluyen algunas de las más comunes pero podría ser necesario instalar algún componente adicional.

Siga las instrucciones correspondientes a su sistema operativo, mostrado a continuación:

### Linux (Distribuciones Debian o derivadas como Ubuntu, Mint)

Para realizar la instalación en Linux, abra una ventana de la terminal e introduzca los siguientes comandos.

#### Dependencias

**A) Git**

```bash
$ sudo apt install git
```
Verificar instalación

```bash
$ git --version

git version 2.17.1
```
**B) Node.js**

Primero se debe agregar el repositorio
```bash
$ sudo apt-get install curl
$ curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash -
$ sudo apt-get update
```
Luego se instala
```bash
$ sudo apt-get install nodejs
```
Y se verifica la instalación
```bash
$ node -v

v12.14.1
```
**C) YARN**

Primero se debe agregar el repositorio
```bash
$ curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
$ echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
$ sudo apt-get update
```

Luego se instala
```bash
$ sudo apt install yarn
```
Y se verifica la instalación
```bash
$ yarn --version

1.21.1
```

#### Ruby, SQLite3 y Rails

**A) Instalación de Ruby**
```bash
$ sudo apt-get install ruby-full
```
Se verifica la instalación
```bash
$ ruby -v 

2.5.1
```

**B) Instalación de SQLlite3**
```bash
$ sudo apt-get install sqlite3
```
Se verifica la instalación
```bash
$ sqlite3 --version

3.22.0 2018-01-22 18:45:57 0c55d179733b46d8d0ba4d88e01a25e10677046ee3da1d5b1581e86726f2alt1
```


**C) Instalación de Rails**
```bash
$ sudo gem install rails
```
Se verifica la instalación
```bash
$ rails --version

Rails 6.0.2.1
```



Paso1
```bash
$ sudo apt-get install ruby-full

$ ruby -v

$ sudo apt-get install sqlite3

$ sqlite3 --version

$ sudo gem install rails

$ rails --version
```
Paso2
Entrar al directorio

sudo apt install yarn

curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -

echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list

sudo apt-get update

sudo apt-get install yarn

rails new blog3

Webpacker successfully installed 🎉 🍰

rails server


Paso3

### Windows
Paso1

Paso2

Paso3

##
