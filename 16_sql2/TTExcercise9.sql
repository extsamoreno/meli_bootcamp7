SELECT *
FROM actors
WHERE favorite_movie_id IN (SELECT id FROM movies WHERE awards > 3)