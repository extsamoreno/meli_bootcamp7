use movies_db;


-- Ejercicio 2
SELECT * FROM movies;

-- Ejercicio 3
SELECT last_name,first_name,rating 
FROM actors;

-- Ejercicio 4
SELECT title as "Titulo" FROM series as Serie;

-- Ejercicio 5 *
SELECT title as "Titulo" FROM series income;

-- Ejercicio 6
SELECT first_name,last_name FROM actors WHERE rating > 7.5;

-- Ejercicio 7
SELECT title,rating,awards FROM movies WHERE rating > 7.5  AND awards > 2;

-- Ejercicio 8
SELECT title,rating FROM movies ORDER BY rating;

-- Ejercicio 9
SELECT title FROM movies LIMIT 3;

-- Ejercicio 10
SELECT title,rating FROM movies ORDER BY rating DESC LIMIT 5;

-- Ejercicio 11
SELECT title,rating FROM movies ORDER BY rating DESC LIMIT 5 , 10;

-- Ejercicio 12
SELECT * FROM actors LIMIT 10;

-- Ejercicio 13
SELECT * FROM actors LIMIT 10 OFFSET 20;

-- Ejercicio 14
SELECT * FROM actors LIMIT 10 OFFSET 40;

-- Ejercicio 15
SELECT title,rating FROM movies WHERE title = "Toy Story";

-- Ejercicio 16
SELECT * FROM actors WHERE first_name like 'Sam%';

-- Ejercicio 17
SELECT title FROM movies WHERE YEAR(release_date) BETWEEN '2004' AND '2008';

-- Ejercicio 18
SELECT title FROM movies WHERE rating >3 and YEAR(release_date) BETWEEN '1988' AND '2009' ORDER BY rating;

-- Ejercicio 19
SELECT title FROM movies WHERE rating >3 and YEAR(release_date) BETWEEN '1988' AND '2009' ORDER BY rating  LIMIT 3 OFFSET 10;
