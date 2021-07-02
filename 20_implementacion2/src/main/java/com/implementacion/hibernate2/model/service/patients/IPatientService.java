package com.implementacion.hibernate2.model.service.patients;

import com.implementacion.hibernate2.controller.dto.patients.PatientListDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientsListDTO;


public interface IPatientService {
    PatientsListDTO listAllPatientsByDate(String date);

    PatientListDetailsDTO listAllPatientsDetailsByDate(String date);
}
