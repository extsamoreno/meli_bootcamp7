# SQL2 - EJERCICIO TM

#P.1
#Mostrar el título y el nombre del género de todas las series.
SELECT title, genres.name AS "Genres" FROM movies_db.series
INNER JOIN genres
ON series.genre_id = genres.id;

#P.2
#Mostrar el título de los episodios, el nombre y apellido de los actores que
#trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

#P.3
#Mostrar el título de todas las series y el total de temporadas que tiene
#cada una de ellas.
SELECT series.title, COUNT(seasons.title) AS "total_seasons" FROM series
INNER JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.title;

#P.4
#Mostrar el nombre de todos los géneros y la cantidad total de películas
#por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name AS "Genre", COUNT(movies.title) AS "total_movies" FROM genres
INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING total_movies >= 3;

#P.5
#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las
#películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT CONCAT(actors.first_name, " ", actors.last_name) AS FullName FROM actors
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
INNER JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE "La Guerra de las galaxias:%";


#EL OTRO
#SELECT a.first_name, a.last_name FROM movies m INNER JOIN actor_movie a_m ON (m.id=a_m.movie_id)
#INNER JOIN actors a ON (a.id=actor_id)
#WHERE title like "La Guerra de las galaxias%"
#GROUP BY a.id
#HAVING count(*)>= (SELECT count(*) FROM movies WHERE title like "La Guerra de las galaxias%");


