# Punto 2
SELECT * FROM movies;

#Punto 3
SELECT first_name, last_name, rating FROM actors;

#Punto 4
SELECT title AS "titulo" FROM series;

#Punto 5
#No se resuelve ya que no existe el atributo type en series.

#Punto 6
SELECT ac.first_name, ac.last_name FROM actors ac
WHERE ac.rating > 7.5;

#Punto 7
SELECT mov.title, mov.rating, mov.awards FROM movies mov
WHERE mov.rating > 7.5 AND mov.awards > 2;

#Punto 8
SELECT mov.title, mov.rating FROM movies mov
ORDER BY mov.rating;

#Punto 9
SELECT mov.title FROM movies mov
LIMIT 3;

#Punto 10
SELECT mov.* FROM movies mov
ORDER BY mov.rating DESC
LIMIT 5;

#Punto 11
SELECT mov.* FROM movies mov
ORDER BY mov.rating DESC
LIMIT 5, 5;

#Punto 12
SELECT act.* FROM actors act
LIMIT 10;

#Punto 13
SELECT act.* FROM actors act
LIMIT 10 OFFSET 20;

#Punto 14
SELECT act.* FROM actors act
LIMIT 10 OFFSET 40;

#Punto 15
SELECT mov.title, mov.rating FROM movies mov
WHERE mov.title LIKE '%Toy Story%';

#Punto 16
SELECT act.* FROM actors act
WHERE act.first_name LIKE 'Sam%';

#Punto 17
SELECT mov.title FROM movies mov
WHERE YEAR(mov.release_date) BETWEEN 2004 AND 2008;

#Punto 18
SELECT mov.title FROM movies mov
WHERE mov.rating > 3 
AND mov.awards > 1 
AND YEAR(mov.release_date) BETWEEN 1988 AND 2009
ORDER BY mov.rating;

#Punto 19
SELECT mov.title FROM movies mov
WHERE mov.rating > 3 
AND mov.awards > 1 
AND YEAR(mov.release_date) BETWEEN 1988 AND 2009
ORDER BY mov.rating DESC
LIMIT 3 OFFSET 10;