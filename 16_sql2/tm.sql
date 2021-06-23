USE movies_db;
/* Mostrar el título y el nombre del género de todas las series. */
SELECT se.title,ge.name FROM series se 
JOIN genres ge ON se.genre_id = ge.id;

/* Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. */
SELECT ep.title, ac.first_name, ac.last_name FROM episodes ep 
JOIN actor_episode aep ON ep.id = aep.episode_id 
JOIN actors ac ON aep.actor_id = ac.id;

/* Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */
SELECT COUNT(sea.id), ser.title FROM series ser 
JOIN seasons sea ON ser.id = sea.serie_id 
GROUP BY ser.title ;

/* Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre 
que sea mayor o igual a 3. */
SELECT ge.name, COUNT(mo.id) as res FROM genres ge 
JOIN movies mo ON ge.id = mo.genre_id
GROUP BY ge.name
HAVING res >= 3;

/* Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
y que estos no se repitan. */
SELECT DISTINCT ac.first_name, ac.last_name FROM actors ac 
JOIN actor_movie acm ON ac.id = acm.actor_id
JOIN movies mo ON mo.id = acm.movie_id
WHERE mo.title LIKE "La Guerra de las galaxias%";