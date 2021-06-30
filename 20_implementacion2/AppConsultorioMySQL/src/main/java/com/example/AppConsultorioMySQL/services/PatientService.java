package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Dentist;
import com.example.AppConsultorioMySQL.models.entities.Patient;
import com.example.AppConsultorioMySQL.repositories.IPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService implements  IPatientService{
    IPatientRepository patientRepository;


    @Override
    public String createPatient(Patient patient) {
        patientRepository.save(patient);
        return "Se creó el paciente correctamente";
    }

    @Override
    public String updatePatient(Patient patient) {
        return null;
    }

    @Override
    public String deletePatient(Long id) {
        return null;
    }

    @Override
    public List<Patient> findAllPatients() {
        return null;
    }

    @Override
    public Patient findPatientById(Long id) {
        return null;
    }
}
