package com.example.implclase2.repository;

import com.example.implclase2.model.entity.Dentist;
import com.example.implclase2.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    //@Query("select p from patients p where p.patient_dni = :dni")
    Patient findPatientByDni(@Param("dni") String dni);
}
