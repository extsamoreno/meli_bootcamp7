# 1 - Explique el concepto de normalización y para que se utiliza.
#	Es un proceso de estandarización y validación de datos que consiste en eliminar las redundancias 
#	o inconsistencias, completando datos mediante una serie de reglas que actualizan la información, 
#	protegiendo su integridad y favoreciendo la interpretación, para que así sea más fácil de consultar 
#	y más útil para quien la gestiona.

# 2 - Agregue una película a la tabla movies.

INSERT INTO movies(title, rating, awards, release_date, length, genre_id)
VALUES("Una pelicula", 5.6, 2, CAST('2004-01-01' AS DATETIME), 120, 1);

# 3 - Agregué un géneró a la tabla genres.

INSERT INTO genres(created_at, name, ranking, active)
VALUES(CURDATE(), "Pelea", 13, 1);

# 4 - Asocie a la película del Ej 2. con el género creado en el Ej. 3.

UPDATE movies M
SET M.genre_id = 14
WHERE M.id = 22;

# 5 - Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.

UPDATE actors A
SET A.favorite_movie_id = 13
WHERE A.favorite_movie_id IS NULL;

# 6 - Cree una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE copy_movies SELECT * FROM movies LIMIT 0;

INSERT INTO copy_movies(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies;

# 7 - Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

SET SQL_SAFE_UPDATES=0; # permit to do the delete query

DELETE FROM copy_movies WHERE awards < 5;

SET SQL_SAFE_UPDATES=1;

SELECT * FROM copy_movies;

# 8 - Obtenga la lista de todas los géneros que tengan al menos una película.

SELECT G.name
FROM genres G
JOIN movies M ON M.genre_id = G.id
GROUP BY G.id
HAVING count(1) > 0;

# 9 - Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT A.first_name, A.last_name, M.title
FROM actors A
JOIN movies M ON A.favorite_movie_id = M.id
WHERE awards > 3;

# 10 - Utilice el explain plan para analizar las consultas del Ej.6 y 7.

#en el create no te deja ponerlo
CREATE TEMPORARY TABLE copy_movies SELECT * FROM movies LIMIT 0;

EXPLAIN INSERT INTO copy_movies(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies;

EXPLAIN DELETE FROM copy_movies WHERE awards < 5;

# 11 - Qué son los índices? Para qué sirven?
#	Es un mecanismo para optimizar consultas SQL.
#	Mejoran el acceso a los datos al proporcionar una ruta más directa a los datos almacenados
#	para evitar realizar escaneos completos de los datos de una tabla.

# 12 - Cree un índice sobre el nombre en la tabla movies.

ALTER TABLE movies
ADD INDEX name_index(title);

# 13 - Chequee que el indice fue creado correctamente.

SHOW INDEX FROM movies;