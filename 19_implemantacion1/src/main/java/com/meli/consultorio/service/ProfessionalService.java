package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.ProfessionalResponse;
import com.meli.consultorio.model.Professional;
import com.meli.consultorio.repository.IProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService implements IProfessionalService{

    @Autowired
    IProfessionalRepository iProfessionalRepository;
    @Override
    public void saveProfessional(Professional professional) {
        iProfessionalRepository.save(professional);
    }

    @Override
    public ProfessionalResponse getProfessional(Integer id) {
        return ProfessionalResponseMapper.toResponse(iProfessionalRepository.findById(id).get());
    }
}
