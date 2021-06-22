## Consultas SQL MOVIES

1. SELECT * FROM MOVIES;

2. SELECT first_name, last_name, rating FROM actors; 

3. SELECT title as "título" FROM series s;

4. SELECT first_name, last_name FROM actors
    WHERE rating > 7.50;

5. SELECT title, rating, awards FROM movies
    WHERE rating > 7.50 AND awards > 2;
    

6. SELECT title, rating FROM movies
    ORDER BY rating;

7. SELECT title FROM movies
    LIMIT 3;

8. SELECT * FROM movies
    ORDER BY rating DESC
    LIMIT 5;

9. SELECT * FROM movies
    ORDER BY rating DESC
    LIMIT 5
    OFFSET 5;

10. SELECT * FROM actors      
      OFFSET 20;

11. SELECT * FROM actors
      LIMIT 10
      OFFSET 20;

12. SELECT * FROM actors
      LIMIT 10
      OFFSET 40;

13. SELECT title, rating FROM movies
      WHERE title LIKE "Toy Story%";

14. SELECT * FROM actors
      WHERE first_name LIKE "Sam%";

15. SELECT * FROM movies
      WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

16. SELECT title
      FROM movies
      WHERE rating > 3 
      AND awards > 1 
      AND YEAR(release_date) BETWEEN 1988 AND 2009
      ORDER BY rating DESC;

17. SELECT title
      FROM movies
      WHERE rating > 3 
      AND awards > 1 
      AND YEAR(release_date) BETWEEN 1988 AND 2009
      ORDER BY rating DESC
      LIMIT 3
      OFFSET 10;
      
      
