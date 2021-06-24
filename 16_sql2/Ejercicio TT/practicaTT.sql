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

# 5.  --------------------------------------------------------------------------------
CREATE TEMPORARY TABLE movies_copy (SELECT * FROM movies );

# 5.  --------------------------------------------------------------------------------
DELETE FROM movies_copy WHERE awards<5;







