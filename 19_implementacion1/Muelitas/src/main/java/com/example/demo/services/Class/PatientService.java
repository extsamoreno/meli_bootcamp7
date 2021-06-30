package com.example.demo.services.Class;

import com.example.demo.model.Patient;
import com.example.demo.repositories.IPatientRepository;
import com.example.demo.services.Interface.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@AllArgsConstructor
public class PatientService implements IPatientService {

    IPatientRepository iPatientRepository;


    @Override
    public void createPatient(Patient patient) {
        iPatientRepository.save(patient);
    }

    @Override
    public void deleteStudent(Patient patient) {iPatientRepository.delete(patient);}

    @Override
//    public List<Patient> findAll() {
//        return iPatientRepository.findAll(PageRequest.of(1,50)).getContent();
//    }

    public List<Patient> findAll() { return iPatientRepository.findAll(); }

    @Override
    public Optional<Patient> findById(Integer id) {
        return iPatientRepository.findById(id);
    }

    @Override
    public void updateStudent(Patient patient) {
        iPatientRepository.save(patient);
    }
}
