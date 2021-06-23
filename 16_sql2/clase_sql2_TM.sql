# PARTE 1
# 1) JOIN es una operación de teoría de conjuntos que relaciona dos tablas
# que comparten una característica en ambas, y que esta caracteristica
# relaciona a las tablas de cierta manera dependiendo del tipo de operacion

# 2) INNER JOIN -> La intersección entre A y B (registros que
# dado el filtro ingresado se encuentran ubicados si y solo si
# en ambas tablas)
# LEFT JOIN -> Diferencia entre A y B (Se toman todos los 
# elementos de A y se excluyen los que pertenecen unicamente a B)


# 3) Group by toma los registros de una columna y dependiendo de
# la columna indicada agrupa los registros con igual valor para poder
# mostrar resultados con respecto a grupos iguales de datos

# 4) Having permite filtrar el resultado proveniente de group by

# 5) Diagrama 1 es INNER JOIN y Diagrama 2 es LEFT JOIN

# 6) SELECT * FROM table1 RIGHT JOIN table2 ON table1.id=table2.id_table1
# SELECT * FROM table1 FULL OUTER JOIN table2 ON table1.id=table2.id_table1

# PARTE 2
# Mostrar el titulo y el nombre del genero de todas las series
SELECT ser.title, gen.name
FROM movies_db.series ser 
JOIN movies_db.genres gen 
ON ser.genre_id=gen.id;

# Mostrar el titulo de los episodios, el nombre y el apellido de los
# actores que trabajan en cada uno de ellos
SELECT epi.title, actors.first_name, actors.last_name
FROM movies_db.episodes epi
JOIN movies_db.actor_episode act_ep
ON act_ep.episode_id=epi.id
JOIN movies_db.actors actors
ON actors.id= act_ep.actor_id;

# Mostrar el titulo de todas las series y el total de temporadas que 
# tiene cada una de ellas
SELECT ser.title, COUNT(seas.serie_id) as "total seasons"
FROM movies_db.series ser
JOIN movies_db.seasons seas
ON ser.id=seas.serie_id
GROUP BY ser.title;

# Mostrar el nombre de todos los generos y la cantidad total
# de peliculas por cada uno, siempre que sea mayor o igual a 3
SELECT gen.name, COUNT(mov.genre_id) as total_movies
FROM movies_db.genres gen
JOIN movies_db.movies mov
ON mov.genre_id=gen.id
GROUP BY gen.name HAVING total_movies >=3;

# Mostrar solo el nombre y apellido de los actores que trabajan en
# todas las peliculas de la guerra de las galaxias y que estos 
# no se repitan
SELECT DISTINCT actors.first_name, actors.last_name
FROM movies_db.actors actors
JOIN movies_db.actor_movie act_mov
ON actors.id=act_mov.actor_id
JOIN movies_db.movies mov
ON mov.title LIKE "%galaxias%" AND mov.id=act_mov.movie_id;
