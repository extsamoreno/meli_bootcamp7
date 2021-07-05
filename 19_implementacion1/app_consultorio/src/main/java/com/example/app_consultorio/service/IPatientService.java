package com.example.app_consultorio.service;

import com.example.app_consultorio.dto.PatientDTO;
import com.example.app_consultorio.model.Patient;

import java.util.List;

public interface IPatientService {
    void createPatient(Patient patient);

    void deletePatientById(Long id);

    void updatePatient(Patient patient);

    List<PatientDTO> findAllPatients();

    List<PatientDTO> findAllPatientsByDate(String date);
}
