#Segunda parte
#Punto 1
SELECT mo.title, gen.name  FROM movies_db.movies mo
JOIN movies_db.genres gen ON mo.genre_id = gen.id;
#Punto 2
SELECT ep.title, co.first_name, co.last_name FROM 
(SELECT ac.first_name first_name, ac.last_name last_name, acp.episode_id episode_id FROM actors ac
JOIN actor_episode acp
ON ac.id = acp.actor_id) co, episodes ep
WHERE co.episode_id = ep.id;
#Punto 3
SELECT series.title, COUNT(seasons.serie_id) as total_seasons  FROM series
JOIN seasons ON series.id = seasons.serie_id 
GROUP BY series.title;
#Punto 4
SELECT genres.name, COUNT(movies.genre_id) as total_movies FROM genres
JOIN movies ON genres.id= movies.genre_id
GROUP BY genres.name HAVING total_movies >=3;
#Punto 5
SELECT actors.first_name, actors.last_name FROM actors
JOIN actor_movie ON actor_movie.id=actors.id
JOIN movies ON movies.id = actor_movie.movie_id
WHERE movies.title LIKE "%galaxias%";



