package com.example.demo.services.mappers;

import com.example.demo.model.Environment;
import com.example.demo.dtos.BiggestEnvironmentDTO;
import com.example.demo.dtos.EnvironmentM2DTO;
import com.example.demo.dtos.EnvironmentRequestDTO;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class MapperEnviroment {

    public static List<EnvironmentRequestDTO> toEnvironmentDTO(List<Environment> environmentList){
        List<EnvironmentRequestDTO> environmentDTOList = new ArrayList<>();


        for(Environment environment :environmentList){
            EnvironmentRequestDTO environmentDTO = new EnvironmentRequestDTO();

            environmentDTO.setEnvironment_name(environment.getEnvironment_name());
            environmentDTO.setEnvironment_width(environment.getEnvironment_width());
            environmentDTO.setEnvironment_length(environment.getEnvironment_length());
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

    public static EnvironmentM2DTO toM2EnviromentDTO(Environment environment){

            EnvironmentM2DTO environmentM2DTO = new EnvironmentM2DTO();
            double m2 = environment.getEnvironment_length()*environment.getEnvironment_width();

            environmentM2DTO.setEnvironment_name(environment.getEnvironment_name());
            environmentM2DTO.setSquare_meters(m2);

        return environmentM2DTO;
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
