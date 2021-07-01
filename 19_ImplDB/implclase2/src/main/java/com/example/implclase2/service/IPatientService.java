package com.example.implclase2.service;

import com.example.implclase2.model.dto.RequestCreatePatientDTO;
import com.example.implclase2.model.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPatientService {
    String createPatient(RequestCreatePatientDTO patient);

    List<Patient> getAllPatients();
}
