#Punto 2
SELECT * FROM movies;
#Punto 3
SELECT first_name, last_name, rating FROM actors;
#Punto 4
SELECT title as "Título" FROM series;
#Punto 5

#Punto 6
SELECT first_name, last_name FROM actors
WHERE rating >7.5;
#Punto 7
SELECT title, rating, awards FROM movies
WHERE rating > 7.5 and awards > 2;
#Punto 8
SELECT title, rating FROM movies
ORDER BY rating;
#Punto 9
SELECT title FROM movies LIMIT 3;
#Punto 10
SELECT title, rating FROM movies
ORDER BY rating DESC LIMIT 5;
#Punto 11
SELECT title, rating FROM movies
ORDER BY rating DESC LIMIT 5, 5;
#Punto 12
SELECT * FROM actors LIMIT 10;
#Punto 13
SELECT * FROM actors LIMIT 20,10;
#Punto 14
SELECT * FROM actors LIMIT 40,10;
#Punto 15
SELECT title, rating FROM movies
WHERE title= "Toy Story";
#Punto 16
SELECT * FROM actors
WHERE first_name LIKE "Sam%";
#Punto 17
SELECT title FROM movies
WHERE release_date BETWEEN "20040101" AND "20081231";
#Punto 18
SELECT title, rating, release_date from movies
WHERE rating > 3 and awards > 1 and release_date BETWEEN "19880101" AND "20091231"
ORDER BY rating;
#Punto 19
SELECT title, rating, release_date from movies
WHERE rating > 3 and awards > 1 and release_date BETWEEN "19880101" AND "20091231"
ORDER BY rating LIMIT 10,3;








