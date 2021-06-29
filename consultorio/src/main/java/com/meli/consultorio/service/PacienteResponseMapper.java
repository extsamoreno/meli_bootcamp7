package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.PacienteResponse;
import com.meli.consultorio.model.Paciente;

public class PacienteResponseMapper {
    public static PacienteResponse toResponse(Paciente paciente){
        return new PacienteResponse(paciente.getPac_id(),paciente.getPac_obra_social());
    }
}
