SELECT title FROM movies_db.movies
WHERE release_date BETWEEN '1988-01-01' AND '2009-12-31' AND rating>3 AND awards>1
ORDER BY rating LIMIT 3 OFFSET 10;