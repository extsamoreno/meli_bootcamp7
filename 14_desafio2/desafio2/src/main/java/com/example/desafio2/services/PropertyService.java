package com.example.desafio2.services;

import com.example.desafio2.dtos.ResponsePropertySquareDTO;
import com.example.desafio2.models.EnvironmentDTO;
import com.example.desafio2.models.PropertyDTO;
import com.example.desafio2.repositories.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public ResponsePropertySquareDTO getSquareMeters(String propertyName) {
        ResponsePropertySquareDTO responseProperty = new ResponsePropertySquareDTO();
        PropertyDTO propertyDTO = iPropertyRepository.getPropertyByName(propertyName);

        responseProperty.setPropertyName(propertyDTO.getName());
        responseProperty.setTotalSquareMeters(calculatePropertySquareMeters(propertyDTO));

        return responseProperty;
    }

    public double calculateEnvironmentSquareMeters(EnvironmentDTO environment) {
        return environment.getWidth() * environment.getLength();
    }

    public double calculatePropertySquareMeters(PropertyDTO property) {
        double totalSquareMeters = 0;
        for (EnvironmentDTO env : property.getEnvironments()) {
            totalSquareMeters += calculateEnvironmentSquareMeters(env);
        }
        return totalSquareMeters;
    }
}
