#PRIMERA PARTE - TEORIA

#¿A qué se denomina JOIN?
#Cuando hablamos de JOIN, nos referimos por defecto al INNER JOIN. Es una sentencia SQL que nos permite combinar datos en una tabla con datos de otra tabla a partir del cumplimiento de una o varias condiciones

#Nombre y explique 2 tipos de JOIN
#INNER JOIN - Intersección de Conjuntos
#FULL JOIN - Unión de Conjuntos (RIGHT JOIN + LEFT JOIN)
#LEFT JOIN - Diferencia de Conjuntos (A-B)
#RIGHT JOIN - Diferencia de Conjuntos (B-A)

#¿Para qué se utiliza GROUP BY?
#La sentencia GROUP BY agrupa los registros según las columnas que indiquemos generando un solo registro por cada grupo de filas que compartan las columnas indicadas

#¿Para qué se utiliza HAVING?
#La sentencia HAVING funciona como la sentencia WHERE pero para los resultados de la sentencia GROUP BY

#Dado lo siguientes diagramas indique a qué tipo de JOIN corresponde cada uno
#DIAGRAMA 1 - INNER JOIN
#DIAGRAMA 2 - LEFT JOIN

#Escriba una consulta genérica por cada uno de los diagramas a continuación
#DIAGRAMA 1 - SELECT column FROM table1 RIGHT JOIN table2 ON table1.column = table2.column;
#DIAGRAMA 2 - SELECT column FROM table1 FULL JOIN table2 ON table1.column = table2.column WHERE condition;

#SEGUNDA PARTE - PRACTICA

USE movies_db;

#Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name FROM series JOIN genres ON series.genre_id = genres.id;

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name FROM episodes JOIN (actor_episode JOIN actors ON actor_episode.actor_id = actors.id) ON episodes.id = actor_episode.episode_id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, count(*) AS total_temporadas FROM series JOIN seasons ON seasons.serie_id = series.id
GROUP BY series.title;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, count(*) AS total_peliculas FROM genres JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING total_peliculas >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT actors.first_name, actors.last_name FROM movies JOIN (actor_movie JOIN actors ON actor_movie.actor_id = actors.id) ON movies.id = actor_movie.movie_id 
WHERE movies.title LIKE "La Guerra de las Galaxias%";



