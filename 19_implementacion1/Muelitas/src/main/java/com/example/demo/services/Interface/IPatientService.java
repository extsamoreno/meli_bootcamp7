package com.example.demo.services.Interface;

import com.example.demo.model.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    void createPatient(Patient patient);
    void deleteStudent(Patient patient);
    List<Patient> findAll();
    Optional<Patient> findById(Integer id);
    void updateStudent(Patient patient);
}
