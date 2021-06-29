package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Patient;

public interface IPatientService {
    String addPatient(Patient patient);
    String updatePatient(Patient patient);
    String deletePatient(Patient patient);
}
