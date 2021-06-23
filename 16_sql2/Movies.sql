# A qué se denomina JOIN en una base datos?
# La sentencia JOIN (INNER JOIN) consiste en combinar datos de una tabla con los datos de otra tabla
# a partir de una o varauas condiciones en comun

# Nombre y explique 2 tipos de JOIN.
# FULL JOIN es la union de ambas tablas
# LEFT JOIN diferencia de A - B

# Para qué se utiliza el GROUP BY?
# Agrupa los resultados segun la columna indicada

# Para qué se utiliza el HAVING?
# Similar al WHERE pero afecta a los grupos resultantes del GROUP BY

# Dado lo siguientes diagramas indique a qué tipo de JOIN corresponde cada uno:
#
# El primer diagrama es un INNER JOIN
# El segundo es un LEFT JOIN

# Escriba una consulta genérica por cada uno de los diagramas a continuación:
#
# SELECT * FROM tableA RIGHT JOIN tableB ON tableA.columnA = tableB.columnB;
# SELECT * FROM tableA FULL JOIN tableB ON tableA.columnA = tableB.columnB;


# Mostrar el título y el nombre del género de todas las series.
SELECT series.title, g.name
FROM series
         JOIN genres g ON g.id = series.genre_id;


# Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, a.first_name, a.last_name
FROM episodes
         JOIN actor_episode ae ON episodes.id = ae.episode_id
         JOIN actors a ON ae.actor_id = a.id;


# Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, count(s.number) AS seasons_amount
FROM series
         JOIN seasons s ON series.id = s.serie_id
GROUP BY series.title;

# Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(m.title) movies_amount
FROM genres g
         JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING movies_amount >= 3;


# Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name, a.last_name
FROM actors a
         JOIN actor_movie am ON a.id = am.actor_id
         JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE '%la guerra de las galaxias%'
GROUP BY a.id
HAVING count(*) >= (SELECT count(*) FROM movies m WHERE m.title LIKE '%la guerra de las galaxias%');
