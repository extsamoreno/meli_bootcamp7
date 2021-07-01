package com.example.muelitas.service;

import com.example.muelitas.dto.ProfessionalDTO;
import com.example.muelitas.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProfessionalService {
    ResponseDTO createProfessional(ProfessionalDTO newProfessional);
    ProfessionalDTO readProfessional(Long idProfessional);
    ResponseDTO updateProfessional(ProfessionalDTO updatedProfessional);
    ResponseDTO deleteProfessional(Long idProfessional);
}
