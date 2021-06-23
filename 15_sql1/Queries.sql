# Parte 2

# Mostrar todos los registros de la tabla movies
SELECT * FROM movies;

# Mostrar el nombre, apellido y rating de todos los actores.
SELECT frist_name, last_name, rating FROM actors;

#Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla
#como el campo estén en español
SELECT title as titulo FROM series;

#Aplicarle a la consulta anterior un filtro por type en donde este sea igual a income.

#Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name 
FROM actors
WHERE rating > 7.5;

#Mostrar el título de las películas, el rating y los premios de las películas con un rating
#mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards 
FROM movies
WHERE rating > 7.5 AND awards > 2;

#Mostrar el título de las películas y el rating ordenadas por rating en forma
#ascendente.
SELECT title, rating, awards 
FROM movies
ORDER BY rating;

#Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies LIMIT 3;

#Mostrar el top 5 de las películas con mayor rating.
SELECT * FROM movies
ORDER BY rating DESC LIMIT 5;

#Mostrar las top 5 a 10 de las películas con mayor rating.
SELECT * FROM movies
ORDER BY rating DESC LIMIT 5,5;

#Listar los primeros 10 actores (sería la página 1),
SELECT *
FROM actors LIMIT 10;

#Luego usar offset para traer la página 3
SELECT *
FROM actors LIMIT 20,10;

#Hacer lo mismo para la página 5
SELECT *
FROM actors LIMIT 40,10;

#Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating 
FROM movies
#WHERE title regexp "[T|t]oy.*[S|s]tory.*";
WHERE title LIKE "%Toy Story%";

#Mostrar a todos los actores cuyos nombres empiecen con Sam.
SELECT *
FROM actors 
WHERE first_name LIKE "SAM%";

#Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title
FROM movies
WHERE release_date between "2004-01-01 00:00:00" and "2009-01-01 00:00:00";

#Traer el título de las películas con el rating mayor a 3, con más de 1 premio y
#con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating

SELECT * #title
FROM movies
WHERE rating > 3 and awards > 1
and release_date between "1988-01-01 00:00:00" and "2010-01-01 00:00:00"
ORDER BY rating;

#Traer el top 3 a partir del registro 10 de la consulta anterior.
SELECT * #title
FROM movies
WHERE rating > 3 and awards > 1
and release_date between "1988-01-01 00:00:00" and "2010-01-01 00:00:00"
ORDER BY rating LIMIT 10,3;