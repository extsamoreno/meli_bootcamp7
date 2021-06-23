
# PRIMERA PARTE

- A qué se denomina JOIN en una base datos?
  


- Nombre y explique 2 tipos de JOIN.


- Para qué se utiliza el GROUP BY?


- Para qué se utiliza el HAVING?


- Dado lo siguientes diagramas indique a qué tipo de JOIN corresponde cada uno:

- Escriba una consulta genérica por cada uno de los diagramas a continuación:






# SEGUNDA PARTE

- Mostrar el título y el nombre del género de todas las series.

SELECT s.title, g.name FROM genres g INNER JOIN series s ON (g.id=s.genre_id);

- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en
cada uno de ellos.

SELECT e.title, a.first_name, a.last_name 
FROM episodes e INNER JOIN actor_episode a_e ON (a_e.episode_id= e.id) 
INNER JOIN actors a ON (a.id=a_e.actor_id);

- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT series.title, count(*) AS "cantidad de temporadas" 
FROM series INNER JOIN seasons ON (series.id= seasons.serie_id)
GROUP BY series.title;

- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT g.name, count(*) cantidad FROM genres g INNER JOIN movies m ON m.genre_id= g.id
GROUP BY g.name
HAVING cantidad>=3;

- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT a.first_name, a.last_name FROM movies m INNER JOIN actor_movie a_m ON (m.id=a_m.movie_id)
INNER JOIN actors a ON (a.id=actor_id)
WHERE title like "La Guerra de las galaxias%"
GROUP BY actor_id
HAVING count(*)>=2;
