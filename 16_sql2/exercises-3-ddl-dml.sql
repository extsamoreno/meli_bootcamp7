/* Agregue una película a la tabla movies. */
INSERT INTO `movies_db`.`movies`
(`id`, `created_at`, `updated_at`, `title`, `rating`, `awards`, `release_date`, `length`)
VALUES
(22, now(), now(), "El Conjuro", 7.5, 2,
(SELECT STR_TO_DATE('18,8,2013','%d,%m,%Y')), 112);
/* Agregué un géneró a la tabla genres. */
INSERT INTO `movies_db`.`genres`
(`id`, `created_at`, `updated_at`, `name`, `ranking`, `active`)
VALUES
(13, now(), now(), "Thriller", 13, 1);
/* Asocie a la película del Ej 2. con el género creado en el Ej. 3. */
update movies_db.movies
	 set genre_id = 13
	where id = 22;
/* Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2. */
update movies_db.actors
	 set favorite_movie_id = 22
	where id = 4;
/* Cree una tabla temporal copia de la tabla movies. */
CREATE TABLE `movies_db`.`movies_copy` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `rating` decimal(3,1) unsigned NOT NULL,
  `awards` int unsigned NOT NULL DEFAULT '0',
  `release_date` datetime NOT NULL,
  `length` int unsigned DEFAULT NULL,
  `genre_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movies_genre_id_foreign_copy` (`genre_id`),
  CONSTRAINT `movies_genre_id_foreign_copy` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

insert into movies_db.movies_copy
select * from movies_db.movies;
/* Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards. */
delete from movies_db.movies_copy
where awards < 5;
select * from movies_db.movies_copy;
/* Obtenga la lista de todas los géneros que tengan al menos una película. */
select gen.name from movies_db.genres gen
	join movies_db.movies mov on gen.id = mov.genre_id
    group by gen.name
    having count(mov.id) >= 1;
    
select gen.name from movies_db.genres gen
	where (select count(mov.id) from movies_db.movies mov 
			where mov.genre_id = gen.id) >= 1;
/* Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards. */
select concat(act.first_name, " ", act.last_name)  ACTOR from movies_db.actors act
	where (select mov.awards from movies_db.movies mov 
			where mov.id = act.favorite_movie_id) > 3;

/* Utilice el explain plan para analizar las consultas del Ej.6 y 7. */
explain select concat(act.first_name, " ", act.last_name)  ACTOR from movies_db.actors act
	where (select mov.awards from movies_db.movies mov 
			where mov.id = act.favorite_movie_id) > 3;
explain select gen.name from movies_db.genres gen
	join movies_db.movies mov on gen.id = mov.genre_id
    group by gen.name
    having count(mov.id) >= 1;
explain select gen.name from movies_db.genres gen
	where (select count(mov.id) from movies_db.movies mov 
			where mov.genre_id = gen.id) >= 1;
/* Cree un índice sobre el nombre en la tabla movies. */
ALTER TABLE movies_db.movies_copy ADD UNIQUE new_index_test (id, genre_id);
/* Chequee que el indice fue creado correctamente. */
SHOW INDEX FROM movies_copy FROM movies_db;