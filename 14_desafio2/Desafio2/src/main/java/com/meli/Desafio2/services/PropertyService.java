package com.meli.desafio2.services;

import com.meli.desafio2.dtos.*;
import com.meli.desafio2.repositories.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("PropertyService")
@Primary
public class PropertyService implements IPropertyService {
    @Autowired
    IDistrictRepository iDistrictRepository;

    //US-0001
    @Override
    public PropertyResponseTotalSquareMetersDTO calculateTotalSquareMeters(PropertyDTO property) {
        var response = new PropertyResponseTotalSquareMetersDTO( calculateEnvironmentSquareMeters(property) );
        return response;
    }

    //US-0002
    @Override
    public PropertyResponseValueDTO calculatePrice(PropertyDTO property) {
        var square = calculateEnvironmentSquareMeters(property) * priceByDistrict( property.getNameDistrict(), property.getPriceDistrict() );
        var response = new PropertyResponseValueDTO(square);
        return response;
    }

    //US-0003
    @Override
    public EnvironmentDTO getBiggestEnvironment(PropertyDTO property) {
        return calculateBiggestEnvironment(property);
    }

    //US-0004
    @Override
    public PropertyResponseSquareMetersPerEnvDTO calculateSquareMetersPerEnv(PropertyDTO property) {
        var environment = new ArrayList<EnvironmentSquareMetersDTO>();

        for (EnvironmentDTO environmentDTO : property.getEnvironment()) {
            Integer squareMeters = getSquareMeters(environmentDTO);
            environment.add(new EnvironmentSquareMetersDTO( environmentDTO.getNameEnvironment(), squareMeters ));
        }

        var response = new PropertyResponseSquareMetersPerEnvDTO( environment );
        return response;
    }

    private Integer getSquareMeters(EnvironmentDTO environment) {
        Integer result = 0;
        if (environment.getWidth() != null && environment.getLength() != null)
            result = environment.getWidth() * environment.getLength();
        return result;
    }

    private Integer calculateEnvironmentSquareMeters(PropertyDTO property) {
        Integer totalSquareMeters = 0;
        for (EnvironmentDTO environment : property.getEnvironment()) {
            totalSquareMeters += getSquareMeters(environment);
        }

        return totalSquareMeters;
    }

    private EnvironmentDTO calculateBiggestEnvironment(PropertyDTO property) {
        EnvironmentDTO biggest = null;
        Integer maxEnvironment = 0;
        for (EnvironmentDTO environment : property.getEnvironment()) {
            Integer squareMeter = getSquareMeters(environment);
            if (biggest == null || squareMeter > maxEnvironment) {
                biggest = environment;
                maxEnvironment = squareMeter;
            }
        }
        return biggest;
    }

    private Double priceByDistrict(String nameDistrict, Double priceDistrict) {
        var price = districtByNameAndPrice(nameDistrict, priceDistrict).getPriceDistrict();
        System.out.println(price);
        return price;
    }

    private DistrictDTO districtByNameAndPrice(String nameDistrict, Double priceDistrict){
        DistrictDTO district = null;
        try{
            district = iDistrictRepository.getDistrictByNameAndPrice(nameDistrict, priceDistrict);
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }
        return district;
    }
}