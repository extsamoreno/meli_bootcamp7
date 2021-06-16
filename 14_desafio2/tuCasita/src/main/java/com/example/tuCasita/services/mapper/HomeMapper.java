package com.example.tuCasita.services.mapper;

import com.example.tuCasita.dtos.EnviromentDTO;
import com.example.tuCasita.dtos.HomeDTO;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;


public class HomeMapper {

    public static EnviromentDTO toDTO (Enviroment enviroment){
        return new EnviromentDTO(enviroment.getName(), enviroment.getLength()* enviroment.getWidth());
    }

    public static Home homeDTOtoModel (HomeDTO homeDTO){
        return new Home(homeDTO.getId(), homeDTO.getName(), homeDTO.getDistrict(), homeDTO.getEnviromentList());
    }
}
