package com.example.dentaloffice.service;

import com.example.dentaloffice.model.dto.request.CreatePatientDTO;
import com.example.dentaloffice.model.dto.response.PatientDTO;
import com.example.dentaloffice.model.entity.Patient;
import com.example.dentaloffice.repository.IPatientRepository;
import com.example.dentaloffice.service.mapper.IMyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService{

    // Inyected by constructor
    IPatientRepository iPatientRepository;
    IMyMapper iMyMapper;

    @Override
    public String createPatient(CreatePatientDTO patient) {
        Patient newPatient = new Patient();
        newPatient.setName(patient.getName());
        newPatient.setSurname(patient.getSurname());
        newPatient.setDni(patient.getDni());
        iPatientRepository.save(newPatient);
        return "Patient created correctly";
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<PatientDTO> patientDTOS = iPatientRepository.findAll()
                .stream()
                .map(p -> iMyMapper.toPatientDTO(p))
                .collect(Collectors.toList());
        return patientDTOS;
    }
}
