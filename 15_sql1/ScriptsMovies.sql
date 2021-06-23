-- Punto 2 

SELECT 
    *
FROM
    movies;

-- Punto 3

SELECT 
    first_name AS 'Nombre', last_name 'Apellido', rating
FROM
    actors;

-- Punto 4 - 5

SELECT 
    title AS 'Titulo'
FROM
    series;


-- Punto 6

SELECT 
    first_name AS 'Nombre', last_name 'Apellido', rating
FROM
    actors
WHERE
    rating > 7.5;


-- Punto 7

SELECT 
    title AS 'TITULO',
    rating AS 'VALORACION',
    awards AS 'PREMIOS'
FROM
    movies
WHERE
    rating > 7.5 AND awards > 2;


-- Punto 8

SELECT 
    title AS 'TITULO', rating AS 'VALORACION'
FROM
    movies
ORDER BY rating DESC;


-- Punto 9

SELECT 
    title AS 'TITULO'
FROM
    movies
LIMIT 3;


-- PUNTO 10

SELECT 
    title AS 'TITULO', rating AS 'VALORACION'
FROM
    movies
ORDER BY rating DESC
LIMIT 5;


-- PUNTO 11

SELECT 
    title AS 'TITULO', rating AS 'VALORACION'
FROM
    movies
ORDER BY rating DESC
LIMIT 5 , 5;


-- PUNTO 12

SELECT 
    first_name AS 'Nombre', last_name 'Apellido'
FROM
    actors
LIMIT 0 , 10;


-- PUNTO 13

SELECT 
    first_name AS 'Nombre', last_name 'Apellido'
FROM
    actors
LIMIT 30 , 10;


-- PUNTO 14

SELECT 
    first_name AS 'Nombre', last_name 'Apellido'
FROM
    actors
LIMIT 50 , 10;


-- PUNTO 15

SELECT 
    title AS 'TITULO', rating AS 'VALORACION'
FROM
    movies
WHERE
    title LIKE 'Toy Story%';


-- PUNTO 16

SELECT 
    first_name AS 'Nombre', last_name 'Apellido'
FROM
    actors
WHERE
    first_name LIKE 'Sam%';


-- PUNTO 17

SELECT 
    title AS 'TITULO',
    rating AS 'VALORACION',
    release_date AS 'FECHA_LANZAMIENTO'
FROM
    movies
WHERE
    release_date BETWEEN '2004-01-01' AND '2008-12-31';


-- PUNTO 18

SELECT 
    title AS 'TITULO',
    rating AS 'VALORACION',
    awards AS 'PREMIOS',
    release_date AS 'FECHA_LANZAMIENTO'
FROM
    movies
WHERE
    rating > 3 AND awards > 1
        AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
ORDER BY rating DESC;

-- PUNTO 19

SELECT 
    title AS 'TITULO',
    rating AS 'VALORACION',
    awards AS 'PREMIOS',
    release_date AS 'FECHA_LANZAMIENTO'
FROM
    movies
WHERE
    rating > 3 AND awards > 1
        AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
ORDER BY rating DESC
LIMIT 10, 3;

    
    





