package com.meli.desafio2.mapper;

import com.meli.desafio2.dto.EnvironmentDTO;
import com.meli.desafio2.dto.EnvironmentSquareDTO;

public class EnvironmentMapper {
    public static EnvironmentSquareDTO DTOToSquareDTO(EnvironmentDTO environment, double squsreMeters){
        return new EnvironmentSquareDTO(environment.getEnvironment_name(), environment.getEnvironment_width(), environment.getEnvironment_length(), squsreMeters);
    }
}
