package com.meli.muelitas.service;

import com.meli.muelitas.dto.PatientDTO;

import java.util.List;

public interface IPatientService {

    void createPatient(PatientDTO patientDTO);

    PatientDTO getPatientByNit(String nit);

    PatientDTO getPatientById(Long id);

    PatientDTO getPatientByName(String name);

    List<PatientDTO> getPatientList();

}
