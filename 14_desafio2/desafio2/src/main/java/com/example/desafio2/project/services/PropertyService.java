package com.example.desafio2.project.services;

import com.example.desafio2.project.exceptions.PropertyAlreadyExistsException;
import com.example.desafio2.project.exceptions.PropertyDistrictNameNotFoundException;
import com.example.desafio2.project.exceptions.PropertyNameNotFoundException;
import com.example.desafio2.project.models.District;
import com.example.desafio2.project.models.Environment;
import com.example.desafio2.project.models.Property;
import com.example.desafio2.project.repository.IPropertyRepository;
import com.example.desafio2.project.services.Dto.PropertyDto;
import com.example.desafio2.project.services.Dto.PropertyEnvironmentDto;
import com.example.desafio2.project.services.Dto.PropertyTotalSquareMetersDto;
import com.example.desafio2.project.services.Dto.PropertyValueDto;
import com.example.desafio2.project.services.mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public PropertyTotalSquareMetersDto getTotalSquareMeters(String propertyName) throws PropertyNameNotFoundException {
        Property property = iPropertyRepository.findPropertyByName(propertyName);
        double totalSquareMeters = getTotalMeters(property);

        return new PropertyTotalSquareMetersDto(totalSquareMeters);
    }

    public double getTotalMeters(Property property) {
        double totalSquareMeters = 0;
        for(Environment e : property.getProp_environment()){
            totalSquareMeters+= e.getEnvironment_lenght() * e.getEnvironment_widht();
        }
        return totalSquareMeters;
    }

    @Override
    public PropertyValueDto getPropertyValue(String propertyName) throws PropertyNameNotFoundException, PropertyDistrictNameNotFoundException {
        Property property = iPropertyRepository.findPropertyByName(propertyName);
        double totalSquareMeters = getTotalMeters(property);
        District district = iPropertyRepository.findDistrictByName(property.getProp_district_name());

        return new PropertyValueDto(totalSquareMeters * district.getDistrict_price());
    }

    @Override
    public PropertyEnvironmentDto getBiggestEnvironment(String propertyName) throws PropertyNameNotFoundException {
        ArrayList<Environment> environmentArrayList = iPropertyRepository.findPropertyByName(propertyName).getProp_environment();
        PropertyEnvironmentDto responseDto = new PropertyEnvironmentDto("Null",0.0);

        for(Environment e : environmentArrayList){
            double environmentSize = e.getEnvironment_widht() * e.getEnvironment_lenght();
            if (environmentSize > responseDto.getEnvironment_size()){
                responseDto.setEnvironment_name(e.getEnvironment_name());
                responseDto.setEnvironment_size(environmentSize);
            }
        }
        return responseDto;
    }

    @Override
    public ArrayList<PropertyEnvironmentDto> getEnvironmentSizesList(String propertyName) throws PropertyNameNotFoundException {
        ArrayList<Environment> environmentArrayList = iPropertyRepository.findPropertyByName(propertyName).getProp_environment();
        ArrayList<PropertyEnvironmentDto> environmentSizesList = new ArrayList<>();

        for(Environment e : environmentArrayList){
            environmentSizesList.add(new PropertyEnvironmentDto(e.getEnvironment_name(),
                    e.getEnvironment_lenght() * e.getEnvironment_widht()));
        }

        return environmentSizesList;
    }

    @Override
    public void addNewProperty(PropertyDto propertyDto) throws PropertyAlreadyExistsException {
        Property property = mapper.dtoToProperty(propertyDto);
        iPropertyRepository.saveProperty(property);
    }

}
