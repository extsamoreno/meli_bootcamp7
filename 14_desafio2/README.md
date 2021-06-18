# IT Bootcamp - Desafío práctico con Spring

## Aclaraciones

Dentro de la carpeta **postman-endpoints** se encuentra un .json con la colección de Postman que contiene todos los endpoints necesarios para comprobar el funcionamiento de la API.

Se agregaron dos endpoints además de los necesarios según el requerimiento, un POST para crear Properties (dentro de la colección hay 3 request que cargan 3 propiedades), no se controla si la propiedad ya fue ingresada, si vuelve a realizarse el POST se vuelve a agregar con otro ID generado automáticamente. También hay un GET para obtener todas las propiedades que han sido cargadas. Luego los 4 endpoints correspondientes a los requerimientos necesitan el ID de una propiedad cargada para poder devolver lo que piden.

Los barrios están pre cargados en un .json y se controla que al momento de ingresar una propiedad el nombre del barrio exista en ese archivo.



