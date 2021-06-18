## TuCasita Tasaciones
* En el proyecto se incluye la colección de PostMan el archivo `TuCasitaTasaciones.postman_collection.json`
para poder ejecutar los requerimientos funcionales de la API.
* Se cuenta con una carga inicial de tres propiedades, las mismas se pueden visualizar ejecutando una petición
GET a la url `localhost:8080/properties/list`. (Esta petición se incluye a su vez en la colección).
* Se cuenta con una precarga de barrios con su respectivo precio por metro cuadrado. Estos se pueden ver en
el archivo `distritcs.json` dentro de la carpeta de recursos del proyecto.
* Se puede registrar una nueva propiedad utilizando la petición POST que se encuentra incluída en la colección.
* Las demás peticiones se realizan a partir del ID de una propiedad