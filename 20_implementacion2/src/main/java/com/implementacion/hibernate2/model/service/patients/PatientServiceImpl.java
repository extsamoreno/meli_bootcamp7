package com.implementacion.hibernate2.model.service.patients;

import com.implementacion.hibernate2.controller.dto.dentists.DentistDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientListDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientsListDTO;
import com.implementacion.hibernate2.controller.dto.patients.request.NewPatientDTO;
import com.implementacion.hibernate2.model.entity.Dentist;
import com.implementacion.hibernate2.model.entity.Patient;
import com.implementacion.hibernate2.model.repository.PatientRepository;
import com.implementacion.hibernate2.model.service.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        Date actualDate = Utils.convertDate(date);
        List<Patient> patients = patientRepository.findAllByDate(actualDate);
        List<PatientDTO> patientDTOList = patients.stream()
                                                    .map( patient ->  mapper.map(patient, PatientDTO.class) )
                                                    .collect(Collectors.toList());
        return new PatientsListDTO(patientDTOList);
    }

    @Override
    public PatientListDetailsDTO listAllPatientsDetailsByDate(String date) {
        Date actualDate = Utils.convertDate(date);
        List<Object[]> outputQuery = patientRepository.findAllDetailsByDate(actualDate);
        List<PatientDetailsDTO> patientDetailsDTOList = outputQuery.stream()
                .map((obj) -> new PatientDetailsDTO((String) obj[0], (String) obj[1], (String) obj[2]))
                .collect(Collectors.toList());

        return new PatientListDetailsDTO(date, patientDetailsDTOList);
    }

    @Override
    public void insertNewPatient(NewPatientDTO newPatientDTO) {
        Patient patient = mapper.map(newPatientDTO, Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public PatientDTO getPatientByName(String name) {
        Optional<Patient> op = patientRepository.getByName(name);
        PatientDTO patientDTO = new PatientDTO();
        op.ifPresent(p ->  patientDTO.setName(p.getName()));
        return patientDTO;
    }

    @Override
    public PatientsListDTO getAllPatient() {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientDTO> patientDTOList = patientList.stream()
                .map( patient ->  mapper.map(patient, PatientDTO.class) )
                .collect(Collectors.toList());
        return new PatientsListDTO(patientDTOList);
    }


}
