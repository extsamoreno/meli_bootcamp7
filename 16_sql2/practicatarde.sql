-- 1 Explique el cONcpeto de normalizaación y para que se utiliza 
-- Es un proceso que se utiliza para evitar la redundancia de datos e incONsistencia de datos.

-- 2
INSERT INTO movies(CREATEd_at, UPDATEd_at, title, rating, awards, release_date, length, genre_id)
VALUES(CURDATE(), CURDATE(), 'Spiderman into the spiderverse', 10, 10, CURDATE(), 160, 7);

-- 3 
INSERT INTO genres(CREATEd_at, UPDATEd_at, name, ranking, active)
VALUES(CURDATE(), CURDATE(), 'genero', 20, 1 );

-- 4
UPDATE movies SET genre_id = 14 WHERE id = 22;

-- 5
UPDATE actor_movie SET movie_id = 14 WHERE id = 43;

-- 6 
CREATE TEMPORARY TABLE movies_copy
SELECT * FROM movies;

-- 7
DELETE FROM movies_copy WHERE awards < 5;

-- 8
SELECT G.* 
FROM genres G 
JOIN movies M ON G.id = M.genre_id
GROUP BY G.id, G.CREATEd_at, G.UPDATEd_at, G.name, G.ranking, G.active
HAVING COUNT(*) >= 1;

-- 9
SELECT A.*
FROM actors A 
JOIN actor_movie AM ON A.id = AM.actor_id
JOIN movies M ON M.id = AM.movie_id
WHERE M.awards > 3;

-- 10
EXPLAIN 
SELECT * FROM movies;

EXPLAIN DELETE FROM movies_copy WHERE awards < 5;

-- 11 es una estructura que hace que sea mas agil la obtención de los datos, nos hace que las querys sean mas eficientes 

-- 12 
CREATE INDEX title_index ON movies (title);

-- 13
SHOW INDEX FROM movies;