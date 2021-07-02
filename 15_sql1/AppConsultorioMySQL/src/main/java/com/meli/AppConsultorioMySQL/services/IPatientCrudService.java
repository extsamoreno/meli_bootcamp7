package com.meli.AppConsultorioMySQL.services;

import com.meli.AppConsultorioMySQL.repositories.entities.PatientEntity;

public interface IPatientCrudService {
    String addOne(PatientEntity patient);
}
