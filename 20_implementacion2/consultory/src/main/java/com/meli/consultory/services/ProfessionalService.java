package com.meli.consultory.services;

import com.meli.consultory.models.Patient;
import com.meli.consultory.models.Professional;
import com.meli.consultory.repositories.ProfessionalRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessionalService {

    public void createProfessional(Professional professional);

    public void deleteProfessional(Professional professional);

    public List<Professional> findAll();

    public Optional<Professional> findById(Long id);

    public void updateProfessional(Professional professional);
}
