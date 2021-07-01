package com.example.implclase2.service;

import com.example.implclase2.model.dto.RequestCreatePatientDTO;
import com.example.implclase2.model.entity.Patient;
import com.example.implclase2.repository.IPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService{

    IPatientRepository iPatientRepository;

    @Override
    public String createPatient(RequestCreatePatientDTO patient) {
        Patient newPatient = new Patient();
        newPatient.setName(patient.getName());
        newPatient.setSurname(patient.getSurname());
        newPatient.setDni(patient.getDni());
        iPatientRepository.save(newPatient);
        return "Student created correctly";
    }

    @Override
    public List<Patient> getAllPatients() {
        return iPatientRepository.findAll();
    }
}
