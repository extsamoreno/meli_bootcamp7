package com.example.demo.services.mappers;

import com.example.demo.Utils;
import com.example.demo.model.Environment;
import com.example.demo.model.Property;
import com.example.demo.dtos.*;

public class MapperProperty {

    public static PropertyM2ResponseDTO toPropertyM2ResponseDTO(Property property){
        PropertyM2ResponseDTO propertyM2ResponseDTO=new PropertyM2ResponseDTO();
        double squareMeters = 0;
        propertyM2ResponseDTO.setProp_name(property.getProp_name());

        for(Environment env: property.getEnvironments()){
                squareMeters+=env.getEnvironment_width()* env.getEnvironment_length();
        }

        propertyM2ResponseDTO.setProp_square_meters(squareMeters);

        return propertyM2ResponseDTO;
    }

    public static PropertyPriceResponseDTO toPropertyPriceResponseDTO(Property property){
        PropertyPriceResponseDTO propertyPriceResponseDTO = new PropertyPriceResponseDTO();
        propertyPriceResponseDTO.setProp_name(property.getProp_name());
        propertyPriceResponseDTO.setEnviroments(MapperEnviroment.toEnvironmentDTO(property));
        propertyPriceResponseDTO.setProp_price(propertyPriceResponseDTO.getEnviroments().stream().mapToDouble(p->p.getPrice()).sum());


        return propertyPriceResponseDTO;
    }

    public static BiggestPropResponseDTO toBiggestPropResponseDTO(Property property){
        BiggestPropResponseDTO biggestPropResponseDTO = new BiggestPropResponseDTO();
        biggestPropResponseDTO.setProp_name(property.getProp_name());
        biggestPropResponseDTO.setBiggestEnvironment(MapperEnviroment.toBiggestEnvironmentDTO(Utils.BiggestEnvironment(property.getEnvironments())));

        return biggestPropResponseDTO;
    }

    public static PropertyM2EnvsResponseDTO toPropertyM2EnvsDTO(Property property){
        PropertyM2EnvsResponseDTO propertyM2EnvsResponseDTO = new PropertyM2EnvsResponseDTO();
        propertyM2EnvsResponseDTO.setProp_name(property.getProp_name());
        propertyM2EnvsResponseDTO.setEnviroments(MapperEnviroment.toM2EnviromentDTO(property));

        return propertyM2EnvsResponseDTO;
    }

    public static Property toProperty(PropertyRequestDTO propertyRequestDTO){
        Property property= new Property();
        property.setProp_name(propertyRequestDTO.getProp_name());
        property.setDistrict(MapperDistrict.toDistrict(propertyRequestDTO.getDistrict()));
        property.setEnvironments(MapperEnviroment.toEnvironmentList(propertyRequestDTO.getEnvironment()));

        return property;
    }
}
