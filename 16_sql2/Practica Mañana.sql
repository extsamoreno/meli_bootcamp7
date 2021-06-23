-- Eje 1
SELECT m.title, g.name FROM movies m
INNER JOIN genres g
ON m.genre_id = g.id;

-- Eje 2
SELECT e.title AS "Titulo episodio", a.first_name, a.last_name FROM episodes e
INNER JOIN 
	(SELECT ae.episode_id, a.first_name, a.last_name FROM actor_episode ae
    INNER JOIN actors a
    ON ae.actor_id = a.id) a
ON e.id	= a.episode_id;

-- Eje 3
SELECT s.title, COUNT(*) as "Total seasons" FROM series s
INNER JOIN seasons seas
ON s.id = seas.serie_id
GROUP BY s.id;

-- Eje 4
SELECT g.name, COUNT(*) AS total_movies FROM genres g
INNER JOIN movies m
ON m.genre_id = g.id
GROUP BY g.id
HAVING total_movies >= 3;

-- Eje 5
SELECT DISTINCT a.first_name, a.last_name FROM actors a
INNER JOIN
	(SELECT am.actor_id FROM actor_movie am
    INNER JOIN movies m
    ON am.movie_id = m.id
    WHERE m.title LIKE "La Guerra de las Galaxias%") am
ON a.id = am.actor_id;