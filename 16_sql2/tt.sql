#Act 2
insert into movies (created_at, title, rating, awards, release_date, length, genre_id) 
	values (now(),"Violet Evergarden Gaiden", 8.4, 0, "2019-9-6", 91,3);
    
#Act 3
insert into genres(created_at, name, ranking, active) values(now(),"Slices of Life", 14, 1);

#Act 4
update movies set genre_id = 15 where movies.id = 22;

#Act 5
update actors set favorite_movie_id = 14 where actors.id = 1;

#Act 6
create temporary table movies_copy select * from movies;

#Act 7
delete from movies_copy where awards<5;

#Act 8
select genres.*, count(movies.id) as "movies_count" from genres 
	left join movies on movies.genre_id = genres.id
    group by genres.id
    having movies_count >= 1
    order by movies_count desc;
    
#Act 9
select actors.*, movies.awards
	from actors join movies on actors.favorite_movie_id = movies.id
    where movies.awards > 3;
    
    
    
    
    