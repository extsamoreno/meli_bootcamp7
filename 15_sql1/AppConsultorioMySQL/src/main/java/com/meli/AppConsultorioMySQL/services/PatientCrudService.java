package com.meli.AppConsultorioMySQL.services;

import com.meli.AppConsultorioMySQL.repositories.IPatientRepository;
import com.meli.AppConsultorioMySQL.repositories.entities.PatientEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientCrudService implements IPatientCrudService{
//    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public String addOne(PatientEntity patient) {
        patientRepository.save(patient);
        return "patient added successfully";
    }
}
