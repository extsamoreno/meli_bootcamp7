SELECT * FROM movies_db.movies;

/*1*/
SELECT se.title, ge.name as "genre"
  FROM series se
  LEFT JOIN genres ge
    ON se.genre_id = ge.id;
    
/*2*/
SELECT ep.title, co.first_name, co.last_name FROM 
(SELECT ac.first_name first_name, ac.last_name last_name, acp.episode_id episode_id FROM actors ac
JOIN actor_episode acp
ON ac.id = acp.actor_id) co, episodes ep
WHERE co.episode_id = ep.id;
  
/*3*/
SELECT s.title, COUNT(*) as "Total seasons" FROM series s
INNER JOIN seasons seas
ON s.id = seas.serie_id
GROUP BY s.id;

/*4*/
SELECT gen.name, COUNT(*) as Cantidad_total_Peliculas FROM movies AS mov
INNER JOIN genres AS gen ON mov.genre_id = gen.id GROUP BY gen.name HAVING Cantidad_total_Peliculas >= 3;

/*5*/
SELECT DISTINCT a.first_name, a.last_name FROM actors a
INNER JOIN
	(SELECT am.actor_id FROM actor_movie am
    INNER JOIN movies m
    ON am.movie_id = m.id
    WHERE m.title LIKE "La Guerra de las Galaxias%") am
ON a.id = am.actor_id;