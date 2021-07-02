package com.example.AppConsultorioMySQL.repositories;

import com.example.AppConsultorioMySQL.models.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
    // Listar todos los pacientes de un día de todos los dentistas.
    @Query(value = "select distinct p.* from turns t inner join schedules s on s.id = t.schedule_id inner join patients p on p.id = t.patient_id where s.date = :date", nativeQuery = true)
    List<Patient> listPatientsByDate(@Param("date") LocalDate date);
}
