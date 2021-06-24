SELECT * FROM movies_db.movies;

SELECT first_name, last_name, rating FROM movies_db.actors;

SELECT title as "Titulo" from movies_db.series;

SELECT title as "Titulo" from movies_db.series /*WHERE type="income"*/;

SELECT first_name, last_name FROM movies_db.actors WHERE rating>7.5;

SELECT title, rating, awards FROM movies_db.movies WHERE rating>7.5 AND awards>2;

SELECT title, rating FROM movies_db.movies ORDER BY rating;

SELECT title FROM movies_db.movies LIMIT 3;

SELECT title, rating FROM movies_db.movies ORDER BY rating DESC LIMIT 5;

SELECT title, rating FROM movies_db.movies ORDER BY rating DESC LIMIT 5,10;

SELECT * FROM movies_db.actors LIMIT 10 OFFSET 0;

SELECT * FROM movies_db.actors LIMIT 10 OFFSET 20;

SELECT * FROM movies_db.actors LIMIT 10 OFFSET 40;

SELECT title, rating FROM movies_db.movies WHERE title LIKE "%Toy Story%";

SELECT * FROM movies_db.actors WHERE first_name LIKE "Sam%";

SELECT title, release_date from movies_db.movies WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

SELECT title, rating, awards FROM movies_db.movies WHERE rating>3 AND awards>1 and YEAR(release_date) BETWEEN 1988 AND 2009 ORDER BY rating;

SELECT title, rating, awards FROM movies_db.movies WHERE rating>3 AND awards>1 and YEAR(release_date) BETWEEN 1988 AND 2009 ORDER BY rating LIMIT 3 OFFSET 10;
