# SQL2 - EJERCICIO TT

USE movies_db;
SELECT * FROM movies;
SELECT * FROM genres;
SELECT * FROM actors;


#P.2
#Agregue una película a la tabla movies.
INSERT INTO movies( id, title, rating, release_date, length, genre_id )
VALUES ( 22, "Interestelar", 10.0, '2014-10-26', 170, 5 );


#P.3
#Agregué un géneró a la tabla genres.
INSERT INTO genres( id, name, ranking, active )
VALUES (13, "Romance", 13, 1);


#P.4
#Asocie a la película del Ej 2. con el género creado en el Ej. 3.
UPDATE movies
SET genre_id = 13
WHERE movies.id = 22;


#P.5 
#Modifique la tabla actors para que al menos un actor tenga como
#favorita la película agregada en el Ej.2.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 4;


#P.6
#Cree una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp
SELECT * FROM movies;

CREATE UNIQUE INDEX movies_temp_idx
ON movies_temp (id);
show index from movies_temp;

SELECT * FROM movies_temp;


#P.7
#Elimine de esa tabla temporal todas las películas que hayan ganado
#menos de 5 awards.
DELETE FROM movies_temp
WHERE movies_temp.id in
(SELECT id FROM movies WHERE awards < 5);


#P.8
#Obtenga la lista de todas los géneros que tengan al menos una
#película
SELECT DISTINCT genres.name FROM genres
INNER JOIN movies ON genres.id = movies.genre_id;

#P.9
#Obtenga la lista de actores cuya película favorita haya ganado más
#de 3 awards.
SELECT CONCAT( a.first_name, ' ', a.last_name) AS full_name FROM actors a
INNER JOIN movies ON a.favorite_movie_id = movies.id
WHERE movies.awards > 3;


#P.11
#Cree un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
ADD INDEX title_idx(title);


#P.12
#Chequee que el indice fue creado correctamente.
SHOW INDEX FROM movies;
