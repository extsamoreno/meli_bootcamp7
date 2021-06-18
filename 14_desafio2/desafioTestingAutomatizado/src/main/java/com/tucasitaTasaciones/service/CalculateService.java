package com.tucasitaTasaciones.service;

import com.tucasitaTasaciones.dto.ResponseDTO.CalculateResponseDTO;
import com.tucasitaTasaciones.exceptions.PropertyNotFoundException;
import com.tucasitaTasaciones.model.Environment;
import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IDistrictRepository;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculateService implements ICalculateService {

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    IDistrictRepository districtRepository;

    @Override
    public CalculateResponseDTO calculateSquareMeters(Integer id) {
        Property property = propertyRepository.findProperty(id);
        if (property == null) {
            throw new PropertyNotFoundException(id);
        }
        Integer totalSquareFeet = 0;
        for (Environment r : property.getEnvironmentList()) {
            Integer squareFeet = r.getSquareFeet();
            totalSquareFeet += squareFeet;
        }

        CalculateResponseDTO response = new CalculateResponseDTO();
        response.setTotalSquareMeters(totalSquareFeet);

        return response;
    }

    @Override
    public CalculateResponseDTO calculateValue(Integer id) {
        Property property = propertyRepository.findProperty(id);
        if (property == null) {
            throw new PropertyNotFoundException(id);
        }
        CalculateResponseDTO response = new CalculateResponseDTO();
        Integer totalSquareFeet = calculateSquareMeters(id).getTotalSquareMeters();
        Double value = totalSquareFeet * property.getDistrict().getDistrict_price();
        response.setPropertyPrice(value);
        return response;
    }

    @Override
    public CalculateResponseDTO calculateLargestRoom(Integer id) {
        Property property = propertyRepository.findProperty(id);
        if (property == null) {
            throw new PropertyNotFoundException(id);
        }
        Environment biggest = null;
        Integer maxRoom = 0;
        for (Environment room : property.getEnvironmentList()) {
            Integer squareFeet = room.getSquareFeet();
            if (biggest == null || squareFeet > maxRoom) {
                biggest = room;
                maxRoom = squareFeet;
            }
        }
        CalculateResponseDTO response = new CalculateResponseDTO();
        response.setLargestRoom(biggest.getEnvironment_name());
        return response;
    }

    @Override
    public CalculateResponseDTO calculateEnvironmentsSquareMeters(Integer id) {
        Property property = propertyRepository.findProperty(id);

        if (property == null) {
            throw new PropertyNotFoundException(id);
        }

        CalculateResponseDTO response = new CalculateResponseDTO();
        response.setEnvironmentsSquareMeters(getEnvironmentsSquareMeters(property.getEnvironmentList()));
        return response;
    }

    private Map<String, Integer> getEnvironmentsSquareMeters(List<Environment> environmentList) {
        Map<String, Integer> environmentArea = new HashMap<>();

        for (Environment r : environmentList) {
            environmentArea.put(r.getEnvironment_name(), r.getSquareFeet());
        }
        return environmentArea;
    }
}
