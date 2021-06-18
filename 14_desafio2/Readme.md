# Desafío 2 - Tu Casita Tasaciones 

_Repositorio de la API **Tu casita Tasaciones.** para el desafío 2 del It Bootcamp_

_Software Developer: Wilson Andrade M._


# User Stories

    US-0001: Calcular el total de metros cuadrados de una propiedad
    US-0002: Indicar el valor de una propiedad a partir de sus ambientes y medidas. Tener en cuenta que los precios por metro cuadrado están determinados según el barrio.
    US-0003: Determinar cuál es el ambiente más grande.
    US-0004: Determinar la cantidad de metros cuadrados que tiene cada ambiente de una propiedad.



Se implentaron 5 end points tipo **Post** para los requerimientos.

```sh
US-0001: Calcular área total
path: Property/calculateArea
```
```sh
US-0002: Calcular precio propiedad
path: Property/calculatePrice
```
```sh
US-0003: Encontrar la propiedad de mayor precio
path: Property/environmentsBiggest
```
```sh
US-0004: Encontrar área de cada ambiente de una propiedad
path: Property/environmentArea
```
```sh
US-0005: Agregar a la DB una propiedad
path: Property/addProperty
```


Para mayor facilidad de verificación de los end points se anexa una colección en Postman. 

Para revisar el Coverage de los test se agregó el plugin JaCoCo, este genera una carpeta jacoco con una página web donde se puede navegar por todas las implementaciones. Dicha carpeta se encuentra en _14_desafio2/TuCasitaTasaciones/target/site/jacoco/index.html_

Además para la documentación se agregó las dependencias de Swagger. Especialmente porque a diferencia de Java Doc, con Swagger se puede realizar los test directamente desde la página que levanta la misma documentación.
Se encuentra en _http://localhost:8080/swagger-ui.html_

Se realizaron los Test unitarios y test de integración para el Controller, Service y Mapper.

- Colección en Postman para pruebas  [link Postman]
- Resultados de Test coverage con JaCoCo [Link JaCoCo]
- Documentación con Swagger [Link Swagger]




   [link Postman]: <https://www.getpostman.com/collections/720df0f5e1f2d3c55d5b>
   [Link JaCoCo]: </14_desafio2/TuCasitaTasaciones/target/site/jacoco/index.html>
   [Link Swagger]: <http://localhost:8080/swagger-ui.html>
   
  
