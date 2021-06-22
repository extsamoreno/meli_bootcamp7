/* 2. Mostrar todos los registros de la tabla de movies. */
SELECT * FROM movies_db.movies;
/* 3. Mostrar el nombre, apellido y rating de todos los actores. */
SELECT a1.first_name, a1.last_name, a1.rating FROM movies_db.actors a1;
/* 4. Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla 
como el campo estén en español */
SELECT s1.title as "TíTULO" FROM movies_db.series s1;
/* 5. Aplicarle a la consulta anterior un filtro por type en donde este sea igual a income. */

/* 6. Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5. */
SELECT act.first_name, act.last_name FROM movies_db.actors act where act.rating > 7.5;
/*7. Mostrar el título de las películas, el rating y los premios de las películas con un rating
mayor a 7.5 y con más de dos premios.*/
SELECT mov.title, mov.rating, mov.awards FROM movies_db.movies mov 
	where mov.rating > 7.5 and mov.awards > 2;
/*8. Mostrar el título de las películas y el rating ordenadas por rating en forma
ascendente.*/
SELECT mov.title, mov.rating FROM movies_db.movies mov 
	ORDER BY mov.rating asc;
/*9. Mostrar los títulos de las primeras tres películas en la base de datos.*/
SELECT mov.title FROM movies_db.movies mov 
	order by mov.id asc 
    limit 3;
/*10. Mostrar el top 5 de las películas con mayor rating.*/
SELECT mov.title, mov.rating FROM movies_db.movies mov
	order by mov.rating desc
    limit 5;
/*11. Mostrar las top 5 a 10 de las películas con mayor rating.*/
SELECT mov.title, mov.rating FROM movies_db.movies mov
	order by mov.rating desc
    limit 5,5;
/*12. Listar los primeros 10 actores (sería la página 1),*/
SELECT * FROM movies_db.actors limit 10;
/*13. Luego usar offset para traer la página 3*/
SELECT * FROM movies_db.actors limit 10 offset 3;
/*13. Luego usar offset para traer la página 5*/
SELECT * FROM movies_db.actors limit 10 offset 5;
/*15. Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.*/
SELECT mov.title, mov.rating FROM movies_db.movies mov
	where mov.title like "Toy Story";
/*16. Mostrar a todos los actores cuyos nombres empiecen con Sam.*/
SELECT * FROM movies_db.actors act
	where act.first_name like "Sam%";
/*17. Mostrar el título de las películas que salieron entre el 2004 y 2008.*/
SELECT mov.title FROM movies_db.movies mov
	where year(release_date) between 2004 and 2008;
/*18. Traer el título de las películas con el rating mayor a 3, con más de 1 premio y
con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por
rating.*/
SELECT mov.title FROM movies_db.movies mov
	where mov.rating > 3 and mov.awards > 1 and year(mov.release_date) between 1988 and 2009
    order by mov.rating;
/*19. Traer el top 3 a partir del registro 10 de la consulta anterior.*/
SELECT mov.title FROM movies_db.movies mov
	where mov.rating > 3 and mov.awards > 1 and year(mov.release_date) between 1988 and 2009
    order by mov.rating
    limit 10, 3;