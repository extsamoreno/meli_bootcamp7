package com.implementacion.hibernate2.model.repository;

import com.implementacion.hibernate2.model.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("FROM Patient AS p JOIN Appointment AS a ON p.id = a.patient.id WHERE a.date = :date")
    List<Patient> findAllByDate(@Param("date") Date date);
}
