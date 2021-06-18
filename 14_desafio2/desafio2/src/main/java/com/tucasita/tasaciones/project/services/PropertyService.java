package com.tucasita.tasaciones.project.services;

import com.tucasita.tasaciones.project.exceptions.PropertyAlreadyExistsException;
import com.tucasita.tasaciones.project.exceptions.PropertyDistrictNameNotFoundException;
import com.tucasita.tasaciones.project.exceptions.PropertyNameNotFoundException;
import com.tucasita.tasaciones.project.models.District;
import com.tucasita.tasaciones.project.models.Environment;
import com.tucasita.tasaciones.project.models.Property;
import com.tucasita.tasaciones.project.repository.IPropertyRepository;
import com.tucasita.tasaciones.project.services.Dto.PropertyDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyEnvironmentDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyTotalSquareMetersDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyValueDto;
import com.tucasita.tasaciones.project.services.mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
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
            totalSquareMeters+= e.getEnvironment_length() * e.getEnvironment_width();
        }
        return totalSquareMeters;
    }

    @Override
    public PropertyValueDto getPropertyValue(String propertyName) throws PropertyNameNotFoundException, PropertyDistrictNameNotFoundException {
        Property property = iPropertyRepository.findPropertyByName(propertyName);
        double totalSquareMeters = getTotalMeters(property);
        District district = iPropertyRepository.findDistrictByName(property.getProp_district_name());
        double value = totalSquareMeters * district.getDistrict_price();
        return new PropertyValueDto(value);
    }

    @Override
    public PropertyEnvironmentDto getBiggestEnvironment(String propertyName) throws PropertyNameNotFoundException {
        ArrayList<Environment> environmentArrayList = iPropertyRepository.findPropertyByName(propertyName).getProp_environment();
        PropertyEnvironmentDto responseDto = new PropertyEnvironmentDto("Null",0.0);

        for(Environment e : environmentArrayList){
            double environmentSize = e.getEnvironment_width() * e.getEnvironment_length();
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
                    e.getEnvironment_length() * e.getEnvironment_width()));
        }

        return environmentSizesList;
    }

    @Override
    public void addNewProperty(PropertyDto propertyDto) throws PropertyAlreadyExistsException, PropertyDistrictNameNotFoundException {
        Property property = mapper.propertyDtoToProperty(propertyDto);
        iPropertyRepository.saveProperty(property);
    }

}
