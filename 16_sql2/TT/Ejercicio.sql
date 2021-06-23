USE movies_db;
-- Ejercicio 1
/*
La normalizaciòn se utiliza para tener una base de datosa correcta en cuento a la estructura y el diseño de la misma esto con el fin de tener mejorrendimiento, no manejar redundancia en los datos y poder gestionarla de la manera mas eficiente.
*/

-- Ejercicio 2
INSERT INTO movies (created_at,updated_at,title,rating,awards,release_date,length,genre_id) values ( NULL, NULL, 'SONIc', '8.9', '1', '2001-01-04 00:00:00', '120', '5');	

-- Ejercicio 3
INSERT INTO genres (created_at,updated_at,name,ranking,active) values ( '2010-07-03 22:00:00', NULL, 'Animadas para niños', '13', '1')	;

-- Ejercicio 4
UPDATE movies SET genre_id=14 WHERE title='SONIc' AND id=22;

-- Ejercicio 5
UPDATE actors SET favorite_movie_id=22 WHERE id=29;

-- Ejercicio 6
CREATE TEMPORARY TABLE `Tmovies` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500)  NOT NULL,
  `rating` decimal(3,1) unsigned NOT NULL,
  `awards` int unsigned NOT NULL DEFAULT '0',
  `release_date` datetime NOT NULL,
  `length` int unsigned DEFAULT NULL,
  `genre_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Tmovies_genre_id_foreign` (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 ;


INSERT INTO Tmovies
SELECT * FROM movies;

SELECT * FROM Tmovies;


-- Ejercicio 7
DELETE FROM Tmovies WHERE awards < 5;

-- Ejercicio 8
SELECT DISTINCT name FROM genres as gen 
INNER JOIN movies AS mov on gen.id=mov.genre_id;

-- Ejercicio 9
SELECT DISTINCT first_name,last_name FROM actors as act
INNER JOIN movies AS mov on act.favorite_movie_id=mov.id
WHERE mov.awards > 3;

-- Ejercicio 10 - No se como realizarlo
EXPLAIN ANALYZE DELETE FROM Tmovies WHERE awards < 5 ;

-- Ejercicio 11 
/*
Qué son los índices? Para qué sirven?

Los indices nos sirven para llegar mas rapido a un valor determinado, esto es muy usado en las busquedas 
para que el motor de la BD le de prioridad de busqueda sobre estos indices que nosotros declaramos dentro de la tabla
*/

-- Ejercicio 12
CREATE INDEX movies_idx_title on movies (title);

-- Ejercicio 13
SHOW INDEX FROM movies;







