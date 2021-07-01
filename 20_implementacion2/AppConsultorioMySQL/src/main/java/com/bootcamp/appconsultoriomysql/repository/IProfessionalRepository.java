package com.bootcamp.appconsultoriomysql.repository;

import com.bootcamp.appconsultoriomysql.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface IProfessionalRepository extends JpaRepository<Professional, Long> {

    @Query("SELECT p FROM Professional p INNER JOIN p.turns t WHERE DATE(t.dateStart) = DATE(:day) GROUP BY p.id HAVING COUNT(*) > 1 ")
    Set<Professional> findAllWithMoreThanTwoTurnsOnDay(@Param("day") LocalDateTime day);
}
