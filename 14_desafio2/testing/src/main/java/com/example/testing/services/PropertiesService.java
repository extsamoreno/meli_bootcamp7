package com.example.testing.services;

import com.example.testing.dto.EnvironmentDTO;
import com.example.testing.model.Environment;
import com.example.testing.model.Property;
import com.example.testing.repositories.IPropertiesRepository;
import com.example.testing.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PropertiesService implements IPropertiesService {

    @Autowired
    IPropertiesRepository propertiesRepository;

    @Autowired
    Mapper mapper;


    @Override
    public Double totalSquareMeters(int id) {
        Property property = propertiesRepository.getPropertyById(id);
        Double total = 0.0;

        for (Environment e: property.getEnvironments()) {
            total += e.getSquareMeters();
        }

        return total;
    }

    @Override
    public Double getPrice(int id) {
        Property property = propertiesRepository.getPropertyById(id);
        Double sqMeters = totalSquareMeters(id);
        return property.getDistrict().getPrice() * sqMeters;

    }

    @Override
    public Environment getBiggestEnvironment(int id) {
        Property property = propertiesRepository.getPropertyById(id);
        Environment environment = new Environment("", 0.0, 0.0);

        for (Environment e: property.getEnvironments()) {
            if(environment.getSquareMeters() < e.getSquareMeters()){
                 environment = e;
            }
        }

        return environment;
    }

    @Override
    public ArrayList<EnvironmentDTO> getEnvironments(int id) {
        Property property = propertiesRepository.getPropertyById(id);
        ArrayList<EnvironmentDTO> environments = new ArrayList<>();

        for (Environment e: property.getEnvironments()) {
            environments.add(mapper.toDTO(e));
        }

        return environments;
    }

    @Override
    public void createProperty(Property p) {
        propertiesRepository.createProperty(p);
    }
}
