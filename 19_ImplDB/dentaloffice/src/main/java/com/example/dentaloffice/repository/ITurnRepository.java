package com.example.dentaloffice.repository;

import com.example.dentaloffice.model.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {
    //@Query("select t from turns t where t.patient_dni = :dni")
    List<Turn> findTurnByPatientDni(@Param("dni") String dni);
    /*@Query("select t from Turns t where t.turn_datetime = :date")
    List<Turn> findTurnByDate(@Param("date") String date);*/
}
