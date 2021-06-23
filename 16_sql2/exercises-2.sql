/* Mostrar el título y el nombre del género de todas las series. */
SELECT ser.title, gen.name FROM movies_db.series ser
	join movies_db.genres gen on ser.genre_id = gen.id;
/* Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. */
SELECT epi.title, act.first_name, act.last_name FROM movies_db.episodes epi
	join movies_db.actor_episode acp on epi.id = acp.episode_id
    join movies_db.actors act on act.id = acp.actor_id;
/* Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */
SELECT ser.title, count(sea.number) FROM movies_db.series ser
	left join movies_db.seasons sea on ser.id = sea.serie_id
	GROUP BY ser.title;
/* Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre 
que sea mayor o igual a 3. */
SELECT gen.name, count(mov.id) FROM movies_db.genres gen
	left join movies_db.movies mov on gen.id = mov.genre_id
	GROUP BY gen.name
	HAVING count(mov.id) >= 3;
/* Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
y que estos no se repitan. */
SELECT distinct act.first_name, act.last_name FROM movies_db.movies mov
	join movies_db.actor_movie acm on acm.movie_id = mov.id
    join movies_db.actors act on acm.actor_id = act.id
	WHERE mov.title LIKE "%La Guerra de las galaxias%";