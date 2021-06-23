USE movies_db;

-- Explique el concepto de normalización y para que se utiliza.
-- Es un proceso que permite eliminar redundancias e inconsistencias mediante una serie de reglas

-- Agregue una película a la tabla movies.
INSERT INTO movies (title,rating,awards,release_Date) values ('Pocho the movie',10.0,10,'2021-06-06 00:00:00');
SELECT * FROM movies ORDER BY id DESC LIMIT 1;

-- Agregué un géneró a la tabla genres.
INSERT INTO genres (created_at,name,ranking,active) values ('2021-06-06 00:00:00','Rare',13,1);
SELECT * FROM genres ORDER BY id DESC LIMIT 1;

-- Asocie a la película del Ej 2. con el género creado en el Ej. 3.
UPDATE movies set genre_id = 14 where id = 22;
SELECT * FROM movies ORDER BY id DESC LIMIT 1;

-- Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.
UPDATE actors set favorite_movie_id = 22 where id = 1;
SELECT * FROM actors where favorite_movie_id = 22;

-- Cree una tabla temporal copia de la tabla movies. (?)
CREATE TEMPORARY TABLE movies_temp (
  id int unsigned NOT NULL AUTO_INCREMENT,
  created_at timestamp NULL DEFAULT NULL,
  updated_at timestamp NULL DEFAULT NULL,
  title varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  rating decimal(3,1) unsigned NOT NULL,
  awards int unsigned NOT NULL DEFAULT '0',
  release_date datetime NOT NULL,
  length int unsigned DEFAULT NULL,
  genre_id int unsigned DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into movies_temp (id,created_at,updated_at,title,rating,awards,release_date,length,genre_id)
select id,created_at,updated_at,title,rating,awards,release_date,length,genre_id
from movies;

SELECT * FROM movies_temp;

-- Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE id>0 and awards < 5;
SELECT * FROM movies_temp where awards < 5;

-- Obtenga la lista de todas los géneros que tengan al menos una película.
SELECT DISTINCT g.name FROM movies m INNER JOIN genres g ON m.genre_id = g.id;

-- Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name FROM movies m INNER JOIN actors a on a.favorite_movie_id = m.id where awards > 3;

-- Utilice el explain plan para analizar las consultas del Ej.6 y 7.


-- Qué son los índices? Para qué sirven?
-- Es un mecanismo para optimizar las consultas permitiendo acceder a ellos directamente sin necesaidad de escanear completamente la tabla

-- Cree un índice sobre el nombre en la tabla movies.
CREATE INDEX title_idx ON movies (title);

-- Chequee que el indice fue creado correctamente.
SHOW INDEX FROM movies;