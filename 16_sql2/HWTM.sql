#USE movies_db;
SELECT se.title,
	ge.name
FROM series se
INNER JOIN genres ge;

SELECT ep.title,
	ac.first_name,
    ac.last_name
FROM episodes ep
JOIN actor_episode ae ON ep.id = ae.episode_id 
JOIN actors ac ON ae.actor_id = ac.id;

SELECT se.title,
		COUNT(se.id) as total_episodes
FROM series se
INNER JOIN seasons sea on se.id = serie_id
GROUP BY se.id;

SELECT ge.name, 
	COUNT(mo.id) as count_movies
FROM genres ge
JOIN movies mo ON ge.id = mo.genre_id
GROUP BY ge.name 
HAVING count_movies > 3;

SELECT DISTINCT ac.id, ac.first_name, ac.last_name
FROM movies mo
JOIN actor_movie am ON mo.id = am.movie_id
JOIN actors ac ON am.actor_id = ac.id
WHERE mo.title LIKE "%galaxias%";

SELECT * FROM movies
WHERE title LIKE "%galaxias%";