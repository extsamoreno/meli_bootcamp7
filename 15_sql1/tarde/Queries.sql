use movies_db;
-- Punto 2
select * from movies_db.movies;
-- Punto 3
select first_name, last_name,rating from actors;
-- Punto 4
select title as "titulo" from series;
-- Punto 5 // no existe la columna
-- Punto 6
select first_name, last_name from actors where rating > 7.5;
-- Punto 7 
select title, rating, awards from movies where rating > 7.5;
-- Punto 8
select title, rating from movies order by rating asc;
-- Punto 9
select title from movies limit 3;
-- Punto 10
select * from movies order by rating desc limit 5;
-- Punto 11
select * from movies order by rating desc limit 4,6;
-- Punto 12
select * from actors limit 10;
-- Punto 13
select * from actors limit 20,10;
-- Punto 14
select * from actors limit 40,10;
-- Punto 15
select * from movies where title like "%Toy Story%";
-- 16. Mostrar a todos los actores cuyos nombres empiecen con Sam.
select * from actors where first_name like "Sam%";
-- 17. Mostrar el título de las películas que salieron entre el 2004 y 2008.
select * from movies where release_date between "2004-01-01" and "2008-01-01"; 
-- 18. Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
select title from movies where rating > 3 and awards > 1 and release_date between "1988-01-01" and "2009-01-01" order by rating;
-- 19. Traer el top 3 a partir del registro 10 de la consulta anterior.
select title from movies where rating > 3 and awards > 1 and release_date between "1988-01-01" and "2009-01-01" order by rating limit 10,3;


