package com.example.muelitas.service;

import com.example.muelitas.dto.PatientDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.model.Patient;
import com.example.muelitas.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImple implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseDTO createPatient(PatientDTO newPatient) {
        ResponseDTO response = new ResponseDTO();

        patientRepository.save(modelMapper.map(newPatient, Patient.class));

        response.setMessage("A new patient was created");
        response.setStatus(201);
        return response;
    }

    @Override
    public PatientDTO readPatient(Long idPatient) {
        PatientDTO responsePatient;
        Optional<Patient> dbPatient;

        dbPatient = patientRepository.findById(idPatient);

        responsePatient = modelMapper.map(dbPatient.get(), PatientDTO.class);
        return responsePatient;
    }

    @Override
    public ResponseDTO updatePatient(PatientDTO updatedPatient) {
        ResponseDTO response = new ResponseDTO();

        patientRepository.save(modelMapper.map(updatedPatient, Patient.class));

        response.setMessage("An existing patient was updated");
        response.setStatus(200);
        return response;
    }

    @Override
    public ResponseDTO deletePatient(Long idPatient) {
        ResponseDTO response = new ResponseDTO();

        patientRepository.deleteById(idPatient);

        response.setMessage("A patient was deleted");
        response.setStatus(200);
        return response;
    }


}
