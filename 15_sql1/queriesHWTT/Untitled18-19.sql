SELECT id, title, rating, release_date FROM movies
WHERE release_date BETWEEN "1988-01-01 00:00:00" AND "2010-01-01 00:00:00"
ORDER BY rating DESC
LIMIT 3; 