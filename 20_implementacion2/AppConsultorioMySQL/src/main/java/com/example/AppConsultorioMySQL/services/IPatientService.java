package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Patient;

import java.util.List;

public interface IPatientService {
    String createPatient(Patient patient);
    String updatePatient(Patient patient);
    String deletePatient(Long id);
    List<Patient> findAllPatients();
    Patient findPatientById(Long id);
}
