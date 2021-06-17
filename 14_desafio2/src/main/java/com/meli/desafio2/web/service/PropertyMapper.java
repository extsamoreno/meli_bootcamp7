package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.EnvironmentDTO;
import com.meli.desafio2.web.dto.PropertyDTO;
import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyMapper {
    public static PropertyDTO toDTO(Property property){
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();
        for(Environment environment: property.getEnvironments()){
            environmentDTOList.add(EnvironmentMapper.toDTO(environment));
        }
        return new PropertyDTO(property.getProp_name(),property.getDistrict(),environmentDTOList);
    }
    public static Property toModel(PropertyDTO propertyDTO){
        List<Environment> environments = new ArrayList<>();
        for(EnvironmentDTO environmentDTO: propertyDTO.getEnvironments()){
            environments.add(EnvironmentMapper.toModel(environmentDTO));
        }

        return new Property(propertyDTO.getProp_name(),propertyDTO.getDistrict(),environments);
    }
}
