package com.bootcamp.appconsultoriomysql.repository;

import com.bootcamp.appconsultoriomysql.model.Professional;
import com.bootcamp.appconsultoriomysql.model.Turn;
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

    @Query("SELECT t FROM Turn t WHERE t.professional.id = :id")
    Set<Turn> getSchedule(@Param("id") Long id);

    @Query("SELECT t FROM Turn t " +
            "WHERE t.professional.id = :id AND t.status = com.bootcamp.appconsultoriomysql.model.TurnStatus.REPROGRAMMED")
    Set<Turn> getReprogrammedTurns(@Param("id") Long id);
}
