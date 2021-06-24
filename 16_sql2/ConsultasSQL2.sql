/* 1. Mostrar el título y el nombre del género de todas las series. */
select title, name from series inner join genres on series.genre_id = genres.id;
/* 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. */
select title, first_name, last_name from episodes inner join actor_episode on episodes.id = actor_episode.episode_id inner join actors on actors.id = actor_episode.id;
/* 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */
select series.title, count(serie_id) as seasons_number from series inner join seasons on series.id = seasons.serie_id group by series.title;
/* 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3. */
select genres.name , count(genre_id) as amount_of_movies from genres inner join movies on genres.id = movies.genre_id group by genres.name having count(genre_id) >=3;
/* 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan. */
select distinct actors.first_name, actors.last_name from movies inner join actor_movie on movies.id = actor_movie.movie_id inner join actors on actors.id = actor_movie.actor_id where title like "La Guerra de las galaxias%";
