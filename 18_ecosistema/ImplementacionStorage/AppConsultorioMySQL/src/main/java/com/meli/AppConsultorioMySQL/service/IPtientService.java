package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.PatientEntity;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IPtientService {

    public void createPatient(PatientEntity student);

    public void deletePatient(PatientEntity student);

    List<PatientEntity> findAll();

    Optional<PatientEntity> findById(Long id);

    void updateStudent(PatientEntity student);
}
