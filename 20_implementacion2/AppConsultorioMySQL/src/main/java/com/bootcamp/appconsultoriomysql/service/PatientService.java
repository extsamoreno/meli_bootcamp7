package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.PatientDTO;
import com.bootcamp.appconsultoriomysql.model.Patient;
import com.bootcamp.appconsultoriomysql.repository.IPatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Set<PatientDTO> findAllByTurnsInDay(LocalDateTime date) {

        Set<Patient> patients = patientRepository.findAllByTurnsOnDay(date);

        return patients.stream().map(p -> mapper.map(p, PatientDTO.class)).collect(Collectors.toSet());
    }
}
