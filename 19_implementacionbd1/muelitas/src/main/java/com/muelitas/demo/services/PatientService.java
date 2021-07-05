package com.muelitas.demo.services;

import com.muelitas.demo.dtos.PatientDTO;
import com.muelitas.demo.exceptions.BadRequestException;
import com.muelitas.demo.models.Patient;
import com.muelitas.demo.repositories.IPatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService{

    private IPatientRepository patientRepository;
    private ModelMapper mapper;

    @Override
    public void savePatient(PatientDTO patient) {
        Patient patientModel = mapper.map(patient, Patient.class);
        patientRepository.save(patientModel);
    }

    @Override
    public PatientDTO findPatientById(Long id) throws BadRequestException {
        PatientDTO patient = validatePatient(id);
        return patient;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(p -> mapper.map(p, PatientDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patient) throws BadRequestException {
        validatePatient(patient.getId());
        Patient patientToUpdate = mapper.map(patient, Patient.class);
        PatientDTO patientUpdated = mapper.map(patientRepository.save(patientToUpdate), PatientDTO.class);
        return patientUpdated;
    }

    @Override
    public void deletePatientById(Long id) throws BadRequestException {
        validatePatient(id);
        patientRepository.deletePatientBy(id);
    }

    private PatientDTO validatePatient(Long id) throws BadRequestException {
        if(id <= 0)
            throw new BadRequestException("El id del paciente debe ser mayor a 0");

        Optional<Patient> patient = patientRepository.findPatientByDniWithoutLowDate(id);

        if(!patient.isPresent())
            throw new BadRequestException("El paciente con el id ingresado no existe.");

        PatientDTO patientDTO = mapper.map(patient.get(), PatientDTO.class);

        return patientDTO;
    }
}
