/*2*/
insert into movies values (22,NULL,NULL,'La Guerra de las galaxias: Episode VIII',7.9,3,'2010-10-04 00:00:00',120,5);

/*3*/
insert into genres values (13,'2016-07-04 03:00:00',NULL,'Historica',13,1);

/*4*/
update movies set genre_id = 13 where id = 22;
select * from actors;

/*5*/
update actors set favorite_movie_id = 22 where id = 1;

/*6*/
create temporary table if not exists movies_temp as (select * from movies);

/*7*/
delete from movies_temp where awards < 5;

/*8*/
select genres.* from genres join movies on genres.id=movies.genre_id group by movies.genre_id having count(genre_id)>=1;

/*9*/
select actors.* from actors join actor_movie on actors.id = actor_movie.actor_id join movies on actor_movie.movie_id = movies.id where movies.awards > 3;

/*10*/
explain select * from movies_temp;
explain select * from actors;

/*12*/
create index index_movies on movies (id);

/*13*/
show index from movies;