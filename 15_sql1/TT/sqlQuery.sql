use movies_db;

-- Ejercicio 2
SELECT * FROM movies;

-- Ejercicio 3
SELECT first_name, last_name, rating FROM Actors;

-- Ejercicio 4
SELECT title as "titulo" FROM series serie;

-- Ejercicio 5 (X)
SELECT title as "titulo" FROM movies WHERE release_date > '2021/06/22';

-- Ejercicio 6
SELECT first_name,last_name, rating FROM actors WHERE rating > 7.5 order by rating;

-- Ejercicio 7
SELECT title, rating, awards FROM movies WHERE rating > 7.5 and awards > 2;

-- Ejercicio 8
SELECT title,rating FROM movies ORDER BY rating;

-- Ejercicio 9
SELECT title FROM movies LIMIT 3;

-- Ejercicio 10
SELECT * FROM movies ORDER BY RATING DESC LIMIT 5;

-- Ejercicio 11
SELECT * FROM movies ORDER BY RATING LIMIT 5,10;

-- Ejercicio 12
SELECT * FROM actors LIMIT 10;

-- Ejercicio 13
SELECT * FROM actors LIMIT 10 OFFSET 20;

-- Ejercicio 14
SELECT * FROM actors LIMIT 10 OFFSET 40;

-- Ejercicio 15
SELECT title, rating FROM movies WHERE title = 'Toy Story';

-- Ejercicio 16
SELECT * FROM actors where first_name like 'Sam%';

-- Ejercicio 17
SELECT title FROM movies where YEAR(release_date) BETWEEN '2004' AND '2008';

-- Ejercicio 18
SELECT title FROM movies WHERE rating > 3 and awards > 4 and YEAR(release_date) BETWEEN '1988' AND '2009';

-- Ejercicio 19
SELECT * FROM movies ORDER BY RATING DESC LIMIT 3;