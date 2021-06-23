#==================PRIMERA PARTE=====================
#1) Definición de JOIN
#	En bases de datos, la sentencia JOIN permite realizar la intersección de registros
#	de dos tablas que presenten alguna característica en común.

#2) Tipos de JOIN
#	LEFT JOIN: Si tenemos una tabla A y una tabla B, un LEFT JOIN de A con B nos permitirá
# 	obtener los registros de la diferencia de (A - B) más la intersección de A y B. 
#	RIGHT JOIN: Si tenemos una tabla A y una tabla B, un RIGHT JOIN de A con B nos permitirá
# 	obtener los registros de la diferencia de (B - A) más la intersección de A y B.

#3) GROUP BY
#	Permite agrupar registros de una tabla según las columnas indicadas.
#	Termina generando un solo registro por cada grupo de filas que compartan la columnas indicadas.

#4) HAVING
#	El HAVING es utilizado agregar alguna condición a los registros resultantes que se obtienen luego de realizar un GROUP BY.

#5) Primer diagrama corresponde a un INNER JOIN, y el segundo diagrama corresponse a un LEFT JOIN

#6) DIAGRAMA 1
	#SELECT * FROM tabla_a ta
    #RIGHT JOIN tabla_b tb ON ta.comun_field = tb.c;
    
    #DIAGRAMA 2
	#SELECT * FROM tabla_a ta
    #FULL OUTER JOIN tabla_b tb ON ta.comun_field = tb.c


#=================SEGUNDA PARTE=====================
#1
SELECT se.title, gen.name
FROM series se
JOIN genres gen ON se.genre_id = gen.id; 

#2
SELECT epi.title, act.first_name, act.last_name
FROM actor_episode act_epi
JOIN actors act ON act.id = act_epi.actor_id
JOIN episodes epi ON epi.id = act_epi.episode_id;

#3
SELECT ser.title, COUNT(*) as total_episodes
FROM series ser
JOIN seasons sea ON sea.serie_id = ser.id
GROUP BY ser.id;

#4
SELECT gen.name, COUNT(*) as total_movies
FROM genres gen 
JOIN movies mov ON mov.genre_id = gen.id
GROUP BY gen.id HAVING total_movies >= 3;

#5
SELECT DISTINCT act.first_name, act.last_name
FROM actor_movie act_mov
JOIN actors act ON act.id = act_mov.actor_id
JOIN movies mov ON mov.id = act_mov.movie_id
WHERE mov.title LIKE "%guerra de las galaxias%";



