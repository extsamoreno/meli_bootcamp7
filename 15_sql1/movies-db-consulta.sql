USE movies_db;
-- 2
SELECT * FROM movies;
-- 3
SELECT first_name, last_name, rating FROM actors;
-- 4
SELECT title as "titulo"  FROM series series;
-- 6
SELECT first_name,last_name FROM actors where rating > 7.5;
-- 7
SELECT title, rating, awards FROM movies where rating > 7.5 and awards > 2;
-- 8
SELECT title, rating FROM movies order by rating asc;
-- 9 
SELECT title FROM movies LIMIT 3;
-- 10 
SELECT * FROM movies order by rating desc LIMIT 5;
-- 11
SELECT * FROM movies order by rating desc LIMIT 5,10;
-- 12
SELECT * FROM actors  limit 10;
-- 13
SELECT * FROM actors limit 10 OFFSET 20;
-- 14
SELECT * FROM actors limit 10 OFFSET 40;
-- 15
SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';
-- 16
SELECT * FROM actors WHERE first_name LIKE 'Sam%';
-- 17
Select title FROM movies WHERE YEAR(release_date) BETWEEN 2004 and 2008;
-- 18
SELECT title FROM movies WHERE rating >3 AND awards > 1 and YEAR(release_date) BETWEEN 1988 and 2009 order by rating;
-- 19
SELECT title FROM movies WHERE rating >3 AND awards > 1 and YEAR(release_date) BETWEEN 1988 and 2009 order by rating
limit 3
offset 9;



