package com.example.app_consultorio.repository;

import com.example.app_consultorio.model.Dentist;
import com.example.app_consultorio.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT app.patient FROM Appointment app WHERE app.date=:date")
    List<Patient> findAllPatientsByDate(LocalDate date);
}
