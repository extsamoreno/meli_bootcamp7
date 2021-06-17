package com.meli.TuCasitaTasaciones.mapper;

import com.meli.TuCasitaTasaciones.model.EnvironmentDTO;
import com.meli.TuCasitaTasaciones.model.EnvironmentAreaResponseDTO;

public class EnvironmentMapper {
    public static EnvironmentAreaResponseDTO ToEnvironmentAreaResponseDTO(EnvironmentDTO e){
        EnvironmentAreaResponseDTO eResponse = new EnvironmentAreaResponseDTO();
        eResponse.setEnvironmentName(e.getEnvironmentName());
        eResponse.setLength(e.getLength());
        eResponse.setWidth(e.getWidth());
        eResponse.setArea(e.getLength()*e.getWidth());

        return eResponse;
    }

    public static EnvironmentDTO ToEnvironmentDTO(EnvironmentAreaResponseDTO e){
        EnvironmentDTO eResponse = new EnvironmentDTO();
        eResponse.setEnvironmentName(e.getEnvironmentName());
        eResponse.setLength(e.getLength());
        eResponse.setWidth(e.getWidth());

        return eResponse;
    }
}
