use movies_db;
select * from genres;
select * from movies;
select * from actors;
-- 2
INSERT INTO movies (created_at, updated_at,title,rating,awards,release_date,length,genre_id) values (null,null,'pelicula',9.0,3,'2009-04-02',200,5);
-- 3
INSERT INTO genres (created_at,name,ranking,active) values ('2004-03-04','otro', 14, 1);
-- 4
UPDATE movies SET genre_id = 16 WHERE id = 22;
-- 5
UPDATE actors set favorite_movie_id = 22 WHERE UPPER(first_name) LIKE '%SAM%';
-- 6
create temporary table copia_movies (select * from movies);
select * from copia_movies;

-- 7
DELETE FROM copia_movies WHERE awards <5;
-- 8
SELECT distinct(ge.name) FROM genres ge, movies mo
WHERE ge.id = mo.genre_id;
-- 9
SELECT ac.* FROM actors ac, movies mo
WHERE ac.favorite_movie_id = mo.id AND mo.awards > 3;
-- 10
DELETE FROM copia_movies WHERE awards <5; 
-- 12
CREATE INDEX movies_index ON movies (title);
-- 13
SHOW INDEX FROM movies;

