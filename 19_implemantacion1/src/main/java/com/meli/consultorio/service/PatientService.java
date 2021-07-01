package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.PatientResponse;
import com.meli.consultorio.model.Patient;
import com.meli.consultorio.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService {
    @Autowired
    IPatientRepository iPatientRepository;
    @Override
    public PatientResponse getPatient(Integer id){
        Patient item = iPatientRepository.findById(id).get();
        return PatientResponseMapper.toResponse(item);
    }
    @Override
    public void savePatient(Patient patient){
        iPatientRepository.save(patient);
    }

}
