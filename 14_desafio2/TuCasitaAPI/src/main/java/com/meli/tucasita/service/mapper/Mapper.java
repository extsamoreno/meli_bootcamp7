package com.meli.tucasita.service.mapper;

import com.meli.tucasita.model.District;
import com.meli.tucasita.model.Environment;
import com.meli.tucasita.model.Property;
import com.meli.tucasita.service.dto.EnvironmentResponseDTO;
import com.meli.tucasita.service.dto.PropertyDTORequest;
import com.meli.tucasita.service.dto.PropertyWithM2DTO;

public class Mapper {

    public static PropertyWithM2DTO toPropertyWithM2(Property property, double m2){
        PropertyWithM2DTO p= new PropertyWithM2DTO();
        p.setName(property.getName());
        p.setTotal_m2(m2);
        return p;
    }

    public static Property toProperty(PropertyDTORequest property, District district){
        Property p= new Property();
        p.setName(property.getName());
        p.setDistrict(district);
        p.setEnvironments(property.getEnvironments());
        return p;
    }

    public static EnvironmentResponseDTO toEnvResponseDTO(Environment env){
        EnvironmentResponseDTO response= new EnvironmentResponseDTO();
        response.setName(env.getName());
        response.setTotalM2(env.getLength()* env.getWidth()*1.0);
        return response;
    }
}
