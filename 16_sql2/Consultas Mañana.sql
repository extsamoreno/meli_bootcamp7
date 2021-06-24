-- 1.
SELECT series.title, genres.name FROM series JOIN genres ON series.genre_id = genres.id;

-- 2.
SELECT episodes.title, actors.first_name, actors.last_name FROM episodes JOIN (actor_episode JOIN actors ON actor_episode.actor_id = actors.id) ON episodes.id = actors.id;

-- 3.
SELECT series.title, count(*) as 'total seasons' FROM series JOIN seasons ON series.id = seasons.serie_id GROUP BY series.title;

-- 4.
SELECT genres.name, count(*) as total_movies FROM genres JOIN movies ON genres.id = movies.genre_id GROUP BY genres.name HAVING total_movies >= 3;

-- 5.
SELECT distinct actors.first_name, actors.last_name FROM movies JOIN (actor_movie JOIN actors ON actor_movie.actor_id = actors.id) ON movies.id = actor_movie.movie_id WHERE movies.title LIKE "%guerra de las galaxias%";
