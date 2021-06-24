USE movies_db;
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name like 'Romance')
WHERE title like 'El secreto de sus ojos'