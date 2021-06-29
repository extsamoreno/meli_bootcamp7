# 2.  --------------------------------------------------------------------------------
INSERT INTO movies
(id, created_at, updated_at, title, rating, awards,release_date, length, genre_id)
VALUES
(22,null,null, 'Identidad Desconocida', 7.1, 2,'2012-05-04', 90, null );

# 3.  --------------------------------------------------------------------------------
INSERT INTO genres
(id, created_at, updated_at, name, ranking, active)
VALUES
(13,'2021-07-04', null, ' New Gen', 13, 1);

# 4.  --------------------------------------------------------------------------------
UPDATE movies SET genre_id=13 WHERE id=22;

# 5.  --------------------------------------------------------------------------------
UPDATE actors SET favorite_movie_id=13 WHERE id=47;

# 6.  --------------------------------------------------------------------------------
CREATE TEMPORARY TABLE movies_copy (SELECT * FROM movies );

# 7.  --------------------------------------------------------------------------------
DELETE FROM movies_copy WHERE awards<5;

# 8.  --------------------------------------------------------------------------------
SELECT genres.name as genre_name, count(*) as total_movies FROM genres JOIN movies ON movies.genre_id = genres.id 
GROUP BY genres.name HAVING total_movies>=1;

# 9.  --------------------------------------------------------------------------------
CREATE TEMPORARY TABLE movies_3awards (SELECT * FROM movies WHERE awards>3);
SELECT first_name as actor_first_name, last_name as actor_last_name, favorite_movie_id, 
movies_3awards.title as movie_title, movies_3awards.awards as movie_awards
FROM actors JOIN movies_3awards ON movies_3awards.id=actors.favorite_movie_id;

# 12.  --------------------------------------------------------------------------------
CREATE INDEX movies_idx ON movies (title);

