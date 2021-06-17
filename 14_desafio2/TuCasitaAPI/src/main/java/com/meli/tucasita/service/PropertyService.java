package com.meli.tucasita.service;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.model.District;
import com.meli.tucasita.model.Environment;
import com.meli.tucasita.model.Property;
import com.meli.tucasita.repository.IDistrictRepository;
import com.meli.tucasita.repository.IPropertyRepository;
import com.meli.tucasita.service.dto.*;
import com.meli.tucasita.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Override
    public PropertyWithM2DTO getTotalM2(String name) throws PropertyNotFoundException {
        Property p= iPropertyRepository.getPropertyByName(name);
        double totalM2= calculateTotalM2(p);
        return Mapper.toPropertyWithM2(p,totalM2);
    }

    @Override
    public HttpStatus addNewProperty(PropertyDTORequest property) throws DistrictNotFoundException {
        District district= iDistrictRepository.getDistrictByName(property.getDistrict());
        Property newProperty= Mapper.toProperty(property, district);
        return iPropertyRepository.addNewProperty(newProperty);
    }

    @Override
    public PropertyWithPriceDTO getPrice(String name) throws PropertyNotFoundException {
        Property property= iPropertyRepository.getPropertyByName(name);
        double pricePerMeter= property.getDistrict().getPrice();
        double totalM2= calculateTotalM2(property);

        PropertyWithPriceDTO propertyResponse= new PropertyWithPriceDTO();
        propertyResponse.setPrice(pricePerMeter*totalM2*1.0);
        propertyResponse.setName(property.getName());
        return propertyResponse;
    }

    @Override
    public PropertyWithEnvAndMetersDTO getMetersPerEnvironment(String name) throws PropertyNotFoundException {
        Property property= iPropertyRepository.getPropertyByName(name);
        List<Environment> environments= property.getEnvironments();
        PropertyWithEnvAndMetersDTO response= new PropertyWithEnvAndMetersDTO();
        response.setName(property.getName());
        Environment environment= null;
        for (int i = 0; i < environments.size(); i++) {
            environment= environments.get(i);
            response.addEnvDTO(new EnvironmentResponseDTO(environment.getName(),environment.getLength()*environment.getWidth()));
        }
        return response;
    }

    @Override
    public PropertyWithBiggerEnvDTO getBiggerEnvironment(String name) throws PropertyNotFoundException {
        Property property=iPropertyRepository.getPropertyByName(name);
        PropertyWithBiggerEnvDTO response= new PropertyWithBiggerEnvDTO();
        response.setName(property.getName());
        response.setEnvironment(Mapper.toEnvResponseDTO(getBiggerEnvironment(property)));
        return response;
    }

    public double calculateTotalM2(Property property){
        List<Environment> environments= property.getEnvironments();
        return environments.stream().mapToDouble(environment -> environment.getWidth() * environment.getLength()*1.0).sum();
    }

    public Environment getBiggerEnvironment(Property property){
        List<Environment> environments= property.getEnvironments();
        Environment biggerEnv= environments.stream().reduce((a,b)->a.getLength()*a.getWidth()*1.0>b.getLength()*b.getWidth()*1.0?a:b).get();
        return biggerEnv;
    }
}
