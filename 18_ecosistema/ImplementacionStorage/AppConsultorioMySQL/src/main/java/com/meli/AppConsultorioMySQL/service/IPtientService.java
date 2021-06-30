package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.PatientDTO;
import com.meli.AppConsultorioMySQL.models.Patient;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPtientService {

    public void createPatient(Patient student);

    public void deletePatient(Patient student);

    List<Patient> findAll();

    Optional<Patient> findById(Long id);

    void updateStudent(Patient student);

    List<PatientDTO> getAllPatientsByDate(String date) throws ParseException;
}
