SELECT name
FROM genres
WHERE id IN (SELECT genre_id FROM movies)