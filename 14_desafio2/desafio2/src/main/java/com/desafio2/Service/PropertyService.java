package com.desafio2.Service;

import com.desafio2.DTO.EnvironmentDTO;
import com.desafio2.Model.Environment;
import com.desafio2.Model.Property;
import com.desafio2.Repository.IDistrctRepository;
import com.desafio2.Repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Autowired
    IDistrctRepository iDistrctRepository;

    /**
     * Creates a property
     * @param property property
     */
    @Override
    public void create(Property property) {
        iPropertyRepository.save(property);
    }

    /**
     * Calculates total square meters of a property
     * @param property_name property name
     * @return square meters of a property
     */
    @Override
    public double getTotalSquareMeters(String property_name) {
        Property property = iPropertyRepository.findByName(property_name);

        double squareMeters = 0;
        for(Environment e : property.getEnvironments()) {
           squareMeters += getRoomSquareMeters(e);
        }
        return squareMeters;
    }

    /**
     * Calculates square meters of an environment
     * @param environment environment
     * @return square meters of environment
     */
    @Override
    public double getRoomSquareMeters(Environment environment) {
        return environment.getEnvironment_width() * environment.getEnvironment_length();
    }

    /**
     * Calculates property price
     * @param property_name property name
     * @return property price
     */
    @Override
    public double getPropertyPrice(String property_name) {
        Property property = iPropertyRepository.findByName(property_name);
        double districtPrice = iDistrctRepository.findByName(property.getDistrict_name()).getDistrict_price();
        return getTotalSquareMeters(property_name) * districtPrice;
    }

    /**
     * Calculates the biggest environment of a property
     * @param property_name name of the property
     * @return biggest environment of a property
     */
    @Override
    public Environment getBiggestEnvironment(String property_name) {
        Property property = iPropertyRepository.findByName(property_name);
        double maxSquareMeters = 0;
        Environment maxEnvironment = new Environment();
        for(Environment e : property.getEnvironments()) {
            if (getRoomSquareMeters(e) > maxSquareMeters) {
                maxEnvironment = e;
                maxSquareMeters = getRoomSquareMeters(e);
            }
        }
        return maxEnvironment;
    }

    /**
     * Calculates the environments square meters of a property
     * @param property_name name of property
     * @return list of environment, with name and total square meters of each
     */
    @Override
    public List<EnvironmentDTO> getEnvironmentListWithSquareMeters(String property_name) {
        Property property = iPropertyRepository.findByName(property_name);
        List<EnvironmentDTO> environmentDTOS = new ArrayList<>();
        for (Environment e : property.getEnvironments()) {
            EnvironmentDTO environmentDTO = new EnvironmentDTO(e.getEnvironment_name(), getRoomSquareMeters(e));
            environmentDTOS.add(environmentDTO);
        }
        return environmentDTOS;
    }
}