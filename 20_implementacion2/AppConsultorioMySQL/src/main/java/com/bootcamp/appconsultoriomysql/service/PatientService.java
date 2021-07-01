package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.PatientDTO;
import com.bootcamp.appconsultoriomysql.model.Patient;
import com.bootcamp.appconsultoriomysql.repository.IPatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;


@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Patient create(PatientDTO patientDTO) {
        Patient patient = mapper.map(patientDTO, Patient.class);

        return patientRepository.save(patient);
    }

    @Override
    public Set<Patient> findAllByTurnsInDay(LocalDateTime date) {
        return patientRepository.findAllByTurnsInDay(date);
    }

    @Override
    public Optional<Patient> findById(Long id) {

        return patientRepository.findById(id);
    }
}
