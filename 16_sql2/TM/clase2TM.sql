USE movies_db;

-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s INNER JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
#SELECT (SELECT title FROM episodes e WHERE e.id = ae.episode_id)title,
#(SELECT first_name FROM actors a WHERE a.id = ae.actor_id)name FROM actor_episode ae;

SELECT e.title, a.first_name, a.last_name FROM episodes e INNER JOIN actor_episode ae ON e.id = ae.episode_id
INNER JOIN actors a ON ae.actor_id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, (SELECT COUNT(*) FROM seasons WHERE serie_id = series.id)number FROM series;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, (SELECT count(*) FROM movies m WHERE m.genre_id = g.id)count FROM genres g HAVING count >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
#SELECT DISTINCT(SELECT first_name FROM actors WHERE id = am.actor_id)name,
#(SELECT last_name FROM actors WHERE id = am.actor_id)lastName
#FROM actor_movie am INNER JOIN movies m WHERE m.id = am.movie_id and m.title LIKE '%La Guerra de las galaxias%';

SELECT a.first_name, a.last_name FROM movies m JOIN actor_movie am ON m.id = am.movie_id JOIN actors a ON am.actor_id = a.id
WHERE m.title LIKE "%La Guerra de las galaxias%" GROUP BY a.first_name, a.last_name;