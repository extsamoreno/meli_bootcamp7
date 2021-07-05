package com.muelitas.demo.services;

import com.muelitas.demo.dtos.PatientDTO;
import com.muelitas.demo.exceptions.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPatientService {
    void savePatient(PatientDTO patient);
    PatientDTO findPatientById(Long id) throws BadRequestException;
    List<PatientDTO> getAllPatients();
    PatientDTO updatePatient(PatientDTO patient) throws BadRequestException;
    void deletePatientById(Long id) throws BadRequestException;
}
