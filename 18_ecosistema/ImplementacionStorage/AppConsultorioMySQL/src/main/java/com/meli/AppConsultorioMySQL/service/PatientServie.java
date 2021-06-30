package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.PatientDTO;
import com.meli.AppConsultorioMySQL.models.Patient;
import com.meli.AppConsultorioMySQL.repositories.IPatientRepository;
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
public class PatientServie implements IPtientService {

    @Autowired
    ModelMapper mapper;

    IPatientRepository iPatientRepository;

    @Override
    public void createPatient(Patient student) {
        iPatientRepository.save(student);

    }

    @Override
    public void deletePatient(Patient student) {
        iPatientRepository.delete(student);

    }

    @Override
    public List<Patient> findAll() {
        return iPatientRepository.findAll(PageRequest.of(1,50)).getContent();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return iPatientRepository.findById(id);
    }

    @Override
    public void updateStudent(Patient student) {
        iPatientRepository.save(student);
    }
    @Override
    public List<PatientDTO> getAllPatientsByDate(String date) throws ParseException {
        Date date_convert = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Patient> patientList = iPatientRepository.getAllPatientsByDate(date_convert);
        return patientList.stream().map(patient -> mapper.map(patient, PatientDTO.class)).collect(Collectors.toList());

    }

}

