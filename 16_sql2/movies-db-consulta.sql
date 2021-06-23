USE movies_db;
-- 1 
SELECT se.title, ge.name from series se
JOIN genres ge
ON ge.id = se.genre_id;

-- 2
SELECT ep.title, co.first_name, co.last_name FROM 
(SELECT ac.first_name first_name, ac.last_name last_name, acp.episode_id episode_id FROM actors ac
JOIN actor_episode acp
ON ac.id = acp.actor_id) co, episodes ep
WHERE co.episode_id = ep.id;


-- 3

SELECT se.title, count(ss.id)  from series se
JOIN seasons ss
ON ss.serie_id = se.id
GROUP BY se.title; 

-- 4
SELECT (ge.name) as "nombre de género", count(ge.id) as "cantidad de peliculas" FROM genres ge, movies mo
WHERE mo.genre_id = ge.id
group by ge.name
having count(ge.id) > 3;

-- 5
SELECT distinct(co.first_name), co.last_name FROM 
(SELECT ac.first_name first_name, ac.last_name last_name, acp.movie_id movie_id FROM actors ac
JOIN actor_movie acp
ON ac.id = acp.actor_id) co, movies mo
WHERE UPPER(mo.title) LIKE '%LA GUERRA DE LAS GALAXIAS%' and co.movie_id = mo.id;

-- 5.2
SELECT co.first_name, co.last_name FROM 
(SELECT ac.first_name first_name, ac.last_name last_name, acp.movie_id movie_id, ac.id actor_id FROM actors ac
JOIN actor_movie acp
ON ac.id = acp.actor_id) co, movies mo
WHERE UPPER(mo.title) LIKE '%LA GUERRA DE LAS GALAXIAS%' and co.movie_id = mo.id
group by co.actor_id 
having count(co.actor_id) = (SELECT count(*) FROM movies WHERE title LIKE '%LA GUERRA DE LAS GALAXIAS%');

commit;

insert into actors (first_name, last_name, rating, favorite_movie_id) values ("Mariano", "Talenti", 1.0, 9);
insert into actor_movie (actor_id, movie_id) values (50, 3);
	
    


