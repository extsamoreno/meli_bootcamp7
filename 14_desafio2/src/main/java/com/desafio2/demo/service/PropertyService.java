package com.desafio2.demo.service;

import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Environment;
import com.desafio2.demo.model.Neighborhood;
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

    /**
     * add property to db
     */
    public Property createProperty(Property propertyDTO) throws PropertyAlreadyExistException {
        return iPropertyRepository.saveProperty(propertyDTO);
    }

    /**
     * add neighborhood to db
     */
    @Override
    public Neighborhood createNeighborhood(Neighborhood neighborhood)
            throws NeighborhoodAlreadyExistException {
        return iPropertyRepository.saveNeighborhood(neighborhood);
    }

    /**
     * calculate square meters - property
     */
    @Override
    public ResponsePropertySquareDTO getSquareMeters(int propertyId) throws PropertyNotFoundException {
        ResponsePropertySquareDTO responseProperty = new ResponsePropertySquareDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);

        responseProperty.setPropertyName(property.getName());
        responseProperty.setTotalSquareMeters(calculatePropertySquareMeters(property));

        return responseProperty;
    }

    /**
     * calculate value property
     */
    @Override
    public ResponsePropertyValueDTO getPropertyValue(int propertyId) throws PropertyException {
        ResponsePropertyValueDTO responsePropertyValue = new ResponsePropertyValueDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);
        Neighborhood neighborhoodDTO = iPropertyRepository.getNeighborhoodById(property.getNeighborhood());

        responsePropertyValue.setPropertyName(property.getName());
        responsePropertyValue.setValueOfProperty(calculatePropertyValue(property, neighborhoodDTO));

        return responsePropertyValue;
    }

    /**
     * return the biggest of property
     */
    @Override
    public ResponseBiggestEnvironmentDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException {
        ResponseBiggestEnvironmentDTO responseBiggestEnvironment = new ResponseBiggestEnvironmentDTO();
        Property propertyDTO = iPropertyRepository.getPropertyById(propertyId);

        responseBiggestEnvironment.setPropertyName(propertyDTO.getName());
        Environment environment = calculateBiggestEnvironment(propertyDTO);
        responseBiggestEnvironment.setTotalSquareMeters(calculateEnvironmentSquareMeters(environment));
        responseBiggestEnvironment.setEnvironment(environment);

        return responseBiggestEnvironment;
    }

    /**
     * calculate the square meters of the property
     */
    @Override
    public ResponseSquareMetersEnvironmentDTO getSquareMetersOfEnvironments(int propertyId)
            throws PropertyNotFoundException {
        ResponseSquareMetersEnvironmentDTO response = new ResponseSquareMetersEnvironmentDTO();
        Property propertyDTO = iPropertyRepository.getPropertyById(propertyId);

        response.setPropertyName(propertyDTO.getName());
        response.setEnvironments(getEnvironmentsSquareMeters(propertyDTO));

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

    private double calculatePropertyValue(Property propertyDTO, Neighborhood neighborhoodDTO) {
        double price = calculatePropertySquareMeters(propertyDTO);
        return price * neighborhoodDTO.getPrice();
    }

    private Environment calculateBiggestEnvironment(Property propertyDTO) {
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

    private List<ResponseEnvironmentDTO> getEnvironmentsSquareMeters(Property propertyDTO) {
        List<ResponseEnvironmentDTO> environments = new ArrayList<>();
        ResponseEnvironmentDTO environment;
        for(Environment env : propertyDTO.getEnvironments()) {
            environment = new ResponseEnvironmentDTO();
            environment.setEnvironmentName(env.getName());
            environment.setTotalSquareMeters(calculateEnvironmentSquareMeters(env));
            environments.add(environment);
        }
        return environments;
    }
}