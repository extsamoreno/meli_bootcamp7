package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Patient;
import com.appconsultorio.appconsultorio.repository.IDentistRepository;
import com.appconsultorio.appconsultorio.repository.IPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService {

    IPatientRepository iPatientRepository;

    @Override
    public void createPatient(Patient patient) { iPatientRepository.save(patient); }

    @Override
    public void updatePatient(Patient patient) {
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
