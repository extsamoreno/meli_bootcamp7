package com.bootcamp.appconsultoriomysql.repository;

import com.bootcamp.appconsultoriomysql.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p INNER JOIN FETCH p.turns t  WHERE DATE(t.dateStart) = DATE(:date)")
    Set<Patient> findAllByTurnsInDay(@Param("date") LocalDateTime date);

    @Override
    Optional<Patient> findById(Long id);
}
