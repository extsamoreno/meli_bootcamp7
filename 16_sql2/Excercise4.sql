SELECT gen.name, count(*) as 'total_movies' 
FROM genres gen
JOIN movies mov ON mov.genre_id = gen.id
GROUP BY genre_id 
HAVING total_movies >= 3