USE movies_db;

-- 2. Mostrar todos los registros de la tabla de movies.
SELECT *
  FROM movies;
  
-- 3. Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating
  FROM actors;
  
-- 4. Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español
SELECT title AS "titulo" 
  FROM series;

-- 6. Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name
  FROM actors
 WHERE rating > 7.5;
 
-- 7. Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards
  FROM movies
 WHERE rating > 7.5
   AND awards > 2;
   
-- 8. Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating
  FROM movies
 ORDER BY rating;
 
-- 9. Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title
  FROM movies
 LIMIT 3;
 
-- 10. Mostrar el top 5 de las películas con mayor rating.
SELECT title, rating
  FROM movies
 ORDER BY rating DESC
 LIMIT 5;
 
-- 11. Mostrar las top 5 a 10 de las películas con mayor rating.
SELECT title, rating
  FROM movies
 ORDER BY rating DESC
 LIMIT 5, 5;

-- 12. Listar los primeros 10 actores (sería la página 1), 
SELECT id, first_name, last_name
  FROM actors
 LIMIT 10;
 
-- 13. Luego usar offset para traer la página 3
SELECT id, first_name, last_name
  FROM actors
 LIMIT 20,10;
 
-- 14. Hacer lo mismo para la página 5
SELECT id, first_name, last_name
  FROM actors
 LIMIT 40,10;
 
-- 15. Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating
  FROM movies
 WHERE title = "Toy Story";

-- 16. Mostrar a todos los actores cuyos nombres empiecen con Sam.
SELECT *
  FROM actors
 WHERE first_name LIKE 'Sam%';
 
-- 17. Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title
  FROM movies
 WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31';
 
-- 18. Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title
  FROM movies
 WHERE rating > 3
   AND awards > 1
   AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
 ORDER BY rating;

-- 19. Traer el top 3 a partir del registro 10 de la consulta anterior.
SELECT title
  FROM movies
 WHERE rating > 3
   AND awards > 1
   AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
 ORDER BY rating
 LIMIT 10,3;