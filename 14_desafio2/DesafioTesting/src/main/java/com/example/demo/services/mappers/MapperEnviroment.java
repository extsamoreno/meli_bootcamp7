package com.example.demo.services.mappers;

import com.example.demo.model.Environment;
import com.example.demo.model.Property;
import com.example.demo.dtos.BiggestEnvironmentDTO;
import com.example.demo.dtos.EnvironmentDTO;
import com.example.demo.dtos.EnvironmentM2DTO;
import com.example.demo.dtos.EnvironmentRequestDTO;


import java.util.ArrayList;
import java.util.List;

public class MapperEnviroment {

    public static List<EnvironmentDTO> toEnvironmentDTO(Property property){
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();


        for(Environment environment :property.getEnvironments()){
            EnvironmentDTO environmentDTO = new EnvironmentDTO();
            double priceEnv = 0;
            double m2 = environment.getEnvironment_length()*environment.getEnvironment_width();
            double priceM2 = property.getDistrict().getDistrict_price();

            priceEnv = m2*priceM2;

            environmentDTO.setEnvironment_name(environment.getEnvironment_name());
            environmentDTO.setSquare_meters(m2);
            environmentDTO.setPrice(priceEnv);

            environmentDTOList.add(environmentDTO);
        }

        return environmentDTOList;
    }

    public static BiggestEnvironmentDTO toBiggestEnvironmentDTO(Environment environment){
        BiggestEnvironmentDTO biggestEnvironmentDTO = new BiggestEnvironmentDTO();

        biggestEnvironmentDTO.setEnvironment_name(environment.getEnvironment_name());
        biggestEnvironmentDTO.setSquare_meters(environment.getEnvironment_length()*environment.getEnvironment_width());

        return  biggestEnvironmentDTO;
    }

    public static List<EnvironmentM2DTO> toM2EnviromentDTO(Property property){

        List<EnvironmentM2DTO> environmentM2DTOList = new ArrayList<>();


        for(Environment environment :property.getEnvironments()){
            EnvironmentM2DTO environmentM2DTO = new EnvironmentM2DTO();
            double m2 = environment.getEnvironment_length()*environment.getEnvironment_width();

            environmentM2DTO.setEnvironment_name(environment.getEnvironment_name());
            environmentM2DTO.setSquare_meters(m2);

            environmentM2DTOList.add(environmentM2DTO);
        }

        return environmentM2DTOList;
    }

    public static List<Environment> toEnvironmentList(List<EnvironmentRequestDTO> environmentRequestDTOList){
        List<Environment> environmentList = new ArrayList<>();

        for(EnvironmentRequestDTO environmentRequestDTO: environmentRequestDTOList){
            Environment environment = new Environment();
            environment.setEnvironment_name(environmentRequestDTO.getEnvironment_name());
            environment.setEnvironment_length(environmentRequestDTO.getEnvironment_length());
            environment.setEnvironment_width(environmentRequestDTO.getEnvironment_width());
            environmentList.add(environment);
        }

        return environmentList;
    }

}
