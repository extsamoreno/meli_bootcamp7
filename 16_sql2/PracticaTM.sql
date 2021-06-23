/*1*/
select title,name from series join genres on genres.id=series.genre_id;

/*2*/
select title,first_name,last_name from episodes join actor_episode on episodes.id = actor_episode.id join actors on actor_episode.id=actors.id;

/*3*/
select series.title, count(serie_id) from series join seasons on series.id=seasons.serie_id group by serie_id;

/*4*/
select genres.name, count(genre_id) as cantidad from genres join movies on genres.id=movies.genre_id group by genre_id having cantidad >= 3;

/*5*/
select distinct first_name,last_name from actors join actor_movie on actors.id = actor_movie.actor_id
join movies on movies.id = actor_movie.movie_id 
where title like "La Guerra de las galaxias%"
group by actors.id having count(*) >= (select count(*) from movies where title like "La Guerra de las galaxias%");