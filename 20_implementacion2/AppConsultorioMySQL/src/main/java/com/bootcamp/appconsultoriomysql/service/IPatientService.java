package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.PatientDTO;
import com.bootcamp.appconsultoriomysql.model.Patient;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public interface IPatientService {
    Patient create(PatientDTO patientDTO);

    Set<Patient> findAllByTurnsInDay(LocalDateTime date);

    Optional<Patient> findById(Long id);

}
