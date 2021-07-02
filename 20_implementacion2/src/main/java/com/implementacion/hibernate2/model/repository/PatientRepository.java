package com.implementacion.hibernate2.model.repository;

import com.implementacion.hibernate2.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("FROM Patient AS p JOIN Appointment AS a ON p.id = a.patient.id WHERE DATE(a.date) = DATE(:date)")
    List<Patient> findAllByDate(@Param("date") Date date);

    @Query("SELECT p.name, d.name, a.status FROM Patient p "+
            "JOIN Appointment a ON p.id = a.patient.id "+
            "JOIN Schedule s ON a.schedule.id = s.id "+
            "JOIN Dentist d ON s.id = d.schedule.id "+
            "WHERE (DATE(a.date) = DATE(:date))")
    List<Object[]> findAllDetailsByDate(@Param("date") Date date);
}
