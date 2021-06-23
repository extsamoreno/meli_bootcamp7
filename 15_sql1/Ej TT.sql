SELECT * FROM MOVIES;

SELECT first_name, last_name, rating FROM actors;

SELECT title as "título" FROM series s;

SELECT first_name, last_name FROM actors
WHERE rating > 7.50;

SELECT title, rating, awards FROM movies
WHERE rating > 7.50 AND awards > 2;

SELECT title, rating FROM movies
ORDER BY rating;

SELECT title FROM movies
LIMIT 3;

SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5;

SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5
OFFSET 5;

SELECT * FROM actors
LIMIT 10
OFFSET 20;

SELECT * FROM actors
LIMIT 10
OFFSET 40;

SELECT title, rating FROM movies
WHERE title LIKE "Toy Story%";

SELECT * FROM actors
WHERE first_name LIKE "Sam%";

SELECT * FROM movies
WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

SELECT *
FROM movies
WHERE rating > 3 
AND awards > 1 
AND YEAR(release_date) BETWEEN 1988 AND 2009
ORDER BY rating DESC
LIMIT 3;













