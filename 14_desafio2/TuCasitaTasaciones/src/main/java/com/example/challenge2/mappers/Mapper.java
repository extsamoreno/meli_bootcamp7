package com.example.challenge2.mappers;

import com.example.challenge2.dtos.EnvironmentDTO;
import com.example.challenge2.models.Environment;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<Environment> toEnvironment(List<EnvironmentDTO> environments) {
        List<Environment> result = new ArrayList<>();
        for (EnvironmentDTO environmentDTO : environments) {
            Environment environment = new Environment();
            environment.setName(environmentDTO.getName());
            environment.setLength(environmentDTO.getLength());
            environment.setWidth(environmentDTO.getWidth());

            result.add(environment);
        }
        return result;
    }
}