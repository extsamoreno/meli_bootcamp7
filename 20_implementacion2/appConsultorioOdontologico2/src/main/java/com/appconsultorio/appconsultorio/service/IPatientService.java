package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.PatientDTO;
import com.appconsultorio.appconsultorio.model.Patient;

import java.time.LocalDateTime;
import java.util.List;

public interface IPatientService {
    public void createPatient(PatientDTO patientDTO);
    public void updatePatient(PatientDTO patientDTO);
    public void removePatient(int id);
    public List<Patient> getPatient() ;
    List<Patient> getPatientByDateForDentists(LocalDateTime dt);
}
