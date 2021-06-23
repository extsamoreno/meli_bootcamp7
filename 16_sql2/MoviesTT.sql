USE movies_db;

#PRACTICA

#Explique el concepto de normalización y para que se utiliza.
#La normalización es un proceso que nos permite estandarizar y validar datos, eliminando redundancias o inconsistencias que posean.

#Agregue una película a la tabla movies.
INSERT INTO movies(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id) VALUES (22, NULL, NULL, 'Ghost: la sombra del amor', 7.1, 3, '1990-07-13 00:00:00', 128, 3);

#Agregue un género a la tabla genres.
INSERT INTO genres (id, created_at, updated_at, name, ranking, active) VALUES (13, '1990-07-13 00:00:00', NULL, 'Romance', 13, 1);

#Asocie a la película del Ej 2. con el género creado en el Ej. 3.
UPDATE movies
SET genre_id = 13
WHERE id = 22;

#Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 3;

#Cree una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies SELECT * FROM movies LIMIT 0;
INSERT INTO temp_movies(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies;


#Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES=0;

DELETE FROM temp_movies
WHERE awards < 5;

#Obtenga la lista de todas los géneros que tengan al menos una película.
SELECT genres.name, count(*) AS cant_peliculas FROM genres JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
having cant_peliculas >= 1;

#Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.first_name FROM actors JOIN movies ON actors.favorite_movie_id = movies.id
WHERE movies.awards > 3;

#Utilice el explain plan para analizar las consultas del Ej.6 y 7.
#No es posible hacer un EXPLAIN de CREATE
#EXPLAIN CREATE TEMPORARY TABLE temp_movies SELECT * FROM movies LIMIT 0; 

EXPLAIN INSERT INTO temp_movies(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies;

EXPLAIN DELETE FROM temp_movies
WHERE awards < 5;

#Qué son los índices? Para qué sirven?
#Los índices nos permiten acelerar el tiempo de realización de consultas. Funcionan como una tabla de búsqueda rápida para nuscar y encontrar registros de forma más rápida.

#Cree un índice sobre el nombre en la tabla movies.
CREATE INDEX title_index ON movies(title);

#Chequee que el indice fue creado correctamente.
SHOW INDEXES FROM movies;
