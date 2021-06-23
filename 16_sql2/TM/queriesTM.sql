
# 1. Mostrar el título y el nombre del género de todas las series.

SELECT se.title, ge.name FROM series se
INNER JOIN genres ge
ON se.genre_id = ge.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT ep.title, ac.first_name, ac.last_name FROM actor_episode ac_ep
JOIN actors ac
ON ac.id = ac_ep.actor_id
JOIN episodes ep
ON ep.id = ac_ep.episode_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT se.title, count(*) as "Cantidad de temporadas" FROM series se
JOIN seasons temp
ON se.id = temp.serie_id
GROUP BY temp.serie_id; #se.id

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT ge.name, count(*) as TotalMovies FROM genres ge
JOIN movies mo
ON ge.id = mo.genre_id
GROUP BY ge.id HAVING TotalMovies >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores 
-- que trabajan en todas las películas de la guerra de las galaxias 
-- y que estos no se repitan.

SELECT ac.first_name, ac.last_name FROM movies mo
INNER JOIN actor_movie am ON mo.id = am.movie_id
INNER JOIN actors ac ON ac.id = am.actor_id
WHERE title LIKE "La Guerra de las galaxias%"
GROUP BY ac.id
HAVING count(*) >= (SELECT count(*) FROM movies WHERE title LIKE "La Guerra de las galaxias%");



