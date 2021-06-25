#la coneccion entre dos tablas

# INNER JOIN o simplemente JOIN trae los registros donde existe una coneccion entre las tablas, y el LEFT JOIN trae los registros de la tabla de izquierda mas un poco de la otra table (el inner join si no hay un registro de la tabla A son coneccion con la tabla B no lo mostrara, adiferencia del LEFT JOIN)

#para agrupar los registros por alguna columna o columnas

# para poder filtrar los registros usando funciones de SQL

#



select *
from genres
RIGHT JOIN movies on movies.genre_id = genres.id;

select *
from genres
LEFT JOIN movies on movies.genre_id = genres.id;

select *
from genres
INNER JOIN movies on movies.genre_id = genres.id;

select *
from genres
INNER JOIN movies on movies.genre_id = genres.id;


select *
from genres
INNER JOIN movies on movies.genre_id = genres.id
UNION
select *
from genres
INNER JOIN movies on movies.genre_id = genres.id;


---------

SELECT movies.title , genres.name
FROM movies
LEFT JOIN genres ON genres.id = movies.genre_id;


SELECT episodes.title, CONCAT(actors.first_name,' ',actors.last_name) AS actor_name
FROM episodes
JOIN actor_episode ON actor_episode.actor_id = episodes.id
JOIN actors ON actor_episode.episode_id = actors.id;


SELECT series.title ,COUNT(seasons.id) AS seasons
FROM series
JOIN seasons ON seasons.serie_id = series.id
GROUP BY series.title;


SELECT genres.name, COUNT(movies.id) AS movies_cant
FROM genres
JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING movies_cant >= 3;


SELECT DISTINCT actors.first_name, actors.last_name
FROM actors
JOIN actor_movie ON actors.id = actor_movie.actor_id
JOIN movies ON actor_movie.movie_id = movies.id
WHERE LOWER(movies.title) LIKE LOWER('La Guerra de las galaxias%');


