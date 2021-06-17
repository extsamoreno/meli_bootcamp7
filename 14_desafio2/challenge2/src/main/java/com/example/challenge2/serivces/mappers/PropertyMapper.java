package com.example.challenge2.serivces.mappers;

import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.models.Property;

public class PropertyMapper {
    public static Property propertyDTOToProperty(PropertyDTO propertyDTO){
       Property property = new Property();
        return property;
    }

    public static PropertyDTO propertyToPropertyDTO(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();
        return propertyDTO;
    }
}
