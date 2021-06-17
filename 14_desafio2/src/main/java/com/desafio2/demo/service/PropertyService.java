package com.desafio2.demo.service;

import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Environment;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyService iPropertyRepository;

    @Override
    public ResponsePropertySquareDTO getSquareMeters(int propertyId) throws PropertyNotFoundException {
        ResponsePropertySquareDTO responseProperty = new ResponsePropertySquareDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);

        responseProperty.setPropertyName(property.getName());
        responseProperty.setTotalSquareMeters(calculatePropertySquareMeters(property));

        return responseProperty;
    }

    @Override
    public ResponsePropertyValueDTO getPropertyValue(int propertyId) throws PropertyException {
        ResponsePropertyValueDTO responsePropertyValue = new ResponsePropertyValueDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);
        Neighborhood neighborhood = iPropertyRepository.getNeighborhoodById(property.getNeighborhood());

        responsePropertyValue.setPropertyName(property.getName());
        responsePropertyValue.setValueOfProperty(calculatePropertyValue(property, neighborhood));

        return responsePropertyValue;
    }

    @Override
    public ResponseBiggestEnvironmentDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException {
        ResponseBiggestEnvironmentDTO responseBiggestEnvironment = new ResponseBiggestEnvironmentDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);

        responseBiggestEnvironment.setPropertyName(property.getName());
        Environment Environment = calculateBiggestEnvironment(property);
        responseBiggestEnvironment.setTotalSquareMeters(calculateEnvironmentSquareMeters(Environment));
        responseBiggestEnvironment.setEnvironment(Environment);

        return responseBiggestEnvironment;
    }

    @Override
    public ResponseSquareMetersEnvironmentDTO getSquareMetersOfEnvironments(int propertyId)
            throws PropertyNotFoundException {
        ResponseSquareMetersEnvironmentDTO response = new ResponseSquareMetersEnvironmentDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);

        response.setPropertyName(property.getName());
        response.setEnvironments(getEnvironmentsSquareMeters(property));

        return response;
    }

    @Override
    public Property getPropertyById(int propertyId) {
        return null;
    }

    @Override
    public Neighborhood getNeighborhoodById(String neighborhood) {
        return null;
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

    private double calculatePropertyValue(Property property, Neighborhood neighborhood) {
        double price = calculatePropertySquareMeters(property);
        return price * neighborhood.getPrice();
    }

    private Environment calculateBiggestEnvironment(Property property) {
        double squareMeters;
        double biggestEnvironment = 0;
        Environment biggest = null;
        for (Environment env : property.getEnvironments()) {
            squareMeters = calculateEnvironmentSquareMeters(env);
            if (biggest == null || squareMeters > biggestEnvironment){
                biggest = env;
                biggestEnvironment = squareMeters;
            }
        }
        return biggest;
    }

    private List<ResponseEnvironmentDTO> getEnvironmentsSquareMeters(Property property) {
        List<ResponseEnvironmentDTO> environments = new ArrayList<>();
        ResponseEnvironmentDTO environment;
        for(Environment env : property.getEnvironments()) {
            environment = new ResponseEnvironmentDTO();
            environment.setEnvironmentName(env.getName());
            environment.setTotalSquareMeters(calculateEnvironmentSquareMeters(env));
            environments.add(environment);
        }
        return environments;
    }
}