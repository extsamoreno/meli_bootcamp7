package com.meli.consultorio.services.patient;

import com.meli.consultorio.models.dtos.PatientDTO;

import java.util.Set;

public interface IPatientService {
    void createPatient(PatientDTO patientDTO);
    void deletePatientById(Long id);
    void updatePatient(PatientDTO patientDTO);
    Set<PatientDTO> findAllPatient();
    PatientDTO findPatientById(Long id);
}
