package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {

    //Listar todos los pacientes de un día de todos los dentistas.
    @Query("select p from Patient p " +
            "join p.turnSet t " +
            "join t.dentistset ds " +
            "where t.startTime = :date ")
    List<Patient> getPatientByDateForDentists(@Param("date") LocalDateTime date);
}
