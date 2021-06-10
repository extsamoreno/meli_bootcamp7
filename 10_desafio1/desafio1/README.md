# Desafío 1

Utilizar el archivo desafio1.postman_collection.json para las consultas.

Se normalizaron los campos de las consultas para utilizar camelCase.


# Trabajo Futuro

- Refactorizar las excepciones para lograr una jerarquía de errores más especificos.
- Refactorizar el esquema de repositorios, para tener un objeto monolitico que maneje las diferentes bases de datos.
- Agregar más excepciones.


# Comentarios

Para los repositorios utilicé una interfaz generica. Creo que me gustá más la idea de tener interfacez genericas para definir un comportamiento común que una interfaz por tipo de componente. Para el caso de los servicios, estuve revisando como poder utilizar una interfaz generica, pero no encontré realmente que fuera necesario considerando que no encontré mucha funcionalidad común entre los servicios. Pienso que puede ser más útil para sistemas más grandes.

Tuve un problema al tratar de definir campos en los DTO o modelos con el tipo de dato LocalDate, pero por un tema de dependencias que no logré solucionar fue necesario parsearlos como Date.

Estuve probando un esquema de nombres pero creo que la consistencia puede ser mejor.
