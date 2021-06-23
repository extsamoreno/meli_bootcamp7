-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT title, g.name
FROM series JOIN genres AS g ON genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores 
-- que trabajan en cada uno de ellos.

SELECT title, first_name, last_name
FROM episodes 
JOIN actor_episode ON episodes.id = episode_id 
JOIN actors ON actor_episode.id= actors.id;


-- 3. Mostrar el título de todas las series y el total de temporadas que tiene
-- cada una de ellas.
SELECT series.title AS "Serie", COUNT(*) AS "Cantidad de temporadas"
FROM series 
JOIN seasons AS se ON series.id = se.serie_id
GROUP BY series.title;


-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas 
-- por cada uno,  siempre que sea mayor o igual a 3.
SELECT gs.name, COUNT(*) AS "Cantidad de películas"
FROM genres AS gs 
JOIN movies AS m ON m.genre_id = gs.id
GROUP BY gs.name;


-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas 
-- las películas  de la guerra de las galaxias y que estos no se repitan.
SELECT first_name, last_name
FROM actor_movie AS am 
JOIN movies AS m ON am.movie_id = m.id 
JOIN actors AS a ON a.id = am.actor_id
WHERE m.title LIKE "La guerra de las galaxias%"
GROUP BY first_name, last_name;