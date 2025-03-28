**Crea una aplicación que permita gestionar el catálogo de una biblioteca.**

**Para ello la aplicación debe:**
- permitir al usuario realizar operaciones básicas de gestión de la biblioteca, tales como:
    1. agregar libros
        - Agregar libros al catálogo: meterá un libro en el catálogo,
          siempre y cuando no esté ya metido,
          y/o haya sitio en el catálogo.
    2. eliminar libros
        - Sacar libro del catálogo: eliminará el libro del catálogo.
    3. buscar libros por ISBN
        - y mostrará los datos de dicho libro.
    4. mostrar todos los libros disponibles.

**Las características de la biblioteca son:**

        nombre, director, catalogo.

**La funcionalidad de la biblioteca es:**
- Buscar información de un libro del catálogo, mostrando todos sus datos.
- Construir catálogo: pedirá el número de libros que se pueden guardar y construirá el catálogo.
- Consultar número de libros del catálogo: mostrará los libros que tiene el catálogo.

**Hay que tener en cuenta las siguientes cosas:**
- En la biblioteca pueden existir o no un catálogo de libros.
- Es imposible que exista un catálogo de libros si no existe una biblioteca.
- Si se puede obtener información de un libro sin que esté en una biblioteca.
- Existe bibliotecas especializadas donde solo puede hacer libros de una temática, así como
bibliotecas con todo tipo de libros. Ambas solo pueden tener Libros.


- En el caso de producirse un fallo en los siguientes casos se deberá de lanzar una excepción
personalizada con mensaje diferente:
  - si no hay hueco en el catálogo para meter libros,
  - si no hay libro en una búsqueda.
  (En todos estos casos el catálogo si existe en la biblioteca)


- En el caso en el que el catálogo no exista y se quieran hacer operaciones sobre el se deberá tratar
la excepción de RunTime que se provoque.


- Siéntete libre de crear tantas clases, interfaces, enum, métodos y propiedades como consideres
necesarias para el funcionamiento de la aplicación.

**Los libros que puede tener una biblioteca pueden ser de:**

        terror, comedia, ensayo o policiaca.

Cada uno de estos libros tienen los siguientes atributos:

    1. terror: autor, numeroPaginas, ISBN, calificación.

    2. comedia: autor, numeroPaginas, ISBN, tipoHumor.

    3. policiaca: autor, numeroPaginas, ISBN, 
                  trama (misterio o intriga), personajes.

**Crea un main donde:**
1. Crea una biblioteca
2. Crea un catálogo de 4 libros
3. Agregar 5 libros al catálogo
4. Muestra la información de todos los libros
5. Exporta todos los libros del catálogo a un fichero llamado libros.ob