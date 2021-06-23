/*2*/
select * from movies;

/*3*/
select 	first_name, last_name, rating from actors;

/*4*/
select title as titulo from series as series;

/*5*/
select title as titulo from series as series where type='income';

/*6*/
select 	first_name, last_name from actors where rating > 7.5;

/*7*/
select title,rating,awards from movies where rating > 7.5 and awards > 2;

/*8*/
select title,rating from movies order by rating;

/*9*/
select title from movies limit 3;

/*10*/
select * from movies order by rating desc limit 5;

/*11*/
select * from movies order by rating desc limit 5,5;

/*12*/
select * from actors limit 10;

/*13*/
select * from actors limit 10 offset 20;

/*14*/
select * from actors limit 10 offset 40;

/*15*/
select title,rating from movies where title like '%Toy Story%';

/*16*/
select * from actors where first_name like 'Sam%';

/*17*/
select title from movies where release_date between '2004-01-01 00:00:00' and '2008-12-31 23:59:59';

/*18*/
select title from movies where rating > 3 and awards > 1 and release_date between '1988-01-01 00:00:00' and '2009-12-31 23:59:59' order by rating;

/*19*/
select title from movies where rating > 3 and awards > 1 and release_date between '1988-01-01 00:00:00' and '2009-12-31 23:59:59' order by rating limit 3 offset 10;

