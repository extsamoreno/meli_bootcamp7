package com.meli.Muelitas.service;


import com.meli.Muelitas.model.DTO.PatientDTO;
import com.meli.Muelitas.model.Patient;
import com.meli.Muelitas.repositories.IPatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService {

    @Autowired
    ModelMapper mapper;

    IPatientRepository iPatientRepository;

    @Override
    public List<Patient> findAll() {
        return iPatientRepository.findAll(PageRequest.of(1,50)).getContent();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return iPatientRepository.findById(id);
    }

    @Override
    public void updatePatient(Patient patient) {
        iPatientRepository.save(patient);
    }

    @Override
    public List<PatientDTO> getAllPatientsByDate(String date) throws ParseException {
        Date date_convert = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Patient> patientList = iPatientRepository.getAllPatientsByDate(date_convert);
        return patientList.stream().map(patient -> mapper.map(patient, PatientDTO.class)).collect(Collectors.toList());

    }

}

