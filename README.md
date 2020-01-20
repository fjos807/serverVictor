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

## 2. Realización del taller

**A) Crear el proyecto**

Abra una consola (tanto en Windows como en Linux) y digite el siguiente comando

```bash
$ rails new <Nombre de la aplicación>

```
Al finalizar el proceso de creación se debe mostrar el siguiente mensaje

```bash
Webpacker successfully installed 🎉 🍰
```

**B) Inicie la aplicación**

Ejecute
```bash
$ cd <Nombre de la aplicación>
```


Y luego
```bash
$ rails server
```
Obteniendo como resultado
```bash
=> Booting Puma
=> Rails 6.0.2.1 application starting in development 
=> Run `rails server --help` for more startup options
Puma starting in single mode...
* Version 4.3.1 (ruby 2.5.1-p57), codename: Mysterious Traveller
* Min threads: 5, max threads: 5
* Environment: development
* Listening on tcp://127.0.0.1:3000
* Listening on tcp://[::1]:3000
Use Ctrl-C to stop
```
Por último, solamente debe dirigirse a: localhost:3000

![rails_welcome](https://user-images.githubusercontent.com/31530117/72700361-4bc66f00-3b11-11ea-81fd-e657b2ce59ca.png)

**C) Crear primer controlador y vista**

Ejecute
```bash
$ rails generate controller Welcome index
```

El comando anterior crea un controlador llamado **Welcome** con una acción llamada **index**

Para crear la vista dirigirse a **app/views/welcome/index.html.erb**, borre todo el contenido e ingrese
```bash
<h1>Bienvenido!</h1>
<%= link_to 'Acceder a la aplicación', controller: 'articles' %>
```

Luego, es necesario configurar el controlador para que pueda desplegar la vista. Para ello vaya a **config/routes.rb** y en ese archivo agregue este código luego de la acción get
```bash
root 'welcome#index'
```
Al guardar los cambios y refrescar podremos observar que en la ruta base de la aplicación se muestra el mensaje de bienvenida.

Hasta este punto ya se conocen las funcionalidades básicas de Rails. Ahora vamos a crear un ejemplo más real y con mayor funcionalidad.

**C) Crear un recurso REST (API)**

Diríjase al archivo **config/routes.rb** y en medio de las acciones vistas antes agregue lo siguiente
```bash
resources :articles
```
Este método se encarga de crear todas las rutas de un API básico, se pueden observar mediante
```bash
$ rails routes


       Prefix Verb   URI Pattern                  Controller#Action
welcome_index GET    /welcome/index(.:format)     welcome#index
     articles GET    /articles(.:format)          articles#index
              POST   /articles(.:format)          articles#create
  new_article GET    /articles/new(.:format)      articles#new
 edit_article GET    /articles/:id/edit(.:format) articles#edit
      article GET    /articles/:id(.:format)      articles#show
              PATCH  /articles/:id(.:format)      articles#update
              PUT    /articles/:id(.:format)      articles#update
              DELETE /articles/:id(.:format)      articles#destroy
         root GET    /                            welcome#index

```

**D) Crear el controlador para los artículos**

Ejecute el comando
```bash
$ rails generate controller Articles
```

Luego, localice el archivo **app/controllers/articles_controller.rb** y agregue el siguiente código dentro de la clase
```bash
def new
end
```

**E) Crear nuevos artículos**

