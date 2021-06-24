#1.Explique el concepto de normalización y para que se utiliza.
#La normalizacion consiste en estandarizar las tablas siguiendo unas reglas llamadas formas normales que nos permiten eliminar redundancias e inconsistencias en la base de datos.

#2.Agregue una película a la tabla movies.
INSERT INTO movies (title, rating, awards,release_date, length, genre_id) VALUES ('The discovery', '8.2', '2', '2012-05-04 00:00:00', '90', '3');

#3.Agregué un géneró a la tabla genres.
INSERT INTO genres (created_at, name, ranking, active) VALUES ('2011-01-02 00:00:00', 'Horror', '13', '1');

#4.Asocie a la película del Ej 2. con el género creado en el Ej. 3.
UPDATE movies
SET genre_id = 13
WHERE movies.id = 22;

#5.Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.
UPDATE actors
SET actors.favorite_movie_id = 22
WHERE actors.id = 1;

#6.Cree una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temporal_movies
SELECT * FROM movies;

#7.Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temporal_movies
WHERE temporal_movies.awards < 5;

#8.Obtenga la lista de todas los géneros que tengan al menos una película.
SELECT gen.* from genres gen
WHERE gen.id IN (SELECT genre_id FROM movies);

#9.Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT act.* FROM actors act
WHERE act.favorite_movie_id IN (SELECT m.id FROM movies m
									WHERE m.awards > 3);

#10.Utilice el explain plan para analizar las consultas del Ej.6 y 7.
EXPLAIN SELECT gen.* from genres gen
WHERE gen.id IN (SELECT genre_id FROM movies);

EXPLAIN DELETE FROM temporal_movies
WHERE temporal_movies.awards < 5;

EXPLAIN SELECT act.* FROM actors act
WHERE act.favorite_movie_id IN (SELECT m.id FROM movies m
									WHERE m.awards > 3);
#11.Qué son los índices? Para qué sirven?
#Los indices son un mecanismo para optimizar las consultas y mejorar el acceso a dato ya que proporcionan una ruta mas directa a los registros. Evitan recorrer secuencialmente las tablas indexadas.

#12.Cree un índice sobre el nombre en la tabla movies.
CREATE INDEX index_name
ON movies (title);

#13.Chequee que el indice fue creado correctamente.
SHOW INDEX FROM movies;