#1) Concepto de Normalización
#	El proceso de normalización permite estandarizar los datos en nuestras bases de datos. Elimina redundancias e 
#	inconsistencias, dismunye problemas de actualización de los datos en las tablas y facilita la gestión de la base de datos. 

#2) 
INSERT INTO movies (title, rating, awards, release_date, length) 
VALUES ("Iron Man", 9.5, 3, "2008-09-09", 2); 

#3)
INSERT INTO genres (name, ranking, active)
VALUES ("Realismo Mágico", 13, 1);

#4) 
UPDATE movies 
SET genre_id = 13
WHERE id = 22;

#5)
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 3;

#6)
CREATE TEMPORARY TABLE movies_temp
	SELECT * FROM movies;

#7)
DELETE FROM movies_temp
WHERE awards < 5;

#8) 
SELECT gen.name, COUNT(*) as total_movies
FROM genres gen 
JOIN movies mov ON mov.genre_id = gen.id
GROUP BY gen.id HAVING total_movies >= 1;

#9) 
SELECT act.*
FROM actors act
JOIN movies mov ON act.favorite_movie_id = mov.id
WHERE mov.awards > 3;

#10)

#11)
#	Los índices son mecanismos que nos permiten optimzar consultas en SQL. Definen un puntero de acceso a datos para obtener una ruta 
#	hacia los registros de una forma más directa. Normalmente los índices se definden sobre aquellos campos de los que se sabe que se realizarán
#	una gran cantidad de consultas, ya que esto permite reducir los tiempos de respuesta.

#12)
CREATE INDEX title_idx ON movies(title);

#13)
SHOW INDEX FROM movies;


