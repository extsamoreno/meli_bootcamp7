#Act 2
select * from movies;

#Act 3
select first_name, last_name, rating from actors;

#Act 4-5
#Falta act 5
select title as "titulo" from series;

#Act 6
select first_name, last_name from actors where rating > 7.5;

#Act 7
select title, rating, awards from movies where rating > 7.5 and awards >2;

#Act 8
select title, rating from movies order by rating asc;

#Act 9
select title from movies limit 3;

#Act 10
select * from movies order by rating desc limit 5;

#Act 11
select * from movies order by rating desc limit 5 offset 5;

#Act 12
select * from actors limit 10;

#Act 13
select * from actors limit 10 offset 20;

#Act 14
select * from actors limit 10 offset 40;

#Act 15
select * from movies where title like "%Toy Story%";

#Act 16
select * from actors where first_name like "Sam%";

#Act 17
select title from movies where year(release_date) between 2004 and 2008;

#Act 18
select title from movies where rating > 3 and awards > 1 and year(release_date) between 1988 and 2009 order by rating;

#Act 19
select title from movies where rating > 3 and awards > 1 and year(release_date) between 1988 and 2009 order by rating limit 10,3;