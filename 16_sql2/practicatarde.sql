-- 1 Explique el concpeto de normalizaación y para que se utiliza 
-- Es un proceso que se utiliza para evitar la redundancia de datos e inconsistencia de datos.

-- 2
insert into movies(created_at, updated_at, title, rating, awards, release_date, length, genre_id)
values(CURDATE(), CURDATE(), 'Spiderman into the spiderverse', 10, 10, CURDATE(), 160, 7);

-- 3 
insert into genres(created_at, updated_at, name, ranking, active)
values(CURDATE(), CURDATE(), 'genero', 20, 1 );

-- 4
update movies set genre_id = 14 where id = 22;

-- 5
update actor_movie set movie_id = 14 where id = 43;

-- 6 
create temporary table movies_copy
select * from movies;