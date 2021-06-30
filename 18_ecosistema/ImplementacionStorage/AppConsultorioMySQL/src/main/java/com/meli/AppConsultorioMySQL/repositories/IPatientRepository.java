package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT distinct p FROM Patient p join Apoointment a on p.id=a.patient.id where YEAR(a.date)=YEAR(:date) and MONTH(a.date)=MONTH(:date) and DAY(a.date)=DAY(:date) ")
    List<Patient> getAllPatientsByDate(Date date);
}
