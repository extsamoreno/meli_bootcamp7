package com.implementacion.hibernate2.model.service.patients;

import com.implementacion.hibernate2.controller.dto.DentistDTO;
import com.implementacion.hibernate2.controller.dto.PatientDTO;
import com.implementacion.hibernate2.controller.dto.PatientsListDTO;
import com.implementacion.hibernate2.model.dao.Patient;
import com.implementacion.hibernate2.model.repository.DentistRepository;
import com.implementacion.hibernate2.model.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements IPatientService{

    private final PatientRepository patientRepository;
    private final ModelMapper mapper;

    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper mapper){
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    @Override
    public PatientsListDTO listAllPatientsByDate(String date) {
        Date actualDate = convertDate(date);
        List<Patient> patients = patientRepository.findAllByDate(actualDate);
        List<PatientDTO> patientDTOList = patients.stream()
                                                    .map( patient ->  mapper.map(patient, PatientDTO.class) )
                                                    .collect(Collectors.toList());
        return new PatientsListDTO(patientDTOList);
    }

    private Date convertDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
