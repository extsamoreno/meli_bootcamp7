package com.meli.consultory.services;

import com.meli.consultory.models.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    public void createPatient(Patient patient);

    public void deletePatient(Patient patient);

    public List<Patient> findAll();

    public Optional<Patient> findById(Long id);

    public void updatePatient(Patient patient);
}
