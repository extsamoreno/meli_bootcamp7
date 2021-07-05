package com.example.app_consultorio.service;

import com.example.app_consultorio.dto.DentistDTO;
import com.example.app_consultorio.dto.PatientDTO;
import com.example.app_consultorio.model.Patient;
import com.example.app_consultorio.repository.IPatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService{

    IPatientRepository patientRepository;
    ModelMapper mapper;

    @Override
    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public List<PatientDTO> findAllPatients() {

        List<PatientDTO> listPatientDTO = patientRepository.findAll(PageRequest.of(0, 10)).getContent().
                stream().map(e -> mapper.map(e, PatientDTO.class)).collect(Collectors.toList());

        return listPatientDTO;
    }


    // 1
    @Override
    public List<PatientDTO> findAllPatientsByDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        return patientRepository.findAllPatientsByDate(localDate).stream().map(e -> mapper.map(e, PatientDTO.class)).collect(Collectors.toList());
    }
}
