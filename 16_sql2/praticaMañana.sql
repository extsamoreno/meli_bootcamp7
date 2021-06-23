/* 1 Mostrar el título y el nombre del género de todas las series. */
SELECT s.title, g.name 
FROM series s 
JOIN genres g ON s.genre_id = g.id;

/* 2 Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. */
SELECT episodes.title, actors.first_name, actors.last_name
FROM episodes
JOIN actor_episode ON episodes.id = actor_episode.episode_id 
JOIN actors ON actor_episode.actor_id = actors.id
ORDER BY episodes.title;

/* 3 Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */
SELECT series.title, COUNT(1) 
FROM series
JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.id;

/* 4 Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3. */
SELECT genres.name, COUNT(1) AS cont
FROM genres 
JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING cont >=3;

/* 5 Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.*/
SELECT actors.first_name, actors.last_name FROM actors
    JOIN actor_movie am ON actors.id = am.actor_id
    JOIN movies mv ON am.movie_id = mv.id
    WHERE am.movie_id IN
        (SELECT id FROM movies
            WHERE title LIKE "%Galaxia%")
    GROUP BY actors.id
    HAVING count(1) = (SELECT count(1) FROM movies
            WHERE title LIKE "%Galaxia%");








