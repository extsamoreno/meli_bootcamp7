package com.example.challenge2.serivces.mappers;

import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Property;

public class PropertyMapper {
    public static Property propertyDTOToProperty(PropertyDTO propertyDTO, District district){
        Property property = new Property(propertyDTO.getName(), district, propertyDTO.getEnvironmentList());
        return property;
    }

    public static PropertyDTO propertyToPropertyDTO(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();
        return propertyDTO;
    }
}
