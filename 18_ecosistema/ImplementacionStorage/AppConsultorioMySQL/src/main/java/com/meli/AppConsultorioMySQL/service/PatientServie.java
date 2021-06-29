package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.PatientEntity;
import com.meli.AppConsultorioMySQL.repositories.IPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServie implements IPtientService {
    IPatientRepository iPatientRepository;

    @Override
    public void createPatient(PatientEntity student) {
        iPatientRepository.save(student);

    }

    @Override
    public void deletePatient(PatientEntity student) {
        iPatientRepository.delete(student);

    }

    @Override
    public List<PatientEntity> findAll() {
        return iPatientRepository.findAll(PageRequest.of(1,50)).getContent();
    }

    @Override
    public Optional<PatientEntity> findById(Long id) {
        return iPatientRepository.findById(id);
    }

    @Override
    public void updateStudent(PatientEntity student) {
        iPatientRepository.save(student);
    }
}

