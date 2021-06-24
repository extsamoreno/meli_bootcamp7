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
 
 -- Dia 2 ----
 -- 1. Mostrar el título y el nombre del género de todas las series.
SELECT se.title, ge.name as "genero"
  FROM series se
	JOIN genres ge
    ON se.genre_id = ge.id;
    
-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, ac.first_name as "nombreActor/a", ac.last_name as "apellidoActor/a"
  FROM episodes ep
  JOIN actor_episode ae
    ON ep.id = ae.episode_id
  JOIN actors ac
    ON ae.actor_id = ac.id;
  
-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title, count(*) as "temporadas"
  FROM series se
  JOIN seasons sea
    ON se.id = sea.serie_id
 GROUP BY sea.serie_id;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name, count(mov.id) AS "peliculas"
  FROM genres gen
  JOIN movies mov 
    ON gen.id = mov.genre_id
GROUP BY gen.name
HAVING peliculas >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT distinct ac.first_name, ac.last_name
  FROM movies mo 
  JOIN actor_movie am
    ON mo.id = am.movie_id
  JOIN actors ac
    ON am.actor_id = ac.id
 WHERE mo.title LIKE "La Guerra de las galaxias%"
GROUP BY ac.first_name, ac.last_name;

-- Dia 3 -----

-- 2 Agregue una película a la tabla movies.

insert into movies (id,title, rating, awards, release_date) values(22,"pepe",2.2,3.0,"1999-03-04 00:00:00");

-- 3 Agregué un géneró a la tabla genres.
insert into genres (id,name,ranking) values(13,"pepe",13);

-- 4 Asocie a la película del Ej 2. con el género creado en el Ej. 3.

update movies set genre_id = 13  where id = 22;

-- 5 Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.
update actors set favorite_movie_id = 22  where id = 12;

-- 6 Cree una tabla temporal copia de la tabla movies.

create temporary table test
select * from movie;

-- 7 Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.


-- 8 Obtenga la lista de todas los géneros que tengan al menos una película.
-- 9 Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.
-- 10 Utilice el explain plan para analizar las consultas del Ej.6 y 7.
-- 11 Qué son los índices? Para qué sirven?
-- 12 Cree un índice sobre el nombre en la tabla movies.
-- 13 Chequee que el indice fue creado correctamente.


