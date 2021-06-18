package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.request.EnvironmentDTO;
import com.meli.desafio2.web.model.Environment;

public class EnvironmentMapper {
    public static Environment toModel(EnvironmentDTO environmentDTO){
        return new Environment(environmentDTO.getEnvironment_name(), environmentDTO.getEnvironment_width(), environmentDTO.getEnvironment_length());
    }

    public static EnvironmentDTO toDTO(Environment environment){
        return new EnvironmentDTO(environment.getEnvironment_name(), environment.getEnvironment_width(), environment.getEnvironment_length());
    }
}
