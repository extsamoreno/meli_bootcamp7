package com.example.challenge_2.service;

import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.exception.PropertyException;
import com.example.challenge_2.exception.PropertyExceptionNotValid;
import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.repository.IPropertyRepository;
import com.example.challenge_2.service.dto.*;
import com.example.challenge_2.service.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    PropertyMapper propertyMapper;

    @Autowired
    IDistrictService districtService;

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    IEnvironmentService environmentService;

    @Override
    public NewIdDTO createProperty(PropertyDTO property) throws DistrictNotFoundException {
        Property propertyMapped = propertyMapper.toModel(property);
        isValidProperty(propertyMapped);
        propertyRepository.add(propertyMapped);
        return new NewIdDTO(propertyMapped.getId());
    }

    @Override
    public SquareMetersDTO getSquareMeters(int propertyId) throws PropertyNotFoundException {
        Property property = propertyRepository.getById(propertyId);
        return new SquareMetersDTO(calculateSquareMeters(property));
    }

    @Override
    public PropertyPriceDTO getPropertyPrice(int propertyId) throws PropertyNotFoundException {
        Property property = propertyRepository.getById(propertyId);
        return new PropertyPriceDTO(calculatePropertyPrice(property));
    }

    @Override
    public EnvironmentDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException {
        Property property = propertyRepository.getById(propertyId);
        return environmentService.getBiggestEnviroment(property.getEnvironments());
    }

    @Override
    public List<EnvironmentSquareMetersDTO> getSquareMetersEachEnvironment(int propertyId) throws PropertyNotFoundException {
        Property property = propertyRepository.getById(propertyId);
        return environmentService.getSquareMetersEachEnvironment(property.getEnvironments());
    }

    private double calculatePropertyPrice(Property property) {
        return calculateSquareMeters(property) * property.getDistrict().getPrice();
    }

    private double calculateSquareMeters(Property property) {
        return property.getEnvironments().stream().mapToDouble(x -> environmentService.calculateSquareMeters(x)).sum();
    }

    private void isValidProperty(Property property) throws DistrictNotFoundException {

        validateDistrict(property);
        setDistrictToProperty(property);

        //validatePropertyFields(property);
    }

    private void validatePropertyFields(Property property) throws PropertyException {
        try {
            Utils.validateStringEmpty(property.getName(), "name");
            Utils.startWithUpperCase(property.getName(), "name");
            Utils.maximunLength(property.getName(), "name", 30);
        } catch (Exception e) {
            throw new PropertyExceptionNotValid(e.getMessage());
        }
    }

    private void setDistrictToProperty(Property property) throws DistrictNotFoundException {
        property.setDistrict(districtService.getDistrictByName(property.getDistrict().getName()));
    }

    private void validateDistrict(Property property) throws DistrictNotFoundException {
        districtService.getDistrictByName(property.getDistrict().getName()); //Throws excpetion if not exists, for solidity, set in another function
    }
}
