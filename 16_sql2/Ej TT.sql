-- 1. Explique el concepto de normalización y para que se utiliza.
-- Normalización es un proceso que se realiza para mantener una base de datos consistente, íntegra, y con datos precisos y no duplicados. 

-- 2. Agregue una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ("Demo Movie", 1.5, 0, "1992-09-18", 120, 1);

SELECT * FROM movies;

-- 3. Agregué un géneró a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ("Demo Genre", 1992, 2);

SELECT * FROM genres;

-- 4. Asocie a la película del Ej 2. con el género creado en el Ej. 3.
UPDATE movies
SET genre_id = 18
WHERE id = 999;

-- 5. Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.
UPDATE actors
SET favorite_movie_id = 999
WHERE id = 50;

SELECT * FROM actors;

-- 6. Cree una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies
SELECT * FROM movies;

SELECT * FROM temp_movies;

-- 7. Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temp_movies
WHERE awards < 5;

-- 8. Obtenga la lista de todas los géneros que tengan al menos una película.
-- 9. Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.
-- 10. Utilice el explain plan para analizar las consultas del Ej.6 y 7.
-- 11. Qué son los índices? Para qué sirven?
-- 12. Cree un índice sobre el nombre en la tabla movies.
-- 13. Chequee que el indice fue creado correctamente.