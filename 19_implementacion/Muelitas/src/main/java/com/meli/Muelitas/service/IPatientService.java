package com.meli.Muelitas.service;

import com.meli.Muelitas.model.DTO.PatientDTO;
import com.meli.Muelitas.model.Patient;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IPatientService {

    List<Patient> findAll();

    Optional<Patient> findById(Long id);

    void updatePatient(Patient patient);

    List<PatientDTO> getAllPatientsByDate(String date) throws ParseException;
}
