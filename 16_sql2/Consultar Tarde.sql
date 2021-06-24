-- 1. La normalización es la estandarización y validación de datos en donde se busca eliminar la redundancias o inconsistencias 
-- de una base de datos en busqueda de mejorar la integridad de la base de datos y optimizando las consultas
-- para que sean simples y mas eficientes.

-- 2.
use movies_db;
insert into movies (title, rating, awards, release_date, length)
values ('Walking Life', 7.5, 3, '2001-10-19', 140);
update movies set created_at = '2021-06-23', updated_at = '2021-06-23' where id = 22;

-- 3. 
insert into genres (created_at, updated_at, name, ranking) values ('2021-06-23', '2021-06-23', 'Animación para Adultos', 13);

-- 4.
update movies set genre_id = 13 where id = 22;

-- 5. 
update actors set favorite_movie_id = 13 where id = 1;

-- 6. 
create temporary table movies_copie as select * from movies;
select * from movies_copie;
alter table movies_copie add primary key(id);

-- 7. 
delete from movies_copie where awards < 5;

-- 8.
select distinct genres.name from genres join movies_copie on genres.id = movies_copie.genre_id;

-- 9.
SELECT distinct actors.first_name, actors.last_name FROM movies_copie JOIN (actor_movie JOIN actors ON actor_movie.actor_id = actors.id) ON movies_copie.id = actor_movie.movie_id WHERE movies_copie.awards > 3;

-- 11. Los indices son un mecanismo que usan las bases de datos para optimizar las consultas en SQL
-- sirben para mejorar la performance  en Queries complejas.

-- 12. 
create index movies_name_idx on movies(title);

-- 13. 
show index from movies;

