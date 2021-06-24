SELECT distinct act.first_name, act.last_name
FROM actors act
JOIN actor_movie actmov ON actmov.actor_id = act.id
JOIN movies mov ON mov.id = actmov.movie_id
WHERE mov.title like '%Guerra de las galaxias%'