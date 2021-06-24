
# PRIMERA PARTE

- A qué se denomina JOIN en una base datos?
  
 A la sentencia que tiene como funcion unir la informacion de dos tablas

- Nombre y explique 2 tipos de JOIN.

LEFT JOIN : trae toda la informacion de la tabla que antecede la sentecia LEFT JOIN y la informaciòn que tenga coincidencias con el atributo en el ON de la tabla que esta despues de la sentencia LEFT JOIN

RIGHT JOIN : trae toda la informacion de la tabla que esta desdpues de la sentecia LEFT JOIN y la informaciòn que tenga coincidencias con el atributo en el ON de la tabla que antecede de la sentencia LEFT JOIN

- Para qué se utiliza el GROUP BY?

para hacer consultas agrupada por atributos

- Para qué se utiliza el HAVING?

para hacer filtros sobre la informacion agrupada

- Dado lo siguientes diagramas indique a qué tipo de JOIN corresponde cada uno:

INNER JOIN, LEFT JOIN

- Escriba una consulta genérica por cada uno de los diagramas a continuación:

 SELECT * FROM table1 RIGHT JOIN tabla2 ON (table1.pk=table2.fk);
 SELECT * FROM table , tabla2;




# SEGUNDA PARTE

- Mostrar el título y el nombre del género de todas las series.

SELECT s.title, g.name FROM genres g INNER JOIN series s ON (g.id=s.genre_id);

- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en
cada uno de ellos.

SELECT e.title, a.first_name, a.last_name 
FROM episodes e INNER JOIN actor_episode a_e ON (a_e.episode_id= e.id) 
INNER JOIN actors a ON (a.id=a_e.actor_id);

- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT series.title, count(*) AS "cantidad de temporadas" 
FROM series INNER JOIN seasons ON (series.id= seasons.serie_id)
GROUP BY series.title;

- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT g.name, count(*) cantidad FROM genres g INNER JOIN movies m ON m.genre_id= g.id
GROUP BY g.name
HAVING cantidad>=3;

- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT a.first_name, a.last_name FROM movies m INNER JOIN actor_movie a_m ON (m.id=a_m.movie_id)
INNER JOIN actors a ON (a.id=actor_id)
WHERE title like "La Guerra de las galaxias%"
GROUP BY a.id
HAVING count(*)>= (SELECT count(*) FROM movies WHERE title like "La Guerra de las galaxias%");


#SEGUNDA PARTE

1. Explique el concepto de normalización y para que se utiliza.

Es un proceso de eliminacion de redundacia e inconsistencias, es usado para mejorar el diseño en cuanto a la facilitacion de consultas dentro del modelo

2. Agregue una película a la tabla movies.

INSERT INTO `movies_db`.`movies` (`title`, `rating`, `awards`, `release_date`, `length`) VALUES ('New Movie', '8.0', '2', '2012-05-04 00:00:00', '80');

3. Agregué un géneró a la tabla genres.

INSERT INTO `movies_db`.`genres` (`created_at`, `name`, `ranking`) VALUES ('2013-07-03 22:00:00', 'new genre', '13');

4. Asocie a la película del Ej 2. con el género creado en el Ej. 3.

UPDATE `movies_db`.`movies` SET `genre_id` = '13' WHERE (`id` = '22');

5. Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.

UPDATE `movies_db`.`actors` SET `favorite_movie_id` = '22' WHERE (`id` = '3');

6. Cree una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE movies_temporary (SELECT * FROM MOVIES);

7. Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

SET SQL_SAFE_UPDATES = 0;

DELETE FROM movies_temporary
WHERE awards<5;

8. Obtenga la lista de todas los géneros que tengan al menos una película.

SELECT DISTINCT(g.name) FROM movies m INNER JOIN genres  g ON m.genre_id=g.id;

9. Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.* FROM actors a INNER JOIN movies m ON a.favorite_movie_id=m.id
where m.awards>3;

10. Utilice el explain plan para analizar las consultas del Ej.6 y 7.

ERROR --> EXPLAIN CREATE TEMPORARY TABLE movies_temporary (SELECT * FROM MOVIES);

EXPLAIN DELETE FROM movies_temporary
WHERE awards<5;

![image](https://user-images.githubusercontent.com/84474950/123194169-a8972900-d46b-11eb-834b-c3e3ddfd187a.png)

11. Qué son los índices? Para qué sirven?

Son un mecanismo para crear una ruta directa hacia los datos evitando barridos y mejorando los tiempos de consulta

12. Cree un índice sobre el nombre en la tabla movies.

CREATE INDEX movies_name
ON MOVIES(title);

13. Chequee que el indice fue creado correctamente.

SHOW INDEX FROM MOVIES;

![image](https://user-images.githubusercontent.com/84474950/123194917-e052a080-d46c-11eb-9d21-be7a2a9431aa.png)

