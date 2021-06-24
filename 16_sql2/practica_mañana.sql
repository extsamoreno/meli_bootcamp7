# Ejercicio 1
SELECT s.title, g.name 
FROM series s 
JOIN genres g ON s.genre_id = g.id;

# Ejercicio 2
SELECT episodes.title, actors.first_name, actors.last_name
FROM episodes
JOIN actor_episode ON episodes.id = actor_episode.episode_id 
JOIN actors ON actor_episode.actor_id = actors.id
ORDER BY episodes.title;

# Ejercicio 3
SELECT series.title, COUNT(1) 
FROM series
JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.id;

# Ejercicio 4
SELECT genres.name, COUNT(1) AS cont
FROM genres 
JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING cont >= 3;

# Ejercicio 5
SELECT actors.first_name, actors.last_name FROM actors
    JOIN actor_movie am ON actors.id = am.actor_id
    JOIN movies mv ON am.movie_id = mv.id
    WHERE am.movie_id IN
        (SELECT id FROM movies
            WHERE title LIKE "%Galaxia%")
    GROUP BY actors.id
    HAVING count(1) = (SELECT count(1) FROM movies
            WHERE title LIKE "%Galaxia%");