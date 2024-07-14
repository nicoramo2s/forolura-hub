<h1>
  <b>API Rest Foro</b>
</h1>

<h2>
    Desafio planteado por <a href="https://www.aluracursos.com/">Alura latam</a> y <a href="https://www.oracle.com/ar/">Oracle</a> para el progama ONE
</h2>

![fondo alura y oracle](img/img7.png)

<h2>
  Informacion sobre el desafio planteado
</h2>

<p>Un foro es un espacio donde todos los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos. 
  Aquí en Alura Latam, los estudiantes utilizan el foro para sacar sus dudas sobre los cursos y proyectos en los que participan. 
  Este lugar mágico está lleno de mucho aprendizaje y colaboración entre estudiantes, profesores y moderadores.
</p>
<p>
  Ya sabemos para qué sirve el foro y conocemos su aspecto, ¿pero sabemos cómo funciona detrás de escena? Es decir, ¿dónde se almacenan las informaciones? 
¿Cómo se tratan los datos para relacionar un tópico con una respuesta, o cómo se relacionan los usuarios con las respuestas de un tópico?

Este es nuestro desafío, llamado ForoHub: en él, vamos a replicar este proceso a nivel de back end y, para eso, crearemos una API REST usando Spring.

</p>

<p>
  Nuestra API se centrará específicamente en los tópicos, y debe permitir a los usuarios:
</p>
<ul>
  <li>
    Crear un nuevo tópico;
  </li>
  <li>
    Mostrar todos los tópicos creados;
  </li>
  <li>
    Mostrar un tópico específico;
  </li>
  <li>
    Mostrar un tópico específico;
  </li>
  <li>
    Actualizar un tópico;
  </li>
  <li>
    Eliminar un tópico.
  </li>
</ul>

<p>
  Es lo que normalmente conocemos como CRUD* (CREATE, READ, UPDATE, DELETE) y es muy similar a lo que desarrollamos en LiterAlura, pero ahora de forma completa, 
agregando las operaciones de UPDATE y DELETE, y usando un framework que facilitará mucho nuestro trabajo.
</p>

<p>
  *Traducción libre (en orden): Crear, Consultar, Actualizar y Eliminar.
</p>

<p>
  En resumen, nuestro objetivo con este challenge es implementar una API REST con las siguientes funcionalidades:
</p>

<ol>
  <li>
    API con rutas implementadas siguiendo las mejores prácticas del modelo REST;
  </li>
  <li>
    Validaciones realizadas según las reglas de negocio;
  </li>
  <li>
    Implementación de una base de datos relacional para la persistencia de la información;
  </li>
  <li>
    Servicio de autenticación/autorización para restringir el acceso a la información.
  </li>
</ol>

<h2>
  Configuraciones del entorno
</h2>

<ul>
  <li>
    Java (versión 17) 
  </li>
  <li>
    Maven (versión 4)
  </li>
  <li>
    Spring Boot (versión 3.3.0)
    Dependencias:
      <ul>
        <li>
          Lombok  
        </li>
        <li>
          Spring Web
        </li>
        <li>
          Spring Boot DevTools
        </li>
        <li>
          Spring Data JPA
        </li>
        <li>
          Flyway Migration
        </li>
        <li>
          MySQL Driver
        </li>
        <li>
          Validation
        </li>
        <li>
          Spring Security
        </li>
      </ul>
  </li>
</ul>

<h2>
    Documentacion
</h2>

<p>
    Se implemento Swagger para documentar la aplicación, con el objetivo de generar
    interfaz amigable y accesible.
</p>

![Interfaz de Swagger](img/img.png)

<p>
    Para poder hacer uso de la API es necesario cargar un usuario en bd, por razones de tiempo
no se a generado un end point para realizar tal cosa, por lo tanto debe realizarse de forma la inserción
en la bd "<code>INSERT INTO usuarios (nombre, email, contrasenia)
VALUES ('su nombre', 'su email' , 'contraseña');</code>".
Cabe destacar que la contraseña debe de estar cifrada con BCrypt a la hora de guardarla en la db.
</p>

<p>
    Una vez realizada la carga de un nuevo usuario, podemos hacer uso de la interface brindada por Swagger
para poder testear el uso de la API.
</p>

<p>
    Como primer paso, para poder usar la interfaz de Swagger, debemos logearnos con los datos del usuario generado
anteriormente.
</p>

<p>
    Ir a autenticacion-controller, desplegamos y clickeamos Try it now.
<br>
Cargamos los datos de login en el request body y clic en Execute.
</p>

![autenticacion-controller](img/img1.png)

<p>
    Como respuesta obtenemos un estado 200, en cuyo body se encuentra el token generado para poder autenticar las demás 
pruebas.
</p>

![respuesta de login](img/img2.png)

<p>
    Copiamos el token y lo insertamos dentro de Autorize , en el campo value y clickeamos Authorize.
</p>

![ubicacion Authorize](img/img3.png)

![Available authorizations](img/img4.png)

<p>
    Ahora estamos listos para usar la API.
</p>

<p>
    A modo de ejemplo ponemos imagenes de como listar los topicos.
</p>

<p>
    Request listado de Topicos.
</p>

![request listado de topico](img/img5.png)

<p>
    Response listado de Topicos.
</p>

![response listado topicos](img/img6.png)

<p>
    Cabe destacar que todos los listados estan paginados.
</p>

<h2>
    Estado del proyecto
</h2>

<ul>
    <li>
        El desafio planteado por <a href="https://www.aluracursos.com/">Alura latam</a> y <a href="https://www.oracle.com/ar/">Oracle</a> esta completo.
    </li>
    <li>
        Ademas se agregaron end point para: crear, leer, modificar y borrar, tanto cursos, como respuestas.
A modo de desafio personal.
    </li>
</ul>

<p>A modo personal resta generar end point para usuarios y generar autorizacion por roles en toda la API.</p>
