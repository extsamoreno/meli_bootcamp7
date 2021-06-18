package com.example.demo.services;

import com.example.demo.DTO.*;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.Mapper;
import com.example.demo.entities.District;
import com.example.demo.entities.Environment;
import com.example.demo.entities.Property;
import com.example.demo.repositories.IDistrictRepository;
import com.example.demo.repositories.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Property property = iPropertyRepository.getPropertyById(propertyId);
        if (property == null) {
            throw new NotFoundException("Property does not exists");
        }

        return Mapper.getResponseCalculateTotalMetersDTO(property, getTotalMeters(property.getEnvironments()));
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
            throw new NotFoundException("Property does not exists");
        }
        if (property.getEnvironments() == null) {
            throw new NotFoundException("Property has not environment");
        }

        double total = 0;
        Environment environment = null;
        for (Environment environmentEntry : property.getEnvironments()) {

            if (environmentEntry.getLength() * environmentEntry.getWidth() > total) {
                total = environmentEntry.getLength() * environmentEntry.getWidth();
                environment = environmentEntry;
            }
        }
        return Mapper.getResponseBiggerEnvironmentDTO(property.getName(), environment.getName(), total);
    }

    @Override
    public ResponseTotalMetersByEnvironmentDTO getTotalMetersByEnvironment(int propertyId) throws Exception {
        Property property = iPropertyRepository.getPropertyById(propertyId);

        if (property == null) {
            throw new NotFoundException("Property does not exists");
        }
        if (property.getEnvironments() == null) {
            throw new NotFoundException("Property has not environment");
        }
        List<EnvironmentDTO> list = Mapper.toEnvironmentDTO(property.getEnvironments());

        return Mapper.getResponseTotalMetersByEnvironmentDTO(property,list);
    }

    @Override
    public ResponsePriceDTO getPrice(int propertyId) throws Exception {
        Property property = iPropertyRepository.getPropertyById(propertyId);

        if (property == null) {
            throw new NotFoundException("Property does not exists");
        }
        if (property.getEnvironments() == null) {
            throw new NotFoundException("Property has not environment");
        }
        double priceByMeter = property.getDistrict().getPrice();
        double totalPrice = getTotalMeters(property.getEnvironments()) * priceByMeter;

        return Mapper.getResponsePriceDTO(property,totalPrice);
    }

    @Override
    public void addProperty(PropertyDTO propertyDTO) throws Exception {
        Property aux = iPropertyRepository.getPropertyById(propertyDTO.getId());
        if (aux != null) {
            throw new BadRequestException("Property already exist");
        }
        District district = iDistrictRepository.findDistrictByName(propertyDTO.getDistrictName());
        if (district == null) {
            throw new NotFoundException("District does not exists");
        }
        iPropertyRepository.addProperty(Mapper.toProperty(propertyDTO, district));
    }
}
