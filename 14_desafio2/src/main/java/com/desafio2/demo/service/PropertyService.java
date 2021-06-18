package com.desafio2.demo.service;

import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.DistrictAlreadyExistException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Environment;
import com.desafio2.demo.model.District;
import com.desafio2.demo.model.Property;
import com.desafio2.demo.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public Property createProperty(Property property) throws PropertyAlreadyExistException {
        return iPropertyRepository.saveProperty(property);
    }

    @Override
    public District createDistrict(District district)
            throws DistrictAlreadyExistException {
        return iPropertyRepository.saveDistrict(district);
    }

    @Override
    public SquareMetersPropertyDTO getSquareMeters(int propertyId) throws PropertyNotFoundException {
        SquareMetersPropertyDTO responseProperty = new SquareMetersPropertyDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);

        responseProperty.setPropertyName(property.getName());
        responseProperty.setTotalSquareMeters(calculatePropertySquareMeters(property));

        return responseProperty;
    }

    @Override
    public PropertyPriceDTO getPropertyPrice(int propertyId) throws PropertyException {
        PropertyPriceDTO responsePropertyValue = new PropertyPriceDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);
        District districtDTO = iPropertyRepository.getDistrictById(property.getDistrict());

        responsePropertyValue.setPropertyName(property.getName());
        responsePropertyValue.setPropertyPrice(calculatePropertyPrice(property, districtDTO));

        return responsePropertyValue;
    }

    @Override
    public EnvironmentBiggestDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException {
        EnvironmentBiggestDTO responseBiggestEnvironment = new EnvironmentBiggestDTO();
        Property propertyDTO = iPropertyRepository.getPropertyById(propertyId);

        responseBiggestEnvironment.setPropertyName(propertyDTO.getName());
        Environment environment = biggestEnvCalculate(propertyDTO);
        responseBiggestEnvironment.setTotalSquareMeters(calculateEnvironmentSquareMeters(environment));
        responseBiggestEnvironment.setEnvironment(environment);

        return responseBiggestEnvironment;
    }

    @Override
    public SquareMetersEnvironmentDTO getSquareMetersEnvironments(int propertyId)
            throws PropertyNotFoundException {
        SquareMetersEnvironmentDTO response = new SquareMetersEnvironmentDTO();
        Property propertyDTO = iPropertyRepository.getPropertyById(propertyId);

        response.setPropertyName(propertyDTO.getName());
        response.setEnvironments(getSquareMetersEnv(propertyDTO));

        return response;
    }

    public double calculateEnvironmentSquareMeters(Environment environment) {
        return environment.getWidth() * environment.getLength();
    }

    public double calculatePropertySquareMeters(Property property) {
        double totalSquareMeters = 0;
        for (Environment env : property.getEnvironments()) {
            totalSquareMeters += calculateEnvironmentSquareMeters(env);
        }
        return totalSquareMeters;
    }

    private double calculatePropertyPrice(Property propertyDTO, District districtDTO) {
        double price = calculatePropertySquareMeters(propertyDTO);
        return price * districtDTO.getPrice();
    }

    private Environment biggestEnvCalculate(Property propertyDTO) {
        double squareMeters;
        double biggestEnvironment = 0;
        Environment biggest = null;
        for (Environment env : propertyDTO.getEnvironments()) {
            squareMeters = calculateEnvironmentSquareMeters(env);
            if (biggest == null || squareMeters > biggestEnvironment){
                biggest = env;
                biggestEnvironment = squareMeters;
            }
        }
        return biggest;
    }

    private List<EnvironmentDTO> getSquareMetersEnv(Property propertyDTO) {
        List<EnvironmentDTO> environments = new ArrayList<>();
        EnvironmentDTO environment;
        for(Environment env : propertyDTO.getEnvironments()) {
            environment = new EnvironmentDTO();
            environment.setEnvironmentName(env.getName());
            environment.setTotalSquareMeters(calculateEnvironmentSquareMeters(env));
            environments.add(environment);
        }
        return environments;
    }
}