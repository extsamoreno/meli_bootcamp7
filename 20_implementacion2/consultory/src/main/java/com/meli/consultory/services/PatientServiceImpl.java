package com.meli.consultory.services;

import com.meli.consultory.models.Patient;
import com.meli.consultory.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

public class PatientServiceImpl implements PatientService{

    PatientRepository patientRepository;

    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
