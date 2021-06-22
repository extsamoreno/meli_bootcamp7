SELECT title
FROM movies
WHERE rating > 3
and awards > 1
and release_date BETWEEN '1988-01-01' and '2009-12-31'
ORDER BY rating desc, title
LIMIT 3