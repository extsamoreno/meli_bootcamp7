package com.example.demo.services.mappers;

import com.example.demo.model.Property;
import com.example.demo.dtos.*;
import org.springframework.stereotype.Component;

@Component
public class MapperProperty {

    public  PropertyM2ResponseDTO toPropertyM2ResponseDTO(Property property){
        PropertyM2ResponseDTO propertyM2ResponseDTO = new PropertyM2ResponseDTO();
        propertyM2ResponseDTO.setProp_name(property.getProp_name());
        return propertyM2ResponseDTO;
    }

    public PropertyPriceResponseDTO toPropertyPriceResponseDTO(Property property){
        PropertyPriceResponseDTO propertyPriceResponseDTO = new PropertyPriceResponseDTO();
        propertyPriceResponseDTO.setProp_name(property.getProp_name());

        return propertyPriceResponseDTO;
    }

    public  BiggestPropResponseDTO toBiggestPropResponseDTO(Property property){
        BiggestPropResponseDTO biggestPropResponseDTO = new BiggestPropResponseDTO();
        biggestPropResponseDTO.setProp_name(property.getProp_name());

        return biggestPropResponseDTO;
    }

    public  PropertyM2EnvsResponseDTO toPropertyM2EnvsDTO(Property property){
        PropertyM2EnvsResponseDTO propertyM2EnvsResponseDTO = new PropertyM2EnvsResponseDTO();
        propertyM2EnvsResponseDTO.setProp_name(property.getProp_name());

        return propertyM2EnvsResponseDTO;
    }

    public  Property toProperty(PropertyRequestDTO propertyRequestDTO){
        Property property= new Property();
        property.setProp_name(propertyRequestDTO.getProp_name());
        property.setDistrict(MapperDistrict.toDistrict(propertyRequestDTO.getDistrict()));
        property.setEnvironments(MapperEnviroment.toEnvironmentList(propertyRequestDTO.getEnvironment()));

        return property;
    }

    public  PropertyRequestDTO toPropertyDTO(Property property){
        PropertyRequestDTO propertyDTO = new PropertyRequestDTO();
        propertyDTO.setProp_name(property.getProp_name());
        propertyDTO.setDistrict(MapperDistrict.toDistrictDTO(property.getDistrict()));
        propertyDTO.setEnvironment(MapperEnviroment.toEnvironmentDTO(property.getEnvironments()));
        return propertyDTO;
    }

}
