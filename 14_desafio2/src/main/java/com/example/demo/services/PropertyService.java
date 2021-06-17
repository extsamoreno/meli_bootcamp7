package com.example.demo.services;

import com.example.demo.DTO.*;
import com.example.demo.Mapper;
import com.example.demo.entities.District;
import com.example.demo.entities.Environment;
import com.example.demo.entities.Property;
import com.example.demo.repositories.IDistrictRepository;
import com.example.demo.repositories.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Override
    public ResponseCalculateTotalMetersDTO getResponseCalculateTotalMetersDTO(int propertyId) throws Exception {
        ResponseCalculateTotalMetersDTO response = new ResponseCalculateTotalMetersDTO();
        Property property = iPropertyRepository.getPropertyById(propertyId);

        if (property == null) {
            throw new FileNotFoundException("Property not exists");
        }
        response.setName(property.getName());
        response.setTotalMeters(getTotalMeters(property.getEnvironments()));

        return response;
    }

    private double getTotalMeters(List<Environment> environments) {
        double total = 0;
        for (int i = 0; i < environments.size(); i++) {
            total += environments.get(i).getLength() * environments.get(i).getWidth();
        }
        return total;
    }

    @Override
    public ResponseBiggerEnvironmentDTO getBiggerEnvironment(int propertyId) throws Exception {
        Property property = iPropertyRepository.getPropertyById(propertyId);

        if (property == null) {
            throw new FileNotFoundException("Property not exists");
        }
        if (property.getEnvironments() == null) {
            throw new FileNotFoundException("Property has not environment");
        }

        double total = 0;
        Environment environment = null;
        for (Environment environmentEntry : property.getEnvironments()) {

            if (environmentEntry.getLength() * environmentEntry.getWidth() > total) {
                total += environmentEntry.getLength() * environmentEntry.getWidth();
                environment = environmentEntry;
            }
        }
        ResponseBiggerEnvironmentDTO response = new ResponseBiggerEnvironmentDTO();
        response.setName(property.getName());
        response.setEnvironmentName(environment.getName());
        response.setBiggerEnvironmentMeters(total);

        return response;
    }

    @Override
    public ResponseTotalMetersByEnvironmentDTO getTotalMetersByEnvironment(int propertyId) throws FileNotFoundException {
        Property property = iPropertyRepository.getPropertyById(propertyId);

        if (property == null) {
            throw new FileNotFoundException("Property not exists");
        }
        if (property.getEnvironments() == null) {
            throw new FileNotFoundException("Property has not environment");
        }

        List<EnvironmentDTO> list = new ArrayList<>();
        for (Environment environmentEntry : property.getEnvironments()) {
            EnvironmentDTO environment = new EnvironmentDTO();
            environment.setName(environmentEntry.getName());
            environment.setTotalMeters(environmentEntry.getLength() * environmentEntry.getWidth());
            list.add(environment);
        }

        ResponseTotalMetersByEnvironmentDTO response = new ResponseTotalMetersByEnvironmentDTO();
        response.setNameProperty(property.getName());
        response.setEnvironments(list);

        return response;
    }

    @Override
    public ResponsePriceDTO getPrice(int propertyId) throws Exception {
        Property property = iPropertyRepository.getPropertyById(propertyId);

        if (property == null) {
            throw new FileNotFoundException("Property not exists");
        }
        if (property.getEnvironments() == null) {
            throw new FileNotFoundException("Property has not environment");
        }

        double priceByMeter = property.getDistrict().getPrice();
        double totalPrice = getTotalMeters(property.getEnvironments()) * priceByMeter;

        ResponsePriceDTO response = new ResponsePriceDTO();
        response.setPropertyId(propertyId);
        response.setPropertyName(property.getName());
        response.setPrice(totalPrice);

        return response;
    }

    @Override
    public void addProperty(PropertyDTO propertyDTO) throws Exception {
        District district = iDistrictRepository.findDistrictByName(propertyDTO.getDistrictName());

        if (district == null) {
            throw new FileNotFoundException("District not exists");
        }
        Property property = new Property();
        property.setId(propertyDTO.getId());
        property.setName(propertyDTO.getName());
        property.setDistrict(district);
        property.setEnvironments(Mapper.toEnvironment(propertyDTO.getEnvironments()));
        iPropertyRepository.addProperty(property);
    }
}
