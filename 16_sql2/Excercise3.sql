SELECT ser.title, count(*) as 'seasons'
FROM series ser
JOIN seasons sea ON sea.serie_id = ser.id
GROUP BY sea.serie_id