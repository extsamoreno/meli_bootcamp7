use movies_db;

-- Ejercicio 1
SELECT title,ge.name FROM series as se INNER JOIN genres as ge ON se.genre_id=ge.id ;

-- Ejercicio 2
SELECT ep.title ,ac.first_name, ac.last_name FROM actor_episode as as_ep 
INNER JOIN actors as ac ON as_ep.actor_id=ac.id 
INNER JOIN episodes as ep ON as_ep.episode_id= ep.id;

-- Ejercicio 3
SELECT se.title, count(*) as Total_temporadas FROM seasons AS sea
INNER JOIN series AS se ON sea.serie_id = se.id GROUP BY se.title;

-- Ejercicio 4
SELECT gen.name, count(*) as Cantidad_total_Peliculas FROM movies AS mov
INNER JOIN genres AS gen ON mov.genre_id = gen.id GROUP BY gen.name HAVING Cantidad_total_Peliculas >= 3;

-- Ejercicio 5
SELECT ac.first_name,ac.last_name FROM actor_movie AS ac_mov
INNER JOIN actors AS ac ON ac_mov.actor_id = ac.id
INNER JOIN movies AS mov ON ac_mov.movie_id = mov.id 
WHERE mov.title LIKE "%La Guerra de las galaxias%"
GROUP BY ac.first_name,ac.last_name;