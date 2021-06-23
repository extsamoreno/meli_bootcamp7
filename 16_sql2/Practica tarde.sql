SELECT * FROM movies_db.movies;
-- 1 Explique el concepto de normalización y para que se utiliza.

	/*La normalización de base de datos es una técnica que se emplea 
	habitualmente para organizar los contenidos de las tablas de las bases de datos 
	transaccionales y los almacenes de datos
    1 Elimina datos duplicados en atributos. Crea registros independientes.
    2 Elimina columnas que no dependen de la clave principal. 
    3 Elimina subgrupos de datos en múltiples columnas de una tabla y crea tablas nuevas, con relaciones entre ellas.
    4 Desaparecen todas las dependencias */

-- 2 Agregue una película a la tabla movies.
INSERT INTO movies (title,rating,awards,release_Date) values ('Pocho the movie',10.0,10,'2021-06-06 00:00:00');
SELECT * FROM movies ORDER BY id DESC LIMIT 1;

-- 3 Agregué un géneró a la tabla genres.
INSERT INTO genres (created_at,name,ranking,active) values ('2021-06-06 00:00:00','Rare',13,1);
SELECT * FROM genres ORDER BY id DESC LIMIT 1;

-- 4 Asocie a la película del Ej 2. con el género creado en el Ej. 3.
UPDATE movies set genre_id = 14 where id = 22;
SELECT * FROM movies ORDER BY id DESC LIMIT 1;

-- 5 Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.
UPDATE actors set favorite_movie_id = 22 where id = 1;
SELECT * FROM actors where favorite_movie_id = 22;

-- 6 Cree una tabla temporal copia de la tabla movies. (?)
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

INSERT INTO movies_temp (id,created_at,updated_at,title,rating,awards,release_date,length,genre_id)
SELECT id,created_at,updated_at,title,rating,awards,release_date,length,genre_id
FROM movies;

SELECT * FROM movies_temp;

-- 7 Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE id>0 and awards < 5;
SELECT * FROM movies_temp where awards < 5;

-- 8 Obtenga la lista de todas los géneros que tengan al menos una película.
SELECT DISTINCT g.name FROM movies m INNER JOIN genres g ON m.genre_id = g.id;

-- 9 Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name FROM movies m INNER JOIN actors a on a.favorite_movie_id = m.id where awards > 3;

-- 10 Utilice el explain plan para analizar las consultas del Ej.6 y 7.


-- 11 Qué son los índices? Para qué sirven?
	 /*Los indices sirven para automatizar las consultas, es mas rapido buscar algo 
	 por un indice para no de escanear completamente la tabla */

-- 12 Cree un índice sobre el nombre en la tabla movies.
CREATE INDEX title_idx ON movies (title);

-- 13 Chequee que el indice fue creado correctamente.
SHOW INDEX FROM movies;