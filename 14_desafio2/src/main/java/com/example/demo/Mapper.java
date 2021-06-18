package com.example.demo;

import com.example.demo.DTO.*;
import com.example.demo.entities.District;
import com.example.demo.entities.Environment;
import com.example.demo.entities.Property;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.repositories.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

import java.io.FileNotFoundException;
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

    public static List<EnvironmentDTO> toEnvironmentDTO(List<Environment> environments) {
        List<EnvironmentDTO> result = new ArrayList<>();
        for (Environment environmentEntry : environments) {
            EnvironmentDTO environment = new EnvironmentDTO();
            environment.setName(environmentEntry.getName());
            environment.setLength(environmentEntry.getLength());
            environment.setWidth(environmentEntry.getWidth());
            environment.setTotalMeters(environmentEntry.getLength() * environmentEntry.getWidth());
            result.add(environment);
        }
        return result;
    }

    public static Property toProperty(PropertyDTO propertyDTO, District district) {
        Property property = new Property();
        property.setId(propertyDTO.getId());
        property.setName(propertyDTO.getName());
        property.setDistrict(district);
        property.setEnvironments(Mapper.toEnvironment(propertyDTO.getEnvironments()));

        return property;
    }

    public static ResponseBiggerEnvironmentDTO getResponseBiggerEnvironmentDTO(String propertyName, String EnvironmentName, double total) {
        ResponseBiggerEnvironmentDTO response = new ResponseBiggerEnvironmentDTO();
        response.setName(propertyName);
        response.setEnvironmentName(EnvironmentName);
        response.setBiggerEnvironmentMeters(total);

        return response;
    }

    public static ResponsePriceDTO getResponsePriceDTO(Property property, double totalPrice) {
        ResponsePriceDTO response = new ResponsePriceDTO();
        response.setPropertyId(property.getId());
        response.setPropertyName(property.getName());
        response.setPrice(totalPrice);

        return response;
    }

    public static ResponseTotalMetersByEnvironmentDTO getResponseTotalMetersByEnvironmentDTO(Property property, List<EnvironmentDTO> list) {
        ResponseTotalMetersByEnvironmentDTO response = new ResponseTotalMetersByEnvironmentDTO();
        response.setNameProperty(property.getName());
        response.setEnvironments(list);

        return response;
    }

    public static ResponseCalculateTotalMetersDTO getResponseCalculateTotalMetersDTO(Property property, double totalMeters){
        ResponseCalculateTotalMetersDTO response = new ResponseCalculateTotalMetersDTO();
        response.setName(property.getName());
        response.setTotalMeters(totalMeters);

        return response;
    }




}
