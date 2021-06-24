-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s, genres g
WHERE s.genre_id = genre_id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM episodes e, actors a, actor_episode ae
WHERE e.id = ae.episode_id AND a.id = ae.actor_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title, COUNT(sea.id) as cant_temp FROM series ser, seasons sea
WHERE ser.id = sea.serie_id
GROUP BY ser.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name, COUNT(mov.id) as cant_mov FROM genres gen, movies mov
WHERE gen.id = mov.genre_id
GROUP BY gen.name
HAVING cant_mov >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que 
-- estos no se repitan.
SELECT a.first_name, a.last_name FROM actors a
WHERE a.id IN (SELECT am.actor_id FROM actor_movie am, movies m WHERE am.movie_id = m.id AND m.title LIKE "La Guerra de las galaxias%");

