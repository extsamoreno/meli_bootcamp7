# Ejercicio 1
# La normalización es un proceso de estandarización y validación de datos que consiste en eliminar
# las redundancias o inconsistencias. Al hacerlo se hace mas simple consultar y gestionar.

# Ejercicio 2
INSERT INTO movies (id,created_at,updated_at,title,rating,awards,release_date,length,genre_id) VALUES 
(23,NULL,NULL,"Tarzan" , 9.0,3,'1999-2-10 00:00:00',128,2);

# Ejercicio 3
INSERT INTO genres (id,created_at,updated_at,name,ranking,active) VALUES 
(15,'1999-2-10 00:00:00',NULL,"Suspenso", 15 ,1);

# Ejercicio 4
UPDATE movies
SET genre_id = 15
WHERE id = 23;

# Ejercicio 5
UPDATE actors
SET favorite_movie_id = 23
WHERE id = 3;

# Ejercicio 6
CREATE TEMPORARY TABLE table_temp 
SELECT * FROM movies;

# Ejercicio 7
SET SQL_SAFE_UPDATES=0;
DELETE FROM table_temp
WHERE awards < 5;

# Ejercicio 8
SELECT name , count(name) as c FROM genres 
INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY name
HAVING c >= 1;

# Ejercicio 9
SELECT first_name from actors as a
INNER JOIN movies ON movies.id = a.favorite_movie_id
WHERE movies.awards > 3;

# Ejercicio 10

EXPLAIN INSERT INTO table_temp(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies;

EXPLAIN DELETE FROM table_temp
WHERE awards < 5;

# Ejercicio 11
# Son un mecanismo para optimizar consultas en SQL
# Mejoran sustancialmente los tiempos de respuesta en Queries complejas


# Ejercicio 12
CREATE INDEX title_index ON movies(title);

# Ejercicio 13
SHOW INDEXES FROM movies;