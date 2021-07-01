package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.ProfessionalResponse;
import com.meli.consultorio.model.Professional;

public class ProfessionalResponseMapper {
    public static ProfessionalResponse toResponse(Professional professional){
        return new ProfessionalResponse(professional.getPro_id(),professional.getPro_name(),professional.getPro_last_name());
    }
}
