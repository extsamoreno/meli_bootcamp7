#Segunda parte
#1. Mostrar el título y el nombre del género de todas las series.
SELECT mov.title AS "Titulo de serie", gen.name AS "Genero"
FROM movies mov
JOIN genres gen ON mov.genre_id = gen.id;

#2.Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan encada uno de ellos.
SELECT ep.title AS "Titulo de serie", act.first_name AS "Nombre actor", act.last_name AS "Apellido actor"
FROM episodes ep
JOIN actor_episode ap ON ep.id = ap.episode_id
JOIN actors act ON ap.actor_id = act.id;

#3.Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title AS "Titulo de serie", COUNT(*) AS "Total de temporadas"
FROM series se
JOIN seasons sea ON se.id = sea.serie_id
GROUP BY se.title;

#4.Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name AS "Nombre de genero", COUNT(*)  AS total_peliculas
FROM genres gen 
JOIN movies mov on gen.id = mov.genre_id
GROUP BY gen.name
HAVING total_peliculas >= 3;

#5.Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT act.first_name AS "Nombre actor", act.last_name AS "Apellido actor"
FROM actors act
JOIN actor_movie actmov ON act.id = actmov.actor_id
JOIN movies mov ON actmov.movie_id = mov.id
WHERE mov.title LIKE "La Guerra de las galaxias%"
GROUP BY act.first_name, act.last_name;


