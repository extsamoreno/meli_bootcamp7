use movies_db;
/** Mostrar el título y el nombre del género de todas las series. **/
SELECT se.title, gn.name FROM series se LEFT JOIN genres gn on gn.id = se.genre_id;

/** Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en
cada uno de ellos.. **/
SELECT ep.title, ac.first_name, ac.last_name
FROM episodes ep
         JOIN actor_episode ae
              ON ep.id = ae.episode_id
         JOIN actors ac
              ON ae.actor_id = ac.id;

/** Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas **/
SELECT se.title, count(*) as "temporadas"
FROM series se
         RIGHT JOIN seasons sea
                    ON se.id = sea.serie_id
GROUP BY sea.serie_id;


/** Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.**/
SELECT gen.name, count(mov.id) AS "peliculas"
FROM genres gen
         JOIN movies mov
              ON gen.id = mov.genre_id
GROUP BY gen.name
HAVING peliculas >= 3;

select * from movies;
select * from actor_movie;

/**Mostrar sólo el nombre y apellido de los actores que trabajan en TODAS las películas de la guerra de las galaxias y que estos no se repitan.**/
SELECT ac.first_name, ac.last_name
FROM movies mo
         JOIN actor_movie am
              ON mo.id = am.movie_id
         JOIN actors ac
              ON am.actor_id = ac.id
WHERE mo.title LIKE "La Guerra de las galaxias%"
GROUP BY ac.first_name, ac.last_name;