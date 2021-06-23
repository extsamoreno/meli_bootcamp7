USE `movies_db`;

#Excercise 1
SELECT title, name 
FROM series
INNER JOIN genres ON series.genre_id = genres.id;

#Excercise 2
SELECT title, first_name, last_name
FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

#Excercise 3
SELECT series.title, count(*) as temporadas
FROM series
INNER JOIN seasons ON series.id = seasons.serie_id
GROUP BY title;

#Excercise 4
SELECT name, count(*) as totalMovies
FROM genres
INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY name HAVING totalMovies >= 3;

#Excercise 5
SELECT DISTINCT first_name, last_name
FROM actors
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
INNER JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE "%La Guerra de las Galaxias%";




