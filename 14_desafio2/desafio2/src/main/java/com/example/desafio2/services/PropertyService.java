package com.example.desafio2.services;

import com.example.desafio2.dtos.*;
import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.EnvironmentDTO;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;
import com.example.desafio2.repositories.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public PropertyDTO createProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistException {
        return iPropertyRepository.saveProperty(propertyDTO);
    }

    @Override
    public NeighborhoodDTO createNeighborhood(NeighborhoodDTO neighborhoodDTO)
            throws NeighborhoodAlreadyExistException {
        return iPropertyRepository.saveNeighborhood(neighborhoodDTO);
    }

    @Override
    public ResponsePropertySquareDTO getSquareMeters(int propertyId) throws PropertyNotFoundException {
        ResponsePropertySquareDTO responseProperty = new ResponsePropertySquareDTO();
        PropertyDTO propertyDTO = iPropertyRepository.getPropertyById(propertyId);

        responseProperty.setPropertyName(propertyDTO.getName());
        responseProperty.setTotalSquareMeters(calculatePropertySquareMeters(propertyDTO));

        return responseProperty;
    }

    @Override
    public ResponsePropertyValueDTO getPropertyValue(int propertyId) throws PropertyException {
        ResponsePropertyValueDTO responsePropertyValue = new ResponsePropertyValueDTO();
        PropertyDTO propertyDTO = iPropertyRepository.getPropertyById(propertyId);
        NeighborhoodDTO neighborhoodDTO = iPropertyRepository.getNeighborhoodById(propertyDTO.getNeighborhood());

        responsePropertyValue.setPropertyName(propertyDTO.getName());
        responsePropertyValue.setValueOfProperty(calculatePropertyValue(propertyDTO, neighborhoodDTO));

        return responsePropertyValue;
    }

    @Override
    public ResponseBiggestEnvironmentDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException {
        ResponseBiggestEnvironmentDTO responseBiggestEnvironment = new ResponseBiggestEnvironmentDTO();
        PropertyDTO propertyDTO = iPropertyRepository.getPropertyById(propertyId);

        responseBiggestEnvironment.setPropertyName(propertyDTO.getName());
        EnvironmentDTO environmentDTO = calculateBiggestEnvironment(propertyDTO);
        responseBiggestEnvironment.setTotalSquareMeters(calculateEnvironmentSquareMeters(environmentDTO));
        responseBiggestEnvironment.setEnvironment(environmentDTO);

        return responseBiggestEnvironment;
    }

    @Override
    public ResponseSquareMetersEnvironmentDTO getSquareMetersOfEnvironments(int propertyId)
            throws PropertyNotFoundException {
        ResponseSquareMetersEnvironmentDTO response = new ResponseSquareMetersEnvironmentDTO();
        PropertyDTO propertyDTO = iPropertyRepository.getPropertyById(propertyId);

        response.setPropertyName(propertyDTO.getName());
        response.setEnvironments(getEnvironmentsSquareMeters(propertyDTO));

        return response;
    }

    private double calculateEnvironmentSquareMeters(EnvironmentDTO environment) {
        return environment.getWidth() * environment.getLength();
    }

    private double calculatePropertySquareMeters(PropertyDTO property) {
        double totalSquareMeters = 0;
        for (EnvironmentDTO env : property.getEnvironments()) {
            totalSquareMeters += calculateEnvironmentSquareMeters(env);
        }
        return totalSquareMeters;
    }

    private double calculatePropertyValue(PropertyDTO propertyDTO, NeighborhoodDTO neighborhoodDTO) {
        double price = calculatePropertySquareMeters(propertyDTO);
        return price * neighborhoodDTO.getPrice();
    }

    private EnvironmentDTO calculateBiggestEnvironment(PropertyDTO propertyDTO) {
        double squareMeters;
        double biggestEnvironment = 0;
        EnvironmentDTO biggest = null;
        for (EnvironmentDTO env : propertyDTO.getEnvironments()) {
            squareMeters = calculateEnvironmentSquareMeters(env);
            if (biggest == null || squareMeters > biggestEnvironment){
                biggest = env;
                biggestEnvironment = squareMeters;
            }
        }
        return biggest;
    }

    private List<ResponseEnvironmentDTO> getEnvironmentsSquareMeters(PropertyDTO propertyDTO) {
        List<ResponseEnvironmentDTO> environments = new ArrayList<>();
        ResponseEnvironmentDTO environment;
        for(EnvironmentDTO env : propertyDTO.getEnvironments()) {
            environment = new ResponseEnvironmentDTO();
            environment.setEnvironmentName(env.getName());
            environment.setTotalSquareMeters(calculateEnvironmentSquareMeters(env));
            environments.add(environment);
        }
        return environments;
    }
}
