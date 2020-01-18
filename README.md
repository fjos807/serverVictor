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
**C) Yarn**

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


### Windows

A continuación se detallan los pasos para esta plataforma. Tome en cuenta que los comandos presentados deben ser ejecutados en **la línea de comandos**.

#### Dependencias

**A) Git**
Descargue el [instalador de Git](https://github.com/git-for-windows/git/releases/download/v2.25.0.windows.1/Git-2.25.0-64-bit.exe) y siga los pasos comunes de instalación (aka siguiente, siguiente, siguiente :man_shrugging: ).

![Instalador de Git](https://user-images.githubusercontent.com/31530117/72658281-8d191c00-3963-11ea-9a2a-7a1d7ab15081.png)


**B) Node.js**

Descargue el [instalador de Node.js](https://nodejs.org/dist/v12.14.1/node-v12.14.1-x64.msi) y siga los pasos comunes de instalación.

![Instalador de Node](https://user-images.githubusercontent.com/31530117/72658426-8f7c7580-3965-11ea-8c65-565a1187ceac.png)

**C) Yarn**

Descargue el [instalador de Yarn](https://yarnpkg.com/latest.msi) y siga los pasos comunes de instalación.

![Instalador de Yarn](https://user-images.githubusercontent.com/31530117/72658455-1fbaba80-3966-11ea-9f3f-c988fbc14760.png)

#### Ruby, SQLite3 y Rails

**A) Instalación de Ruby**

Descargue el [instalador de Ruby](https://github.com/oneclick/rubyinstaller2/releases/download/RubyInstaller-2.6.5-1/rubyinstaller-devkit-2.6.5-1-x64.exe) y siga los pasos comunes de instalación.

![Instalador de Ruby](https://user-images.githubusercontent.com/31530117/72658567-8f7d7500-3967-11ea-9744-c019fed4abfe.png)

Al llegar a este punto seleccione la opción marcada

![Instalador de Ruby opción 1](https://user-images.githubusercontent.com/31530117/72658577-b340bb00-3967-11ea-9cd2-867ee394f004.png)

Al terminar este proceso se abrirá una ventana de la terminal, digite "3" y presione ENTER

![Instalador de Ruby opción 2](https://user-images.githubusercontent.com/31530117/72658592-f6029300-3967-11ea-94df-b599c16a7c2a.png)

Una vez completada la instalación observará un mensaje de confirmación.

Luego, se verifica la instalación desde el **cmd** .
```bash
C:\Users\user> ruby -v 

2.5.1
```

**B) Instalación de SQLlite3**
```bash
C:\Users\user> gem install sqlite3 --platform=ruby -- --with-sqlite3-include=/c:/dev/sqlite3/ --with-sqlite3-lib=/c:/dev/sqlite3/.libs/
```

**C) Instalación de Rails**
```bash
C:\Users\user> gem install rails
```
Se verifica la instalación
```bash
C:\Users\user> rails --version

Rails 6.0.2.1
```
