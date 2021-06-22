#1
SELECT * FROM actors;

#2
SELECT * FROM movies;

#3
SELECT first_name, last_name, rating FROM actors;

#4 - 5
select TITLE AS "titulo" FROM series WHERE ??? no existe type income en act 5;

#6
SELECT first_name, last_name FROM actors WHERE rating > 7.5;

#7
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

#8
SELECT title, rating FROM movies 
ORDER BY rating;

#9
SELECT title FROM movies LIMIT 3;

#10
SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5;

#11
SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5,5;

#12
SELECT * FROM actors LIMIT 10;

#13
SELECT * FROM actors LIMIT 10 OFFSET 30;

#14
SELECT * FROM actors LIMIT 10 OFFSET 40;

#15
SELECT * FROM movies WHERE title LIKE "%Toy Story%";

#16
SELECT * FROM actors WHERE first_name LIKE "Sam%";

#17
SELECT title FROM movies WHERE year (release_date) BETWEEN 2004 and 2008;

#18
SELECT title FROM movies 
WHERE rating > 3 and awards > 1 
and year (release_date) between 1988 and 2009 ORDER BY rating;

#19
SELECT title FROM movies 
WHERE rating > 3 and awards > 1 
and year (release_date) between 1988 and 2009 ORDER BY rating LIMIT 3 OFFSET 10;