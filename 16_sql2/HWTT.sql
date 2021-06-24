#Intro
USE movies_db;
#2
SELECT * FROM movies;
INSERT INTO movies
(title, rating, awards, release_date, length, genre_id)
VALUES ("movie1", 10.0,25, "2021-06-23 00:00:00", 120, 5);

SELECT * FROM movies;

#3
SELECT * FROM genres;
INSERT INTO genres
(id, name, ranking)
VALUES(999, "copadas5", 17);

#4
EXPLAIN UPDATE movies
SET genre_id = 999
#WHERE title = "movie1";
WHERE id = 22;
SELECT * FROM movies;

#6
EXPLAIN SELECT * FROM movies;
CREATE TEMPORARY TABLE lest_awarded
	SELECT * FROM movies;
SELECT * FROM lest_awarded;

#7
DELETE FROM lest_awarded
WHERE awards > 5;



#Extras
ALTER TABLE genres
  MODIFY COLUMN created_at
  TIMESTAMP
  NULL 
  DEFAULT CURRENT_TIMESTAMP; 

ALTER TABLE genres
  MODIFY COLUMN updated_at
  TIMESTAMP
  NULL -- the opposite is NOT NULL, which is implicitly set on timestamp columns
  DEFAULT NULL -- no default value for newly-inserted rows
  ON UPDATE CURRENT_TIMESTAMP;
  
  ALTER TABLE movies
  MODIFY COLUMN updated_at
  TIMESTAMP
  NULL -- the opposite is NOT NULL, which is implicitly set on timestamp columns
  DEFAULT NULL -- no default value for newly-inserted rows
  ON UPDATE CURRENT_TIMESTAMP;