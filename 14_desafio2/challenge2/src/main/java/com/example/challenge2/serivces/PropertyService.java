package com.example.challenge2.serivces;

import com.example.challenge2.dtos.*;
import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Environment;
import com.example.challenge2.models.Property;
import com.example.challenge2.repositories.IPropertyDAO;
import com.example.challenge2.serivces.mappers.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PropertyService implements IPropertyService{
    @Autowired
    IPropertyDAO propertyDAO;
    @Autowired
    DistrictService districtService;


    @Override
    public  PropertyDTO create(PropertyDTO propertyDTO) throws DistrictNotFoundException {
       District district = districtService.find(propertyDTO.getDistrictName());
       return propertyDAO.save(propertyDTO);
    }

    private double getEnvironmentSize(Environment environment){
        return environment.getLength() * environment.getWidth();
    }
    @Override
    public SizeResponseDTO getSize(String propertyName) {
        double size = 0;
        PropertyDTO property = propertyDAO.findByName(propertyName);
        for(Environment environment : property.getEnvironmentList()){
            size = size + getEnvironmentSize(environment);
        }
        return new SizeResponseDTO(propertyName,size);

    }

    @Override
    public PriceResponseDTO getPrice(String propertyName) {
        PropertyDTO property = propertyDAO.findByName(propertyName);
        District district = districtService.find(property.getDistrictName());
        double price = getSize(propertyName).getSize() * district.getPrice();
        return new PriceResponseDTO(propertyName, price);
    }

    @Override
    public BiggerEnvironmentResponseDTO getBiggerEnvironment(String propertyName) {
        PropertyDTO property = propertyDAO.findByName(propertyName);
        Environment biggerEnvironment = property.getEnvironmentList().get(1);
        double max = 0;
        for(Environment environment : property.getEnvironmentList()){
            double size = getEnvironmentSize(environment);
            if(size > max) {
                biggerEnvironment = environment;
                max = size;
            }
        }
        return new BiggerEnvironmentResponseDTO(propertyName, biggerEnvironment);
    }

    @Override
    public EnvironmentSizesDTO getEnvironments(String propertyName) {
        PropertyDTO property = propertyDAO.findByName(propertyName);
        List<SizeResponseDTO> environments = new ArrayList<>();
        for (Environment environment : property.getEnvironmentList()){
            environments.add(new SizeResponseDTO(environment.getName(), getEnvironmentSize(environment)));
        }
        return new EnvironmentSizesDTO(propertyName, environments);
    }

}
