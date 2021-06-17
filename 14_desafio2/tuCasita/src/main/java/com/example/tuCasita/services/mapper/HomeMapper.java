package com.example.tuCasita.services.mapper;

import com.example.tuCasita.dtos.DistrictDTO;
import com.example.tuCasita.dtos.EnviromentAreasDTO;
import com.example.tuCasita.dtos.EnviromentDTO;
import com.example.tuCasita.dtos.HomeDTO;
import com.example.tuCasita.models.District;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;

import java.util.ArrayList;
import java.util.List;


public class HomeMapper {

    public static EnviromentDTO toDTO (Enviroment enviroment){
        return new EnviromentDTO(enviroment.getId(), enviroment.getName(), enviroment.getWidth(), enviroment.getLength());
    }

    public static EnviromentAreasDTO toAreasDTO (Enviroment enviroment){
        return new EnviromentAreasDTO(enviroment.getName(), enviroment.getWidth() * enviroment.getLength());
    }

    public static Enviroment toModel (EnviromentDTO enviromentDTO){
        return new Enviroment(enviromentDTO.getId(), enviromentDTO.getName(), enviromentDTO.getWidth(), enviromentDTO.getLength());
    }

    public static Home homeDTOtoModel (HomeDTO homeDTO, District district){
        List<EnviromentDTO> enviromentDTOList = homeDTO.getEnviromentList();
        List<Enviroment> enviromentList = new ArrayList<>();

        for (int i = 0; i < enviromentDTOList.size(); i++) {
            enviromentList.add(toModel(enviromentDTOList.get(i)));
        }

        return new Home(homeDTO.getId(), homeDTO.getName(), district, enviromentList);
    }

    public static District districtDTOToModel(DistrictDTO districtDTO){
        return new District(districtDTO.getId() ,districtDTO.getName(),districtDTO.getPrice());
    }
}
