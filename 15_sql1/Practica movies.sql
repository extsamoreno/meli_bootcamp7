-- 2
SELECT * FROM movies;

-- 3
SELECT first_name, last_name, rating FROM actors;

-- 4
SELECT title AS "titulo" FROM series AS series;

-- 6
SELECT first_name, last_name FROM actors
WHERE rating > 7.5;

-- 7
SELECT title, rating, awards FROM movies
WHERE rating > 7.5 
AND awards > 2;

-- 8
SELECT title, rating FROM movies
ORDER BY rating;

-- 9
SELECT title FROM movies 
LIMIT 3;

-- 10
SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5;

-- 11
SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5,5;

-- 12
SELECT * FROM actors
LIMIT 10
OFFSET 0;

-- 13
SELECT * FROM actors
LIMIT 10
OFFSET 20;

-- 14
SELECT * FROM actors
LIMIT 10
OFFSET 40; 

-- 15
SELECT title, rating FROM movies
WHERE title = "Toy Story";

-- 16
SELECT * FROM actors
WHERE first_name LIKE "Sam%";

-- 17
SELECT title FROM movies
WHERE release_date 
BETWEEN '2004-01-01' AND '2008-12-31';

-- 18
SELECT title FROM movies
WHERE rating > 3
AND awards > 1
AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
ORDER BY rating;

-- 19
SELECT title FROM movies
WHERE rating > 3
AND awards > 1
AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
ORDER BY rating DESC
LIMIT 3
OFFSET 10;