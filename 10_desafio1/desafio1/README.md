# Desafío 1

Utilizar el archivo desafio1.postman_collection.json para las consultas.

Se normalizaron los campos de las consultas para utilizar camelCase.


# Trabajo Futuro

- Refactorizar las excepciones para lograr una jerarquía de errores más especificos.
- Refactorizar el esquema de repositorios, para tener un objeto monolitico que maneje las diferentes bases de datos.


# Comentarios

Para los repositorios utilicé una interfaz generica. Creo que me gustá más la idea de tener interfacez genericas para definir un comportamiento común que una interfaz por tipo de componente. Para el caso de los servicios, estuve revisando como poder utilizar una interfaz generica, pero no encontré realmente que fuera necesario considerando que no encontré mucha funcionalidad común entre los servicios, pero pienso que puede ser más útil para sistemas más grandes.
