package com.meli.muelitas.service;

import com.meli.muelitas.dto.PatientDTO;
import com.meli.muelitas.exception.PatientIdNotExistsException;
import com.meli.muelitas.exception.PatientNitNotExistsException;
import com.meli.muelitas.mapper.MapStructConverter;
import com.meli.muelitas.model.Patient;
import com.meli.muelitas.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    IPatientRepository patientRepository;

    @Override
    public void createPatient(PatientDTO patientDTO) {
        patientRepository.save(MapStructConverter.MAPPER.patientDTOToPatient(patientDTO));
    }

    @Override
    public PatientDTO getPatientByNit(String nit) {
        Patient patient = patientRepository.findByNit(nit).orElseThrow(() -> new PatientNitNotExistsException(nit));
        return MapStructConverter.MAPPER.patientToPatientDTO(patient);
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientIdNotExistsException(id));
        return MapStructConverter.MAPPER.patientToPatientDTO(patient);
    }

    @Override
    public PatientDTO getPatientByName(String name) {
        return MapStructConverter.MAPPER.patientToPatientDTO(patientRepository.findByName(name));
    }

    @Override
    public List<PatientDTO> getPatientList() {
        return MapStructConverter.MAPPER.patientListToPatientDTOList(patientRepository.findAll());
    }
}
