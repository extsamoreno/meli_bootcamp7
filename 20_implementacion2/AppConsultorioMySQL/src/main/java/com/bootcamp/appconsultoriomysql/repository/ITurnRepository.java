package com.bootcamp.appconsultoriomysql.repository;

import com.bootcamp.appconsultoriomysql.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {

    @Query("SELECT t FROM Turn t WHERE t.status = com.bootcamp.appconsultoriomysql.model.TurnStatus.FINALIZED")
    Set<Turn> findAllFinalized();

    @Query("SELECT t FROM Turn t WHERE t.status = com.bootcamp.appconsultoriomysql.model.TurnStatus.EARRING AND DATE(t.dateStart) = DATE(:day)")
    Set<Turn> findAllEarringOnDay(@Param("day") LocalDate day);

    @Query("SELECT t from Turn t where t.status = com.bootcamp.appconsultoriomysql.model.TurnStatus.REPROGRAMMED")
    Set<Turn> findAllReprogrammed();
}
