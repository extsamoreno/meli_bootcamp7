/*
1-- Para combinar datos entre tablas 
2-- Inner join, para traer solo las combinaciones que cumplen con la condición del join y left join para traer los datos que coinciden con la condición y los que no de la tabla de la izquierda
3-- Para agrupar los campos con las funciones de agregación 
4-- Para condición en las funciones de agregacion
5-- Inner Join Left Join
6--
select * 
from a
right join b on a.id = b.id
select * 
from a
full join b on a.id = b.id

*/

/* 1 Mostrar el título y el nombre del género de todas las series. */ 
select S.title, G.name
from series S
join genres G on S.genre_id = g.id;

/*2 Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. */

select E.title, A.first_name, A.last_name
from episodes E
join actor_episode AE on E.id = AE.episode_id
join actors A on A.id = AE.actor_id;

/* 3 Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */
SELECT S.title, count(*) AS "seasonQuantity"
FROM series S
JOIN seasons SE ON S.id = serie_id
group by S.title;

/* 4 Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3. */
SELECT G.name, COUNT(*) AS "movieQuantity"
FROM genres G
JOIN movies M ON G.id = M.genre_id
GROUP BY G.name
HAVING COUNT(*) > 3;

/* 5 Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan. */
SELECT DISTINCT A.first_name, A.last_name
FROM actors A 
JOIN actor_movie AM on A.id = AM.actor_id
JOIN movies M on M.id = AM.movie_id
WHERE M.title LIKE '%La Guerra de las galaxias%';
