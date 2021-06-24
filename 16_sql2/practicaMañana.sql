use movies_bd;

#1
SELECT se.title, ge.name FROM series se
JOIN genres ge
ON se.genre_id = ge.id;


#2
SELECT ep.title, ac.first_name, ac.last_name FROM actor_episode ac_ep
JOIN actors ac
ON ac.id =ac_ep.actor_id
JOIN episodes ep
ON ep.id =ac_ep.episode_id;


#3
SELECT se.title, count(*) as "Cant de temporadas"  FROM series se
JOIN seasons temp
ON se.id =temp.serie_id
GROUP BY temp.serie_id;


#4
SELECT ge.name, count(*) as totMovies  FROM genres ge
JOIN  movies mo
ON ge.id = mo.genre_id
GROUP BY ge.id HAVING totMovies >=3





