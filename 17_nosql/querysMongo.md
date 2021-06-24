## Calentamiento 

1. ¿Cuántas colecciones tiene la base de datos?

R/ Tiene dos colecciones

2. ¿Cuántos documentos en cada colección? ¿Cuánto pesa cada colección?

```JSON
-db.restaurant.count()
25359
-db.neighboorhood.count()
195
-db.restaurant.totalSize()
6725632
-db.neighboorhood.totalSize()
1937408
```

3. ¿Cuántos índices en cada colección? ¿Cuánto espacio ocupan los índices de cada
colección?

```JSON
db.restaurant.getIndexes()
[ { v: 2, key: { _id: 1 }, name: '_id_' } ]
```


4. Traer un documento de ejemplo de cada colección. db.collection.find(...).pretty() nos da
un formato más legible

```JSON
db.restaurant.find().limit(1)
{ _id: ObjectId("5eb3d668b31de5d588f4292a"),
  address: 
   { building: '2780',
     coord: [ -73.98241999999999, 40.579505 ],
     street: 'Stillwell Avenue',
     zipcode: '11224' },
  borough: 'Brooklyn',
  cuisine: 'American',
  grades: 
   [ { date: 2014-06-10T00:00:00.000Z, grade: 'A', score: 5 },
     { date: 2013-06-05T00:00:00.000Z, grade: 'A', score: 7 },
     { date: 2012-04-13T00:00:00.000Z, grade: 'A', score: 12 },
     { date: 2011-10-12T00:00:00.000Z, grade: 'A', score: 12 } ],
  name: 'Riviera Caterer',
  restaurant_id: '40356018' }
db.neighboorhood.find().limit(1)
{ _id: ObjectId("55cb9c666c522cafdb053a1a"),
  geometry: 
   { coordinates: 
      [ [ [ -73.94193078816193, 40.70072523469547 ],
          [ -73.9443878859649, 40.70042452378256 ],
          [ -73.94424286147482, 40.69969927964773 ],
          [ -73.94409591260093, 40.69897295461309 ],
          [ -73.94394947271304, 40.69822127983908 ],
          [ -73.94391750192877, 40.69805620211356 ],
          [ -73.94380383211836, 40.697469265449826 ]]],
     type: 'Polygon' },
  name: 'Bedford' }
```

5. Para cada colección, listar los campos a nivel raíz (ignorar campos dentro de
documentos anidados) y sus tipos de datos

```JSON
db.restaurant.find({}, {_id:0, borought:1, cuisine:1, name:1, restuarant_id:1}).limit(2)
```

```JSON
{ cuisine: 'American', name: 'Riviera Caterer' }
{ cuisine: 'Delicatessen', name: 'Wilken\'S Fine Food' }
```

# SQL 

2. Devolver restaurant_id, name, borough y cuisine para los primeros 3 restaurantes que contengan 'Bake'
en alguna parte de su nombre.


```JSON
db.restaurant.find({}, {name: /Bake/}).limit(3)
```

```JSON
{_id: ObjectId("5eb3d668b31de5d588f4292a"),
  name: { pattern: 'Bake', options: '' } }
{ _id: ObjectId("5eb3d668b31de5d588f4292b"),
  name: { pattern: 'Bake', options: '' } }
{ _id: ObjectId("5eb3d668b31de5d588f4292c"),
  name: { pattern: 'Bake', options: '' } }
```

3. Contar los restaurantes de comida (cuisine) china (Chinese) o tailandesa (Thai) del barrio (borough)
Bronx. Consultar or versus in

```JSON
db.restaurant.count({borough : "Bronx", cuisine : {$in : ["Chinese", "Thai"] }})
325
```
# NoSQL

1. Traer 3 restaurantes que hayan recibido al menos una calificación de grade 'A' con score mayor a 5. Una
misma calificación debe cumplir con ambas condiciones simultáneamente; investigar el operador
elemMatch.

```JSON
db.restaurant.find( {grades: {$elemMatch :  { grade : "A", score: { $gte: 5 }}}})
```

2. ¿A cuántos documentos les faltan las coordenadas geográficas? En otras palabras, revisar si el tamaño de
address.coord es 0 y contar.

```JSON
db.restaurant.find({"address.coord" : {$size : 0}}).count()
```

3. Devolver name, borough, cuisine y grades para los primeros 3 restaurantes; de cada documento solo la
última calificación. Ver el operador slice.

```JSON
db.restaurant.find({},{name : 1, cuisine: 1, borough: 1 , grades:{$slice : -1}}).limit(3)
```

```JSON
{ _id: ObjectId("5eb3d668b31de5d588f4292a"),
  borough: 'Brooklyn',
  cuisine: 'American',
  grades: [ { date: 2011-10-12T00:00:00.000Z, grade: 'A', score: 12 } ],
  name: 'Riviera Caterer' }
{ _id: ObjectId("5eb3d668b31de5d588f4292b"),
  borough: 'Brooklyn',
  cuisine: 'Delicatessen',
  grades: [ { date: 2011-10-14T00:00:00.000Z, grade: 'A', score: 9 } ],
  name: 'Wilken\'S Fine Food' }
{ _id: ObjectId("5eb3d668b31de5d588f4292c"),
  borough: 'Staten Island',
  cuisine: 'Jewish/Kosher',
  grades: [ { date: 2012-01-24T00:00:00.000Z, grade: 'A', score: 9 } ],
  name: 'Kosher Island' }
```
# Desafiante 

1. ¿Cuál es top 3 de tipos de cocina (cuisine) que podemos encontrar entre los datos? Googlear "mongodb group by
field, count it and sort it". Ver etapa limit del pipeline de agregación.

```JSON
db.restaurant.aggregate({$group : {_id : "$cuisine", count:{$sum:1}}}, {$sort: {count:-1}}, { $limit: 3 })
```

```JSON
{ _id: 'American', count: 6183 }
{ _id: 'Chinese', count: 2418 }
{ _id: 'Café/Coffee/Tea', count: 1214}
```
2. ¿Cuáles son los barrios más desarrollados gastronómicamente? Calcular el promedio ($avg) de puntaje
(grades.score) por barrio; considerando restaurantes que tengan más de tres reseñas; ordenar barrios con mejor
puntaje arriba.

```JSON
db.restaurant.aggregate(
   [ 
      { $match : 
         {"$expr":{$gte:[{$size:"$grades"},3]}}},
   { $unwind: "$grades" },
   {$group : 
   {
      _id : "$cuisine",
      
      avg :{$avg:"$grades.score"}}
   }])
```

```JSON
{ _id: 'Ice Cream, Gelato, Yogurt, Ices',
  avg: 8.422382671480145 }
{ _id: 'Polynesian', avg: 14.6 }
{ _id: 'Hotdogs/Pretzels', avg: 5.0212765957446805 }
{ _id: 'Indian', avg: 12.956223175965665 }
{ _id: 'Tapas', avg: 11.38961038961039 }
{ _id: 'Caribbean', avg: 12.194630872483222 }
{ _id: 'Japanese', avg: 12.871336124857251 }
```

3. Una persona con ganas de comer está en longitud -73.93414657 y latitud 40.82302903, ¿qué opciones tiene en
500 metros a la redonda?

```JSON
```
```JSON
```

