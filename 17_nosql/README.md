## CALENTAMIENTO

¿Cuántas colecciones tiene la base de datos?
- 2 Colecciones

¿Cuántos documentos en cada colección? ¿Cuánto pesa cada colección?

- Cantidad de documentos por coleccion
```
db.restaurants.find().count()
 -> 25359
db.neighborhoods.find().count()
 -> 195 
```

- Peso coleccion 

![image](https://user-images.githubusercontent.com/84474950/123296087-f3508980-d4db-11eb-82ee-b8ae529bb3ca.png)


¿Cuántos índices en cada colección? 

- Ambos tienen un indice

¿Cuánto espacio ocupan los índices de cada colección?


![image](https://user-images.githubusercontent.com/84474950/123296344-2c88f980-d4dc-11eb-8392-ad99c1b147c2.png)
- restaurants ->  236KB
- neighborhoods -> 4KB


Traer un documento de ejemplo de cada colección. db.collection.find(...).pretty() nos da un formato más legible.

```
db.restaurants.find({restaurant_id:'40356018'}).pretty()
```

Para cada colección, listar los campos a nivel raíz (ignorar campos dentro de documentos anidados) y sus tipos de datos.

## SQL
1. Devolver restaurant_id, name, borough y cuisine pero excluyendo _id para un documento (el primero).

```
db.restaurants.find({},{restaurant_id:1,name:1,borough:1,cuisine:1,_id:0}).limit(1)
```

2. Devolver restaurant_id, name, borough y cuisine para los primeros 3 restaurantes que contengan 'Bake' en alguna parte de su nombre.

```
db.restaurants.find({name: /Bake/},{restaurant_id:1,name:1,borough:1,cuisine:1,_id:0}).limit(3)
```

3. Contar los restaurantes de comida (cuisine) china (Chinese) o tailandesa (Thai) del barrio (borough) Bronx. Consultar or versus in.

```

SHOW
 -> db.restaurants.find({$or:[{cuisine:'Chinese'},{cuisine:'Thai'}],borough:'Bronx'},{restaurant_id:1,name:1,borough:1,cuisine:1,_id:0})

COUNT
 -> db.restaurants.count({$or:[{cuisine:'Chinese'},{cuisine:'Thai'}],borough:'Bronx'})
  
  OR
  
 -> db.restaurants.find({$or:[{cuisine:'Chinese'},{cuisine:'Thai'}],borough:'Bronx'}).count()
```

## NO SQL

1. Traer 3 restaurantes que hayan recibido al menos una calificación de grade 'A' con score mayor a 50. Una misma calificación debe cumplir con ambas condiciones simultáneamente; investigar el operador elemMatch.

```
db.restaurants.find({ "grades": { $elemMatch: {grade: 'A',score: { $gte:50 } } } })
```

2. ¿A cuántos documentos les faltan las coordenadas geográficas? En otras palabras, revisar si el tamaño de address.coord es 0 y contar.

```
db.restaurants.find({ "address.coord": {$size:0}}).count()
```

3. Devolver name, borough, cuisine y grades para los primeros 3 restaurantes; de cada documento solo la última calificación. Ver el operador slice.

```
db.restaurants.find({},{name:1,borough:1,cuisine:1,grades: { $slice: -1 },_id:0}).limit(3)
```


## DESAFIANTES

1. ¿Cuál es top 3 de tipos de cocina (cuisine) que podemos encontrar entre los datos? Googlear "mongodb group by field, count it and sort it". Ver etapa limit del pipeline de agregación.

```
db.restaurants.aggregate([{ $group: { _id: "$cuisine", count: {$sum: 1} }},{$sort:{'count':-1}},{$limit: 3}])
```
2. ¿Cuáles son los barrios más desarrollados gastronómicamente? Calcular el promedio ($avg) de puntaje (grades.score) por barrio; considerando restaurantes que tengan más de tres reseñas; ordenar barrios con mejor puntaje arriba. Ayuda:

   - match es una etapa que filtra documentos según una condición, similar a db.orders.find(<condición>).
   - Parece necesario deconstruir las listas grades para producir un documento por cada puntaje utilizando la etapa unwind.

```
db.restaurants.aggregate([{ $unwind : "$grades" },{$project: {borough:1,score:"$grades.score",restaurant_id:1}},{ $group: { _id: "$borough", averageScore: {$avg: "$score"} }},{$sort:{averageScore:-1}},{$limit:3}])
```


3. Una persona con ganas de comer está en longitud -73.93414657 y latitud 40.82302903, ¿qué opciones tiene en 500 metros a la redonda? Consultar geospatial tutorial.
4. 
```
db.neighborhoods.createIndex({ geometry: "2dsphere" })
db.neighborhoods.find({ geometry : { $nearSphere: { $geometry: { type: "Point", coordinates: [ -73.93414657, 40.82302903 ] }, $maxDistance: 500 } } })
```
