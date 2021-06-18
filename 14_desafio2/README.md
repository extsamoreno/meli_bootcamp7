# Tu Casita Tasaciones

La empresa “TuCasita Tasaciones” necesita poder calcular los metros cuadrados y el costo de distintas propiedades con las que cuenta en su cartera de clientes.
Para ello, solicita por cada propiedad: un nombre, un barrio y la cantidad de ambientes que posee; al mismo tiempo, cada ambiente contiene un nombre, un ancho y un largo.

###### US-0001: Calcular el total de metros cuadrados de una propiedad
###### US-0002: Indicar el valor de una propiedad a partir de sus ambientes y medidas.
###### US-0003: Determinar cuál es el ambiente más grande.
###### US-0004: Determinar la cantidad de metros cuadrados que tiene cada ambiente de una propiedad.

## Instalación

Importar en postman la colección
```
test.postman_collection
```

Crear el environment "development" y agregar las variables:
```
base-url : http://localhost:8080
ownership-id : 1
```

Al crear estas dos variables el test del post se encarga de usar el ownership que se cargue a través del primer llamado. Por lo que facilita el uso del postman a solo realizar las peticiones directamente.