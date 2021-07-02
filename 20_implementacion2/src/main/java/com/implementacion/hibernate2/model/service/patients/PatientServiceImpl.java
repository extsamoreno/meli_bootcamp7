package com.implementacion.hibernate2.model.service.patients;

import com.implementacion.hibernate2.controller.dto.patients.PatientDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientListDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientsListDTO;
import com.implementacion.hibernate2.model.entity.Patient;
import com.implementacion.hibernate2.model.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Override
    public PatientListDetailsDTO listAllPatientsDetailsByDate(String date) {
        Date actualDate = convertDate(date);
        List<Object[]> outputQuery = patientRepository.findAllDetailsByDate(actualDate);
        List<PatientDetailsDTO> patientDetailsDTOList = outputQuery.stream()
                .map((obj) -> new PatientDetailsDTO((String) obj[0], (String) obj[1], (String) obj[2]))
                .collect(Collectors.toList());

        return new PatientListDetailsDTO(date, patientDetailsDTOList);
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
