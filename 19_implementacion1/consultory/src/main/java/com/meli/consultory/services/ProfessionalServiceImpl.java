package com.meli.consultory.services;

import com.meli.consultory.models.Patient;
import com.meli.consultory.repositories.ProfessionalRepository;

import java.util.List;
import java.util.Optional;

public class ProfessionalServiceImpl implements ProfessionalService{
    ProfessionalRepository professionalRepository;

    public void createPatient(Patient professional) {
        professionalRepository.save(professional);
    }

    public void deletePatient(Patient professional) {
        professionalRepository.delete(professional);
    }

    public List<Patient> findAll() {
        return professionalRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return professionalRepository.findById(id);
    }

    public void updatePatient(Patient professional) {
        professionalRepository.save(professional);
    }
}
