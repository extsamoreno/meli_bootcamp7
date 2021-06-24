-- Normalizacion: Proceso de organizacion de datos en una base de datos, asignando una serie de reglas a las relaciones obtenidas,
-- con el objeto de minimizar la redundancia de datos, facilitando la posterior gestion.

-- ejercicio 2
-- Agregue una pelicula a la tabla movies
INSERT INTO movies (title, rating, release_date,genre_id) values ("peliculon",7, 123);

-- ejercicio 2.a
-- Agregué un géneró a la tabla genres.
INSERT INTO genres (name, ranking) values ("melodramatica", 1234124);

-- ejercicio 3
-- Asocie a la película del Ej 2. con el género creado en el Ej. 2.alter
UPDATE movies set genre_id = 16 where id = 22;

-- ejercicio 4
-- Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.
UPDATE actors set favorite_movie_id = 22 where id = 49;

-- ejercicio 5
-- Cree una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS (SELECT * FROM movies);

-- ejercicio 6
-- Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy WHERE awards < 5;

-- ejercicio 7
-- Obtenga la lista de todas los géneros que tengan al menos una película.
SELECT DISTINCT genres.name
FROM genres
JOIN movies m ON m.genre_id = genres.id; 

-- ejercicio 8
-- Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.first_name, actors.favorite_movie_id
FROM actors
JOIN movies m ON m.id = actors.favorite_movie_id
WHERE awards > 3

-- ejercicio 9
-- 

-- ejercicio 10
-- Los indices son un mecanismo que usan las bases de datos para optimizar las consultas en SQL
-- sirven para mejorar la performance  en Queries complejas.

-- ejercicio 11
-- Cree un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_name_idx ON movies(title)

-- Ejercicio 12
-- Chequee que el indice fue creado correctamente.
SHOW INDEX FROM movies;





