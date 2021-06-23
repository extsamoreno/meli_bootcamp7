-- Ejercicios Tarde - SQL 3 - MOVIES DB
USE movies_db;

-- 2
INSERT INTO movies 
VALUES (0, NULL, NULL, "Prueba", 8.5, 2, "2020-01-01", 90, 1);

-- 3
INSERT INTO genres 
VALUES (0, NULL, NULL, "Prueba G", 13, 1);

-- 4
UPDATE movies SET genre_id = 13
WHERE id = 22;

-- 5
UPDATE actors SET favorite_movie_id = 22
WHERE id = 5;

-- 6
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

SELECT * FROM movies_temp;

-- 7
DELETE FROM movies_temp 
WHERE id > 0
AND awards < 5;

-- 8
SELECT DISTINCT genres.name FROM genres
JOIN movies
ON genres.id = movies.genre_id;

-- 9
SELECT actors.first_name, actors.last_name
FROM actors
JOIN movies
ON actors.favorite_movie_id = movies.id
WHERE movies.awards > 3;

-- 12
CREATE INDEX title_index
ON movies (title);

-- 13
SHOW INDEX FROM movies;