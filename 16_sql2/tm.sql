#Primera Parte
#Act 5
#a_ Inner Join
#a_ Left Join

#Act 6
#a_ select * from tabl_1 right join tabl_2 on tabl_1.ref_id = tabl_2.id;
#b_ select * from tabl_1 full join tabl_2 on tabl_1.ref_id = tabl_2.id;

#Segunda Parte
#Act 1
SELECT series.title, genres.name FROM series
INNER JOIN genres ON series.genre_id = genres.id;

#Act 2
SELECT episodes.title, actors.first_name, actors.last_name FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

#Act 3
SELECT series.title, COUNT(seasons.id) FROM series
INNER JOIN seasons ON seasons.serie_id = series.id
GROUP BY series.title;

#Act 4
SELECT genres.name, COUNT(movies.id) as movies_count FROM genres
INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING movies_count >= 3;

#Act 5
select distinct actors.first_name, actors.last_name from actors
inner join actor_movie on actors.id=actor_movie.actor_id
inner join movies on movies.id=actor_movie.movie_id
where title like "%La Guerra de las galaxias%";