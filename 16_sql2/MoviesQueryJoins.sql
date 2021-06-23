use movies_db;

# Mostrar el título y el nombre del género de todas las series
SELECT se.title, ge.name
FROM series se INNER JOIN genres ge ON se.genre_id = ge.id;

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en
#cada uno de ellos.
SELECT epi.title, act.first_name, act.last_name
FROM  episodes epi
JOIN actor_episode act_epi ON act_epi.episode_id = epi.id 
JOIN actors act ON act_epi.actor_id = act.id;

/*
Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
*/
SELECT series.title, COUNT(se.serie_id) as totalSeason
FROM  series
JOIN seasons se ON series.id = se.serie_id
GROUP BY series.title;

/*
Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
*/
SELECT gen.name, COUNT(mo.genre_id) as totalMovies
FROM genres gen
JOIN movies mo ON mo.genre_id = gen.id
GROUP BY gen.name
HAVING totalMovies > 3;

/*
Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
*/
use movies_db;
SELECT CONCAT(act.first_name, " ", act.last_name) as fullName
FROM actor_movie actMovie
JOIN movies mo   ON mo.id = actMovie.movie_id
JOIN actors act  ON act.id = actMovie.actor_id
WHERE mo.title LIKE "%galaxias%"
GROUP BY (fullName);


SELECT CONCAT(act.first_name, " ", act.last_name) as fullName
FROM actor_movie actMovie, actors act, movies mo
WHERE mo.title LIKE "%galaxias%" 
AND mo.id = actMovie.movie_id
AND act.id = actMovie.actor_id
GROUP BY (fullName);
