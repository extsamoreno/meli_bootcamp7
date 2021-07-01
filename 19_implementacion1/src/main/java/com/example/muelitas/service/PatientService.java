package com.example.muelitas.service;

import com.example.muelitas.dto.PatientDTO;
import com.example.muelitas.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {
    ResponseDTO createPatient(PatientDTO newPatient);
    PatientDTO readPatient(Long idPatient);
    ResponseDTO updatePatient(PatientDTO updatedPatient);
    ResponseDTO deletePatient(Long idPatient);
}
