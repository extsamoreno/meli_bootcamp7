# DESAFÍO 1 JAVA - SPRING


## notas aclaratorias
En la carpeta __10_desafió1__ donde se encuentra este proyecto también hay un archivo con las colecciones de Postman para poder testear la API

Cuando se carga la API también se cargan al mismo tiempo una serie de datos ''seed'' para facilitar los test. Estos datos se pueden encontrar en la carpeta resources del proyecto

Como forma de modularize el proyecto se pensó al ``post`` y al ``product`` como entidades diferentes (a forma de ver en una DB como dos tablas diferentes), no tiene ninguna funcionalidad adicional, pero se decidió que puede ser más escalable presentarlo de esa forma

Tanto el ``post``, como el ``promoPost`` son tratados como las mismas entidades, no se hace 

En el EndPoint myFollowedPost (US006), se agregó la posibilidad de pasar por parámetro la cantidad de dias anteriores para que una publicación sea devuelta. Por default se deja 14 dias para cumplir con la consigna

En el EndPoint Pomolist (US012) se agregó un parámetro filter. Si no se pasa devuelve los posts en promotion (tal como pide la consigna), pero si se pasa 'all' devuelven todos los post de ese usuario

Se agregró un nuevo EndPoint que permite borrar un post:


| Method    | Sign                                       |
|-----------|--------------------------------------------|
| DELETE    | /products/delete/{postId}                  |       
| Response  | Status 200 (OK), Status 400 (Bad Requests) |
             

|Parámetros |  Tipo | Descripción Ejemplo          |
|-----------|-------|------------------------------|
|postId     | Int   | Numero que identifica un post|


