package com.example.dentaloffice.service;

import com.example.dentaloffice.model.dto.request.CreatePatientDTO;
import com.example.dentaloffice.model.dto.response.PatientDTO;

import java.util.List;

public interface IPatientService {
    String createPatient(CreatePatientDTO patient);

    List<PatientDTO> getAllPatients();
}
