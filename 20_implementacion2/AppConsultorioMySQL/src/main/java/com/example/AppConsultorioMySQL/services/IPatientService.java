package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.PatientNotFoundException;
import com.example.AppConsultorioMySQL.dtos.PatientDTO;

import java.time.LocalDate;
import java.util.List;

public interface IPatientService {
    String createPatient(PatientDTO patient);
    String updatePatient(PatientDTO patient) throws PatientNotFoundException;
    String deletePatient(Long id) throws PatientNotFoundException;
    List<PatientDTO> findAllPatients();
    PatientDTO findPatientById(Long id) throws PatientNotFoundException;

    List<PatientDTO> listPatientsByDate (LocalDate date);
}
