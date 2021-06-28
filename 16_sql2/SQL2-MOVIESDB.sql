-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT ser.title, gen.name FROM series ser
JOIN genres gen ON ser.genre_id = gen.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT  epi.title, act.first_name, act.last_name FROM episodes epi
JOIN actor_episode aep ON epi.id = aep.episode_id
JOIN actors act ON aep.actor_id = act.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title,  COUNT(sea.id) FROM series ser
JOIN seasons sea ON ser.id = sea.serie_id
GROUP BY ser.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name, COUNT(mov.id) c FROM genres gen
JOIN movies mov ON gen.id = mov.genre_id
GROUP BY gen.name
HAVING c >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT act.first_name, act.last_name FROM actors act
JOIN actor_movie amo ON act.id = amo.actor_id
JOIN movies mov ON amo.movie_id = mov.id
WHERE mov.title LIKE "La Guerra de las galaxias%";
