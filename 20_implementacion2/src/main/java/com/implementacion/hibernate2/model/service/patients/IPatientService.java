package com.implementacion.hibernate2.model.service.patients;

import com.implementacion.hibernate2.controller.dto.PatientsListDTO;

import java.util.Date;


public interface IPatientService {
    PatientsListDTO listAllPatientsByDate(String date);
}
