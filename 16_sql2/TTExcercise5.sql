USE movies_db;
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title like 'El secreto de sus ojos')
WHERE first_name like 'Anna' and last_name like 'Gunn'