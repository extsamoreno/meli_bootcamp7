SELECT mo.title, ge.name as 'genre'
FROM movies mo
JOIN genres ge ON mo.genre_id = ge.id