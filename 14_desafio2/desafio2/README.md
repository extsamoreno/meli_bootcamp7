###DESAFIO 2 - COMENTARIOS:

1. La aplicación consta de tres endpoints:
    * http://localhost:8080/properties/features/{prop_name} : Método GET que da solución a los requerimientos US-0001, US-0002 y US-0003.
    * http://localhost:8080/properties/environments/{prop_name} : Método GET que da solución al requerimiento US-0004.
    * http://localhost:8080/properties/registerProperty : Método POST para registrar una nueva propiedad.

2. Para registrar una nueva Propiedad solo se requiere el nombre el barrio, no es necesario el precio del metro cuadrado en el barrio, la aplicación comprueba que el barrio existe en la base de datos y ajusta el precio correspondiente.
   
3. La aplicación cuenta con unos datos base en archivos JSON, en la carpeta "resources", para alimentar el repository de House y District.
    * House cuenta con los siguientes prop_name: 'Casa101', 'Casa102' y 'Casa103'.
    * District cuenta con los siguientes district_name: 'Santa Fe', 'Palermo' y 'Carmen'.
4. La propiedad 'Casa103' tiene asignada como barrio el nombre de 'Restrepo', el cual no se encuentra la base de datos de Districts; esto con el proposito de realizar pruebas de validación.