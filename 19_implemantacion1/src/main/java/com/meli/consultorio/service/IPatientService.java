package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.PatientResponse;
import com.meli.consultorio.model.Patient;

public interface IPatientService {
    public void savePatient(Patient patient);
    public PatientResponse getPatient(Integer id);
}
