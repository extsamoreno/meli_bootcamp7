package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.PatientDTO;
import com.appconsultorio.appconsultorio.model.Patient;
import com.appconsultorio.appconsultorio.repository.IPatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService {

    ModelMapper mapper;
    IPatientRepository iPatientRepository;


    @Override
    public void createPatient(PatientDTO patientDTO) {
        Patient patient = mapper.map(patientDTO, Patient.class);
        iPatientRepository.save(patient);
    }

    @Override
    public void updatePatient(PatientDTO patientDTO) {
        Patient patient = mapper.map(patientDTO, Patient.class);
        iPatientRepository.save(patient);
    }

    @Override
    public void removePatient(int id) {
        iPatientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getPatient() {
        return iPatientRepository.findAll();
    }
}
