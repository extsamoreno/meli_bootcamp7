package com.meli.Muelitas.repositories;


import com.meli.Muelitas.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT distinct p FROM Patient p join Appointment a on p.id=a.patient.id where YEAR(a.date)=YEAR(:date) and MONTH(a.date)=MONTH(:date) and DAY(a.date)=DAY(:date) ")
    List<Patient> getAllPatientsByDate(Date date);
}
