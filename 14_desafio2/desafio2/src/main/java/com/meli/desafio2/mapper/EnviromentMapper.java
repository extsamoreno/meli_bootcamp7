package com.meli.desafio2.mapper;

import com.meli.desafio2.dto.EnviromentDTO;
import com.meli.desafio2.dto.EnviromentSquareDTO;

public class EnviromentMapper {
    public static EnviromentSquareDTO DTOToSquareDTO(EnviromentDTO enviroment,double squsreMeters){
        return new EnviromentSquareDTO(enviroment.getEnviroment_name(), enviroment.getEnviroment_width(), enviroment.getEnviroment_length(), squsreMeters);
    }
}
