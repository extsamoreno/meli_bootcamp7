package com.implementacion.hibernate2.model.service.patients;

import com.implementacion.hibernate2.controller.dto.patients.PatientDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientListDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientsListDTO;
import com.implementacion.hibernate2.controller.dto.patients.request.NewPatientDTO;


public interface IPatientService {
    PatientsListDTO listAllPatientsByDate(String date);

    PatientListDetailsDTO listAllPatientsDetailsByDate(String date);

    void insertNewPatient(NewPatientDTO newPatientDTO);

    PatientDTO getPatientByName(String name );

    PatientsListDTO getAllPatient();
}
