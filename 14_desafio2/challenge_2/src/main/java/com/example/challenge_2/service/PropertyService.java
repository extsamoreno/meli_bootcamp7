package com.example.challenge_2.service;

import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.models.Environment;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.repository.IDistrictRepository;
import com.example.challenge_2.repository.IPropertyRepository;
import com.example.challenge_2.service.dto.*;
import com.example.challenge_2.service.mapper.EnviromentMapper;
import com.example.challenge_2.service.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    IDistrictRepository districtRepository;

    @Override
    public NewIdDTO createProperty(PropertyDTO property) throws DistrictNotFoundException {
        Property propertyMapped = PropertyMapper.toModel(property);
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
        return getBiggestEnviroment(property.getEnvironments());
    }

    @Override
    public List<EnvironmentSquareMetersDTO> getSquareMetersEachEnvironment(int propertyId) throws PropertyNotFoundException {
        Property property = propertyRepository.getById(propertyId);
        return getSquareMetersEachEnvironment(property.getEnvironments());
    }

    private double calculatePropertyPrice(Property property) {
        return calculateSquareMeters(property) * property.getDistrict().getPrice();
    }

    private double calculateSquareMeters(Property property) {
        return property.getEnvironments().stream().mapToDouble(this::calculateSquareMeters).sum();
    }

    private void isValidProperty(Property property) throws DistrictNotFoundException {

        validateDistrict(property);
        setDistrictToProperty(property);

        //validatePropertyFields(property);
    }

    private void setDistrictToProperty(Property property) throws DistrictNotFoundException {
        property.setDistrict(districtRepository.getByName(property.getDistrict().getName()));
    }

    private void validateDistrict(Property property) throws DistrictNotFoundException {
        districtRepository.getByName(property.getDistrict().getName()); //Throws excpetion if not exists, for solidity, set in another function
    }

    private double calculateSquareMeters(Environment enviroment) {
        return enviroment.getLength() * enviroment.getWidth();
    }

    private EnvironmentDTO getBiggestEnviroment(List<Environment> enviroments) {
        Environment enviromentMax = enviroments.stream().max(Comparator.comparing(this::calculateSquareMeters)).get();

        return EnviromentMapper.toDTO(enviromentMax);
    }

    private List<EnvironmentSquareMetersDTO> getSquareMetersEachEnvironment(List<Environment> environments) {
        return environments.stream().map(x -> new EnvironmentSquareMetersDTO(x.getName(), calculateSquareMeters(x))).collect(Collectors.toList());
    }
}
