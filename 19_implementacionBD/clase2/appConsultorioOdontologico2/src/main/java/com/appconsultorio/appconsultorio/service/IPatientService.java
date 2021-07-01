package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Patient;

import java.util.List;

public interface IPatientService {
    public void createPatient(Patient patient);
    public void updatePatient(Patient patient);
    public void removePatient(int id);
    public List<Patient> getPatient() ;
}