Vaya a la ruta **app/views/articles/** y cree un nuevo archivo llamado **new.html.erb**

Luego, agregue el código del formulario

```bash
<%= form_with scope: :article, url: articles_path, local: true do |form| %>
  <p>
    <%= form.label :Título %><br>
    <%= form.text_field :title %>
  </p>
 
  <p>
    <%= form.label :Texto %><br>
    <%= form.text_area :text %>
  </p>
 
  <p>
    <%= form.submit :Guardar%>
  </p>
<% end %>

  <%= link_to 'Atrás', articles_path %>
```
Con el objetivo de almacenar los artículos en la base de datos, creamos el siguiente modelo en la consola

```bash
$ rails generate model Article title:string text:text
```
Una vez creado el modelo, es necesario actualizarlo en la base mediante
```bash
$ rails db:migrate
```

Luego, agregue la siguiente acción al controlador correspondiente
```bash
def create
  @article = Article.new(params.require(:article).permit(:title :text))
 
  @article.save
  redirect_to @article
end
```

**F) Ver un artículo**

Primero, se define la acción en el controlador

```bash
def show
    @article = Article.find(params[:id])
  end
```
Luego, se prepara la vista creando en la ruta **app/views/articles/** un nuevo archivo llamado **show.html.erb**
```bash
<p>
  <strong>Título:</strong>
  <%= @article.title %>
</p>
 
<p>
  <strong>Texto:</strong>
  <%= @article.text %>
</p>
  <%= link_to 'Editar artículo', edit_article_path(@article) %>
  <%= link_to 'Atrás', articles_path %>
```

**G) Ver todos los artículos**

Comenzamos editando la acción **index** del controlador
```bash
def index
    @articles = Article.all
  end
```

Luego, se prepara la vista creando en la ruta **app/views/articles/index.html.erb**
```bash
<h2>Listado de todos los artículos</h2>


  <%= link_to 'Crear artículo', new_article_path %>
  
  <table class="table">
    <tr>
      <th>Título</th>
      <th>Texto</th>
      <th colspan="3">Acciones</th>
    </tr>
   
    <% @articles.each do |article| %>
      <tr>
        <td><%= article.title %></td>
        <td><%= article.text %></td>
        <td><%= link_to 'Ver', article_path(article) %></td>
        <td><%= link_to 'Editar', edit_article_path(article) %></td>
        <td><%= link_to 'Eliminar', article_path(article) ,
                method: :delete,
                data: { confirm: '¿Seguro de que desea eliminar?' } %></td>
      </tr>
    <% end %>
  </table>
```

**H) Agregar validaciones**

Nos dirigimos a la ruta **app/models/article.rb** y se agrega al modelo
```bash
class Article < ApplicationRecord
  validates :title, presence: true,
                    length: { minimum: 5 }
end
```

En el controlador correspondiente se agrega a la acción create
```bash
def create
  @article = Article.new(params.require(:article).permit(:title :text))
 
  if @article.save
    redirect_to @article
  else
    render 'new'
  end
end
```

En la vista **new.html.erb** se modifica el formulario de la siguiente manera
```bash
<%= form_with scope: :article, url: articles_path, local: true do |form| %>
 
  <% if @article.errors.any? %>
    <div id="error_explanation">
      <h2>
        <%= pluralize(@article.errors.count, "errores") %>:
      </h2>
      <ul>
        <% @article.errors.full_messages.each do |msg| %>
          <li><%= msg %></li>
        <% end %>
      </ul>
    </div>
  <% end %>
 
  <p>
    <%= form.label :Título %><br>
    <%= form.text_field :title %>
  </p>
 
  <p>
    <%= form.label :Texto %><br>
    <%= form.text_area :text %>
  </p>
 
  <p>
    <%= form.submit :Guardar%>
  </p>
 
<% end %>
```

**I) Actualizar un artículo**

Agregamos una nueva acción al controlador
```bash
def edit
  @article = Article.find(params[:id])
end
```
Y se crea la vista en **app/views/articles/** llamada **edit.html.erb**
```bash
<h2>Editar artículo</h2>

<%= form_with(model: @article, local: true) do |form| %>
 
    <% if @article.errors.any? %>
      <div id="error_explanation">
        <h2>
          <%= pluralize(@article.errors.count, "errores") %> :
        </h2>
        <ul>
          <% @article.errors.full_messages.each do |msg| %>
            <li><%= msg %></li>
          <% end %>
        </ul>
      </div>
    <% end %>
   
    <p>
      <%= form.label :Título %><br>
      <%= form.text_field :title %>
    </p>
   
    <p>
      <%= form.label :Texto %><br>
      <%= form.text_area :text %>
    </p>
   
    <p>
      <%= form.submit :Actualizar%>
    </p>
   
  <% end %>

  </div>
  <%= link_to 'Atrás', articles_path%>
```

Y se crea la acción de actualizar en el controlador
```bash
def update
    @article = Article.find(params[:id])
   
    if @article.update(params.require(:article).permit(:title, :text))
      redirect_to @article
    else
      render 'edit'
    end
  end
```

**J) Eliminar un artículo**

Creamos la acción de actualizar en el controlador
```bash
def destroy
  @article = Article.find(params[:id])
  @article.destroy
 
  redirect_to articles_path
end
```


Por último, de estilo a las vista generadas y listo. :metal:
