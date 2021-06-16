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

    @Override
    public double getTotalSquareMeters(String name) {
        Property property = iPropertyRepository.findByName(name);

        double squareMeters = 0;
        for(Environment e : property.getEnvironments()) {
           squareMeters += getRoomSquareMeters(e);
        }
        return squareMeters;
    }

    @Override
    public double getRoomSquareMeters(Environment environment) {
        return environment.getEnvironment_width() * environment.getEnvironment_length();
    }

    @Override
    public double getPropertyPrice(String name) {
        Property property = iPropertyRepository.findByName(name);
        double districtPrice = iDistrctRepository.findByName(property.getDistrict_name()).getDistrict_price();
        return getTotalSquareMeters(name) * districtPrice;
    }

    @Override
    public Environment getBiggestEnvironment(String name) {
        Property property = iPropertyRepository.findByName(name);
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

    @Override
    public List<EnvironmentDTO> getEnvironmentListWithSquareMeters(String name) {
        Property property = iPropertyRepository.findByName(name);
        List<EnvironmentDTO> environmentDTOS = new ArrayList<>();
        for (Environment e : property.getEnvironments()) {
            EnvironmentDTO environmentDTO = new EnvironmentDTO(e.getEnvironment_name(), getRoomSquareMeters(e));
            environmentDTOS.add(environmentDTO);
        }
        return environmentDTOS;
    }
}