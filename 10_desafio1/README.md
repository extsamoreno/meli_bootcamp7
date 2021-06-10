# IT Bootcamp - Desafío práctico con Spring

## Aclaraciones

Para la realización de este desafío se consideró que todos los usuarios pueden ser vendedores y seguirse entre ellos.

Dentro de la carpeta **postman-endpoints** se encuentra un .json con la colección de Postman que contiene todos los endpoints necesarios para comprobar el funcionamiento de la API.

A fines de facilitar las pruebas se incluyó dentro de la carpeta resources del proyecto un archivo json que contiene un listado de usuarios precargados. En el caso de las publicaciones y los productos no se crearon archivos ya que ambas entidades se generan dinámicamente cuando se hace un POST según los requerimientos US 0005 y US 0010 pero si existe un archivo products.json con ejemplos de productos para utilizarlos al crear posts. 

Para las publicaciones se definió controlar si el par userId-postId ya existe se lance una excepción adviertiendo que ese post ya fue creado por ese usuario, con respecto al producto se controla que el usuario no haya realizado ya una publicación con ese producto, lanzando una excepción si el par userId-productId ya existe. 

Las creaciones de una publicación normal y con promoción se realizan de la misma manera aunque se llamen desde distintos endpoints (/newpost y /newpromopost), se consideró que las publicaciones son el mismo modelo con la diferencia que las que tienen promoción tienen el atributo hasPromo en true y un valor en el atributo discount.

Con respecto a la fecha de las publicaciones se realizó una validación para controlar si la fecha ingresada es mayor a la fecha actual y de ser así se lanza una excepción.

