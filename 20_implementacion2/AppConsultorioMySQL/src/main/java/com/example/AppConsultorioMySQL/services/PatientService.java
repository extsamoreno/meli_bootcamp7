package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Patient;
import com.example.AppConsultorioMySQL.repositories.IPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService implements  IPatientService{
    IPatientRepository patientRepository;

    @Override
    public String addPatient(Patient patient) {
        return null;
    }

    @Override
    public String updatePatient(Patient patient) {
        return null;
    }

    @Override
    public String deletePatient(Patient patient) {
        return null;
    }
}
