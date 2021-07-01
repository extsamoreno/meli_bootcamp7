package com.meli.consultorio.services.patient;

import com.meli.consultorio.exceptions.PatientNotFoundException;
import com.meli.consultorio.models.Patient;
import com.meli.consultorio.models.dtos.PatientDTO;
import com.meli.consultorio.repositories.IPatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService {

    IPatientRepository iPatientRepository;
    ModelMapper mapper;

    @Override
    public void createPatient(PatientDTO patientDTO) {
        iPatientRepository.save(mapper.map(patientDTO, Patient.class));
    }

    @Override
    public void deletePatientById(Long id) {
        if(iPatientRepository.findById(id).isEmpty()) {
            throw new PatientNotFoundException(id);
        }

        iPatientRepository.deleteById(id);
    }

    @Override
    public void updatePatient(PatientDTO patientDTO) {
        if(iPatientRepository.findById(patientDTO.getId()).isEmpty()) {
            throw new PatientNotFoundException(patientDTO.getId());
        }

        iPatientRepository.save(mapper.map(patientDTO, Patient.class));
    }

    @Override
    public Set<PatientDTO> findAllPatient() {
        List<Patient> patients = iPatientRepository.findAll();
        return patients.stream().map(patient -> mapper.map(patient, PatientDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public PatientDTO findPatientById(Long id) {
        Patient patient = iPatientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
        return mapper.map(patient,PatientDTO.class);
    }
}
