
-- 2. Agregue una película a la tabla movies.
INSERT INTO movies (title, rating, awards,release_date, length)
VALUES ("Casablanca", 8.4, 10, "1950-08-21", 120);

-- 3.Agregue un genero a la tabla genres.
INSERT INTO genres (created_at, name, ranking)
VALUES (CURDATE(), "Clasico", 13);

-- 4.Asocie a la película del Ej 2. con el género creado en el Ej. 3.
UPDATE movies
SET genre_id = 14
WHERE id = 22;

-- 5.Modifique la tabla actors para que al menos un actor tenga 
-- como favorita la película agregada en el Ej.2.
UPDATE actors 
SET favorite_movie_id = 22
WHERE id = 3; 

-- 6.Cree una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `rating` decimal(3,1) unsigned NOT NULL,
  `awards` int(10) unsigned NOT NULL DEFAULT '0',
  `release_date` datetime NOT NULL,
  `length` int(10) unsigned DEFAULT NULL,
  `genre_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO movies_temp (id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies;
-- CREATE TEMPORARY TABLE IF NOT EXISTS movies_temp AS (SELECT * from movies);

-- 7.Elimine de esa tabla temporal todas las películas que hayan ganado 
-- menos de 5 awards.

DELETE FROM movies_temp
WHERE id > 0 AND awards < 5; 


-- 8.Obtenga la lista de todas los géneros que tengan al menos una película.
SELECT DISTINCT g.name
FROM genres g 
JOIN movies m ON g.id = m.genre_id;


-- 9.Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name 
  FROM movies m
  JOIN actors a ON a.favorite_movie_id = m.id 
 WHERE m.awards > 3;


-- Utilice el explain plan para analizar las consultas del Ej.6 y 7.
EXPLAIN SELECT * FROM movies_temp;
EXPLAIN SELECT * from actors;

-- 12. Cree un índice sobre el nombre en la tabla movies.
CREATE INDEX title_index ON movies (title);

-- 13. Chequee que el indice fue creado correctamente.
SHOW INDEX FROM movies;