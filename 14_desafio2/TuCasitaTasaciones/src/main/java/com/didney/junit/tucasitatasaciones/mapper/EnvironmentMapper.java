package com.didney.junit.tucasitatasaciones.mapper;

import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.model.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnvironmentMapper {

    public List<EnvironmentDTO> environmentToListEnvironmentDTO(List<Environment> environmentList) {
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();
        for (Environment obj : environmentList) {
            environmentDTOList.add(new EnvironmentDTO(obj.getEnvironmentName(), obj.getEnvironmentWidth(), obj.getEnvironmentLength()));
        }
        return environmentDTOList;
    }

    public List<Environment> environmentDTOToListEnvironment(List<EnvironmentDTO> environmentDTOList) {
        List<Environment> environmentList = new ArrayList<>();
        for (EnvironmentDTO obj : environmentDTOList) {
            environmentList.add(new Environment(0, obj.getEnvironmentName(), obj.getEnvironmentWidth(), obj.getEnvironmentLength()));
        }
        return environmentList;
    }

    public Environment environmentDTOToEnvironment(EnvironmentDTO environmentDTO) {
        return new Environment(0, environmentDTO.getEnvironmentName(), environmentDTO.getEnvironmentWidth(), environmentDTO.getEnvironmentLength());
    }

    public EnvironmentDTO environmentToEnvironmentDTO(Environment environment) {
        return new EnvironmentDTO(environment.getEnvironmentName(), environment.getEnvironmentWidth(), environment.getEnvironmentLength());
    }
}
