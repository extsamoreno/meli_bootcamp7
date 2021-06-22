select * from movies;

select first_name, last_name, rating from actors;

select title AS 'Titulo' FROM series AS Series;

#5 ??

select first_name, last_name from actors where rating > 7.5;

select title, rating, awards from movies where rating > 7.5 and awards > 2;

select title, rating from movies order by rating;

select title from movies limit 1;

select * from movies order by rating desc limit 5;

select * from movies order by rating desc limit 5 offset 5;

select * from actors limit 10;

select * from actors limit 10 offset 20;

select * from actors limit 10 offset 40;

select title, rating from movies where title LIKE '%Toy Story%';

select * from actors where first_name LIKE 'Sam%';

select title from movies where release_date between  '2004-01-01' and  '2008-12-31';

select title from movies where rating > 3 and awards > 1 and release_date between '1988-01-01' and '2009-12-31' order by rating;

select title from movies where rating > 3 and awards > 1 and release_date between '1988-01-01' and '2009-12-31' order by rating limit 3 offset 9;
