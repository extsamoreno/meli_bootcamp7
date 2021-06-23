-- PRIMERA PARTE

#A qué se denomina JOIN en una base datos?
# A una union de dos tablas
#Nombre y explique 2 tipos de JOIN.
# Inner join: se unen dos tablas considerando solamente los campos que existan en ambas tablas
# left join: se unen dos tablas tomando todos los campos de la tabla izquierda
#Para qué se utiliza el GROUP BY?
# para agrupar filas que compartan algun valor
#Para qué se utiliza el HAVING?
# para filtrar luego del group by
#Dado lo siguientes diagramas indique a qué tipo de JOIN corresponde cada uno:
# inner join y left join
#Escriba una consulta genérica por cada uno de los diagramas a continuación:

SELECT * FROM movies_db.actors as actors
right join movies_db.movies as movies
on actors.favorite_movie_id = movies.id;

SELECT * FROM movies_db.actors as actors
right join movies_db.movies as movies
on actors.favorite_movie_id = movies.id
union
SELECT * FROM movies_db.actors as actors
left join movies_db.movies as movies
on actors.favorite_movie_id = movies.id;


#SEGUNDA PARTE

#Mostrar el título y el nombre del género de todas las series.
select s.title, g.name from movies_db.series as s
join movies_db.genres as g on s.genre_id = g.id;
#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en
#cada uno de ellos.
select e.title, a.first_name, a.last_name from movies_db.episodes as e
join movies_db.actor_episode as ae on e.id = ae.episode_id
join movies_db.actors as a on ae.actor_id = a.id;
#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select series.title, count(*) from series
join seasons on series.id = seasons.serie_id
group by series.title;
#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno,
# siempre que sea mayor o igual a 3.
select g.name, count(*) as c from genres as g 
join movies on g.id = movies.genre_id
group by name
having c>3;
#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de 
#la guerra de las galaxias y que estos no se repitan.
select distinct first_name, last_name from actors 
join actor_movie on actors.id = actor_movie.actor_id
join movies on movies.id = actor_movie.movie_id
where title like "La Guerra de%";

