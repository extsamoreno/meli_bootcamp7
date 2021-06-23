USE movies_db;

#5a
SELECT * FROM movies
RIGHT JOIN genres ON movies.genre_id = genres.id;

#5b
SELECT * FROM movies
RIGHT JOIN genres ON movies.genre_id = genres.id
UNION
SELECT * FROM movies 
LEFT JOIN genres ON movies.genre_id = genres.id;

#1.
SELECT series.title, genres.name FROM series
INNER JOIN genres ON series.genre_id = genres.id;

#2.
SELECT episodes.title, actors.first_name, actors.last_name FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

#3.
SELECT series.title, COUNT(seasons.id) FROM series
INNER JOIN seasons ON seasons.serie_id = series.id
GROUP BY series.title;

#4.
SELECT genres.name, COUNT(movies.id) as movies_count FROM genres
INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING movies_count >= 3;

#5.
SELECT DISTINCT actors.first_name, actors.last_name FROM actors
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id 
INNER JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE 'La Guerra de las galaxias%';



