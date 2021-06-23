#	PRIMERA PARTE
#	1 - A qué se denomina JOIN en una base datos?
#	Consiste en combinar datos de una tabla con datos de otra tabla a partir de una o varias condiciones en común.

#	2 - Nombre y explique 2 tipos de JOIN.
#	INNER JOIN: Es la intersección entre dos tablas dada una o más condiciones.
#	FULL JOIN: Es la unión entre dos tablas dada una o más condiciones.

# 	3 - Para qué se utiliza el GROUP BY?
#	Se utiliza para agrupar los resultados según las columnas indicadas.

#	4 - Para qué se utiliza el HAVING?
#	Es como el where, pero sólo se utiliza en el GROUP BY afecta a los grupos seleccionados.

# 	5 - Dado lo siguientes diagramas indique a qué tipo de JOIN corresponde cada uno:
#	a - INNER JOIN
#	b - LEFT JOIN

#	6 - Escriba una consulta genérica por cada uno de los diagramas a continuación:
#	SELECT * FROM TABLE T
#	RIGHT JOIN TABLE_2 T1 / FULL JOIN TABLE_2 T1
#	ON T.id = T1.id;

# 	SEGUNDA PARTE
#	1 - Mostrar el título y el nombre del género de todas las series.

SELECT S.title, G.name
FROM series S
JOIN  genres G ON S.genre_id = G.id;

#	2 - Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en
#		cada uno de ellos.

SELECT E.title, A.first_name, A.last_name
FROM episodes E
JOIN actor_episode AE ON E.id = AE.episode_id
JOIN actors A ON AE.actor_id = A.id;

#	3 - Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT S.title, count(*) AS "total_temporadas"
FROM series S
JOIN  seasons SE ON S.id = SE.serie_id
GROUP BY S.id;

#	4 - Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que 
#		sea mayor o igual a 3.

SELECT G.name, count(1) AS "total_peliculas"
FROM movies M
JOIN genres G ON M.genre_id = G.id
GROUP BY M.genre_id
HAVING total_peliculas >= 3;

#	5 - Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra 
#		de las galaxias y que estos no se repitan.
        
# esta en alguna pelicula de star wars
SELECT A.first_name, A.last_name
FROM actors A
JOIN actor_movie AM ON A.id = AM.actor_id
JOIN movies M ON M.id = AM.movie_id
WHERE M.title LIKE "La Guerra de las galaxias%"
GROUP BY A.id;

# Si se agrega la parte del having tienen que estar SI O SI en todas las peliculas de star wars
#HAVING count(*) = (SELECT count(*) 
#						FROM movies
#                        WHERE title LIKE "La Guerra de las galaxias%");
                        
#INSERT into actors(first_name, last_name, rating, favorite_movie_id)
#VALUES("mariano", "talenti", 1.0, 9);

#INSERT INTO actor_movie(actor_id, movie_id)
#VALUES(50,3);