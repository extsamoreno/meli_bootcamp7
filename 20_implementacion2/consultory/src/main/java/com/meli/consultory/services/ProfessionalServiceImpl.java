package com.meli.consultory.services;

import com.meli.consultory.models.Professional;
import com.meli.consultory.repositories.ProfessionalRepository;

import java.util.List;
import java.util.Optional;

public class ProfessionalServiceImpl implements ProfessionalService{

    ProfessionalRepository professionalRepository;

    public void createProfessional(Professional professional) {
        professionalRepository.save(professional);
    }

    public void deleteProfessional(Professional professional) {
        professionalRepository.delete(professional);
    }

    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }

    public Optional<Professional> findById(Long id) {
        return professionalRepository.findById(id);
    }

    public void updateProfessional(Professional professional) {
        professionalRepository.save(professional);
    }
}
