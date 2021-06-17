package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.PropertyDTO;
import com.meli.desafio2.web.exception.DistrictNotFoundException;
import com.meli.desafio2.web.exception.PropertyAlreadyExistException;
import com.meli.desafio2.web.exception.PropertyException;
import com.meli.desafio2.web.exception.PropertyNameNotFoundException;
import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.repository.IDistrictRepository;
import com.meli.desafio2.web.repository.IPropertyRepository;
import com.meli.desafio2.web.responses.BiggestEnvironmentResponse;
import com.meli.desafio2.web.responses.PropertyValueResponse;
import com.meli.desafio2.web.responses.SquareMetersEnvironmentResponse;
import com.meli.desafio2.web.responses.SquareMetersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.el.PropertyNotFoundException;
import java.util.HashMap;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{
    @Autowired
    IPropertyRepository iPropertyRepository;
    @Autowired
    IDistrictRepository iDistrictRepository;

    @Override
    public SquareMetersResponse getSquareMeters(String name) throws PropertyNameNotFoundException{
        Property property = iPropertyRepository.getPropertyByName(name);
        if(property==null){
            throw new PropertyNameNotFoundException(name, HttpStatus.BAD_REQUEST);
        }
        double squareMeters = calculateListSquareMeters(property.getEnvironments());
        return new SquareMetersResponse(property.getProp_name(),squareMeters);
    }

    @Override
    public PropertyValueResponse getValue(String name) throws PropertyNameNotFoundException {
        Property property = iPropertyRepository.getPropertyByName(name);
        District district = iDistrictRepository.getDistrictByName(property.getDistrict());
        if(property==null){
            throw new PropertyNameNotFoundException(name, HttpStatus.BAD_REQUEST);
        }
        double value = calculateListSquareMeters(property.getEnvironments())*district.getDistrict_price();
        return new PropertyValueResponse(property,value);
    }

    @Override
    public BiggestEnvironmentResponse getBiggestEnvironment(String name) throws PropertyNameNotFoundException{
        Property property = iPropertyRepository.getPropertyByName(name);
        if(property==null){
            throw new PropertyNameNotFoundException(name, HttpStatus.BAD_REQUEST);
        }

        Environment response = new Environment();
        List<Environment> environments = property.getEnvironments();
        double max_size = 0;
        double square_value;
        for(Environment environment:environments){
            square_value = calculateSquareMeters(environment);
            if(square_value>max_size){
                max_size = square_value;
                response = environment;
            }
        }
        return new BiggestEnvironmentResponse(name,response);
    }

    @Override
    public SquareMetersEnvironmentResponse getEnvironmentSquareMeters(String name) throws PropertyNameNotFoundException {
        Property property = iPropertyRepository.getPropertyByName(name);
        if(property==null){
            throw new PropertyNameNotFoundException(name, HttpStatus.BAD_REQUEST);
        }
        HashMap<String, Double> SquareValues = new HashMap<>();
        List<Environment> environments = property.getEnvironments();
        for(Environment environment:environments){
            SquareValues.put(environment.getEnvironment_name(),calculateSquareMeters(environment));
        }
        return new SquareMetersEnvironmentResponse(name,SquareValues);
    }

    @Override
    public void addProperty(PropertyDTO propertyDTO) throws PropertyException,DistrictNotFoundException {
        if(iPropertyRepository.getPropertyByName(propertyDTO.getProp_name())!=null){
            throw new PropertyAlreadyExistException(propertyDTO.getProp_name(), HttpStatus.BAD_REQUEST);
        }
        if(iDistrictRepository.getDistrictByName(propertyDTO.getDistrict())==null){
            throw new DistrictNotFoundException(propertyDTO.getDistrict(), HttpStatus.BAD_REQUEST);
        }
        iPropertyRepository.saveProperty(PropertyMapper.toModel(propertyDTO));
    }


    private double calculateListSquareMeters(List<Environment> environments){
        double result = 0;
        for(Environment environment:environments){
            result= result + environment.getEnvironment_length()*environment.getEnvironment_width();
        }
        return result;
    }

    private double calculateSquareMeters(Environment environment){
        return environment.getEnvironment_length()* environment.getEnvironment_width();
    }



}
