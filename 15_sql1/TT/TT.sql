-- 2.
SELECT * FROM movies;

-- 3.
SELECT first_name, last_name, rating FROM actors;

-- 4.
SELECT title as "Título" FROM series as Series;

-- 5.
# SELECT title as "Título" FROM series as Series where genre_id = 'income';

-- 6.
SELECT first_name, last_name FROM actors WHERE rating > 7.5;

-- 7.
SELECT title, rating, awards FROM movies where rating > 7.5 and awards > 2;

-- 8.
SELECT title, rating FROM movies where rating > 7.5 ORDER BY rating;

-- 9.
SELECT title FROM movies LIMIT 3;

-- 10.
SELECT title FROM movies ORDER BY rating DESC LIMIT 5;

-- 11.
SELECT title FROM movies ORDER BY rating DESC LIMIT 5 OFFSET 5;

-- 12.
SELECT * FROM actors LIMIT 10;

-- 13.
SELECT * FROM actors LIMIT 10 OFFSET 20;

-- 14.
SELECT * FROM actors LIMIT 10 OFFSET 40;

-- 15.
SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';

-- 16.
SELECT * FROM actors WHERE first_name LIKE "Sam%";

-- 17.
SELECT title FROM movies WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

-- 18.
SELECT title FROM movies WHERE rating > 3 and awards > 1 and YEAR(release_date) BETWEEN 1988 AND 2009 ORDER BY rating DESC;

-- 19.
SELECT title FROM movies WHERE rating > 3 and awards > 1 and YEAR(release_date) BETWEEN 1988 AND 2009 ORDER BY rating DESC LIMIT 3 OFFSET 10;
