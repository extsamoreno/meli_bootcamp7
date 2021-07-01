package com.meli.consultorio.repositories;

import com.meli.consultorio.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Set;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
//    @Query("FROM Patient p JOIN Appointment a ON p.id = a.patient.id WHERE a.appointmentDate BETWEEN :from AND :to")
//    Set<Patient> findPatientsByDate(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
