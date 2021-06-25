USE movies_db;
#SEGUNDA PARTE
#Mostrar el título y el nombre del género de todas las series.
SELECT title, ge.name as genero
FROM series se
INNER JOIN genres ge
ON se.genre_id = ge.id;

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title AS titutloEpisodio, ac.first_name AS nombre, ac.last_name AS apellido
FROM actor_episode ae
INNER JOIN actors ac
INNER JOIN episodes ep
ON ae.actor_id = ac.id AND ae.episode_id = ep.id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title as tituloSerie, COUNT(sea.id) as cantidadTemorada
FROM seasons sea
INNER JOIN series se
ON sea.serie_id = se.id
GROUP BY se.title;


#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
#siempre que sea mayor o igual a 3.
SELECT ge.name AS nombre, COUNT(mo.id) AS cantMovies
FROM genres ge
INNER JOIN movies mo
ON ge.id = mo.genre_id
GROUP BY ge.name
HAVING cantMovies >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de 
#la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT concat(ac.first_name," ",ac.last_name) AS nombreCompleto
FROM actor_movie am
INNER JOIN actors ac
INNER JOIN movies mo
ON am.actor_id = ac.id AND am.movie_id = mo.id
WHERE mo.title LIKE "La Guerra de las galaxias%"
GROUP BY nombreCompleto;

Select * from movies;


