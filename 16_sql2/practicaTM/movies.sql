USE movie_db;
-- 1
SELECT s.title, g.name FROM genres as g 
INNER JOIN series as s on (g.id=s.genre_id);
-- 2
SELECT e.title, a.first_name, a.Last_name
FROM episodes as e 
INNER JOIN actor_episode as a_e ON (a_e.episode_id=e.id)
INNER JOIN actors as a ON (a.id=a_e.actor_id); 
-- 3
SELECT series.title,count(*) AS "Cantidad de Temporadas"
FROM series INNER JOIN seasons ON (series.id=seasons.serie_id)
GROUP BY series.title;
-- 4 
SELECT g.name, count(*) as cantidad
FROM genres as g
INNER JOIN movies as m ON (g.id=m.genre_id)
GROUP BY g.name
HAVING cantidad>3;
-- 5 
SELECT DISTINCT a.first_name, a.last_name 
FROM actors as a 
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies m ON m.id = am.movie_id
WHERE m.title LIKE "%La Guerra de las galaxias%";