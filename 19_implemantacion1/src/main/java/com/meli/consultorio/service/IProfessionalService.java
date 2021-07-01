package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.ProfessionalResponse;
import com.meli.consultorio.model.Professional;

public interface IProfessionalService {
    void saveProfessional(Professional professional);
    ProfessionalResponse getProfessional(Integer id);
}
