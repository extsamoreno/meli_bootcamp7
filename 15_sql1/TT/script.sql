-- ejercicio 2
SELECT * FROM movies;

-- ejercicio 3
SELECT first_name, last_name, rating from actors;

-- ejercicio 4
SELECT title AS "TITULO" FROM series SERIES;

-- ejericio 6
SELECT first_name, last_name FROM actors WHERE rating > 7.5 ORDER BY rating;

-- ejercicio 7
SELECT title, rating, premios FROM movies WHERE rating > 7.5 AND awards > 2;

-- ejercicio 8
SELECT title, rating FROM movies ORDER BY rating ASC;

-- ejercicio 9
SELECT title FROM movies LIMIT 3;

-- ejercicio 10
SELECT rating FROM movies ORDER BY rating DESC LIMIT 5;

-- ejercicio 11
SELECT rating FROM movies ORDER BY rating ASC LIMIT 5,10;

-- ejercicio 12
SELECT * FROM actors LIMIT 10;

-- ejercicio 13
SELECT * FROM actors LIMIT 10 OFFSET 30;

-- ejercicio 14
SELECT * FROM actors LIMIT 10 OFFSET 50;

-- ejercicio 15
SELECT title, rating FROM movies WHERE title = "TOY STORY";

-- ejercicio 16
SELECT * FROM actors WHERE first_name = "Sam%";

-- ejercicio 17
SELECT title FROM movies WHERE YEAR(release_date) BETWEEN '2004' AND '2008';

-- ejercicio 18
SELECT title FROM movies WHERE rating > 3 AND YEAR(release_date) BETWEEN '1988' AND '2009' AND awards > 1;

-- ejercicio 19
-- Traer el top 3 a partir del registro 10 de la consulta anterior.
SELECT title FROM movies WHERE (rating > 3 AND YEAR(release_date) BETWEEN '1988' AND '2009' AND awards > 1) ORDER BY rating LIMIT 3;




