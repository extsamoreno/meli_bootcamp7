-- Eje 2
SELECT * FROM movies;

-- Eje 3
SELECT first_name, last_name, rating FROM actors;

-- Eje 4
SELECT title AS "Titulo" FROM series;

-- Eje 5
SELECT title AS "Titulo" FROM series
WHERE type = "Income";

-- Eje 6
SELECT first_name, last_name FROM actors
WHERE rating > 7.5;

-- Eje 7
SELECT title, rating, awards FROM movies
WHERE rating > 7.5
AND awards > 2;

-- Eje 8
SELECT title, rating FROM movies
ORDER BY rating;

-- Eje 9
SELECT title FROM movies LIMIT 3;

-- Eje 10
SELECT * FROM movies
ORDER BY rating DESC LIMIT 5;

-- Eje 11
SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5
OFFSET 5;

-- Eje 12
SELECT * FROM actors
LIMIT 10;

-- Eje 13
SELECT * FROM actors
LIMIT 10
OFFSET 20;

-- Eje 14
SELECT * FROM actors
LIMIT 10
OFFSET 40;

-- Eje 15
SELECT title, rating FROM movies
WHERE title LIKE "Toy Story%";

-- Eje 16
SELECT * FROM actors
WHERE first_name LIKE "Sam%";

-- Eje 17
SELECT title FROM movies
WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

-- Eje 18
SELECT title FROM movies
WHERE rating > 3
AND awards > 1
AND YEAR(release_date) BETWEEN 1988 AND 2009
ORDER BY rating;

-- Eje 19
SELECT * FROM movies
WHERE rating > 3
AND awards > 1
AND YEAR(release_date) BETWEEN 1988 AND 2009
ORDER BY rating
LIMIT 3
OFFSET 10;