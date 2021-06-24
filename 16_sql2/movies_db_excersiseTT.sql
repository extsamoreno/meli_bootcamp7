SELECT * FROM movies_db.series;
/*2*/
INSERT INTO movies (title, rating, awards, release_date, length)
VALUES ("Mi Villano Favorito", 8.5, 3, "2010-07-29",95);

/*3*/
INSERT INTO genres (name,ranking)
VALUES ("Clasico",13);

/*4*/
UPDATE movies
   SET genre_id = 13
 WHERE id = 22;

 /*5*/
UPDATE actors
   SET favorite_movie_id = 22
 WHERE id = 3;
 
 /*6*/
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

select * from movies_temp;
 /*7*/
DELETE FROM movies_temp
 WHERE id > 0 
   AND awards < 5;
   
 /*8*/
SELECT DISTINCT g.name 
  FROM movies mo
  JOIN genres ge
    ON mo.genre_id = ge.id;

 /*9*/
SELECT ac.first_name, ac.last_name 
  FROM movies mo
  JOIN actors ac 
    ON ac.favorite_movie_id = mo.id 
 WHERE mo.awards > 3;

 /*12*/
CREATE INDEX title_index ON movies (title);

 /*13*/
SHOW INDEX FROM movies;




