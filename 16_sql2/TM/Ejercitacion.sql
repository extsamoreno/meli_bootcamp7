-- 1. Un join es una combinacion entre los campos de una tabla con los campos de otra.
-- 2. Inner join devuelve una tabla con los campos de la tabla A que tengan correlativos en la tabla B, es decir la interseccion entre los dos conjuntos\
-- Left Join devuelve una tabla con todos los campos de la tabla A mas los campos de la tabla B que tengan correlativos con la tabla A, es decir, el conjunto A y la intersecci\'f3n con el conjunto B\

-- 3. GROUP BY agrupa las los resultados segun el criterio que se especifique, usualmente usado con las funciones de agregacion.
-- 4. HAVING se utiliza como filtro en lugar de la clausula WHERE para filtrar por el resultado de una funcion de agregacion.
-- 5. El primero corresponde a un INNER JOIN y el segundo a un LEFT JOIN\
-- 6. Select * from tablaA right join tablaB\
--    Select * from tablaA, tablaB\

-- ejercicio 1
-- Mostrar el título y el nombre del género de todas las series
SELECT title, genres.name AS "Genero" FROM movies JOIN genres;

-- ejercicio 2
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en
-- cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name
FROM episodes
JOIN actor_episode ON episodes.id = actor_episode.episode_id
JOIN actors ON actors.id = actor_episode.actor_id

-- ejercicio 3
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, COUNT(series.id) AS seasons
FROM series
JOIN seasons ON seasons.serie_id = series.id
GROUP BY series.title

-- ejercicio 4
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(movies.id) as filmCount
FROM genres
JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name HAVING filmCount >= 3;

-- ejercicio 5
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT first_name, last_name FROM actors
JOIN actor_movie am ON am.actor_id = actors.id
JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE "La Guerra de las galaxias%";

