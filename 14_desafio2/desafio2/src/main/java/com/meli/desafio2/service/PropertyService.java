package com.meli.desafio2.service;

import com.meli.desafio2.dto.*;
import com.meli.desafio2.exception.DistrictNotFoundException;
import com.meli.desafio2.exception.PropertyNotFoundException;
import com.meli.desafio2.mapper.DistrictMapper;
import com.meli.desafio2.mapper.EnvironmentMapper;
import com.meli.desafio2.mapper.PropertyMapper;
import com.meli.desafio2.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository propertyRepository;

    @Override
    public String newProperty(PropertyInputDTO propertyInput) {
        String message = "";
        PropertyDTO property = PropertyMapper.InputDTOToDTO(propertyInput);
        DistrictDTO district = propertyRepository.getDistrictByName(propertyInput.getDistrict().getDistrict_name());
        if(district==null) throw  new DistrictNotFoundException();
        property.setDistrict_id(district.getDistrict_id());
        int id = propertyRepository.newProperty(property);
        return "La propiedad "+ property.getProp_name() +" ha sido registrada correctamente con el ID: "+id+"."+message;
    }

    @Override
    public PropertyFullDTO getProperty(int id) {
        PropertyFullDTO property = propertyRepository.getFullById(id);
        if(property!=null){
            return propertyRepository.getFullById(id);
        }else throw new PropertyNotFoundException();
    }

    @Override
    public PropertySquareDTO getSquareMeters(int id) {
        PropertyFullDTO property=propertyRepository.getFullById(id);
        if(property==null){
            throw new PropertyNotFoundException();
        }
        Double squareMeters=0.0;

        for (EnvironmentSquareDTO environmentSquare:calculateSquare(property.getEnvironments())) {
            squareMeters+=environmentSquare.getSquare_meters();
        }
        return PropertyMapper.DTOToSqusreDTO(property,squareMeters);
    }

    @Override
    public PropertyValueDTO getValue(int id) {
        PropertyFullDTO property = propertyRepository.getFullById(id);
        if(property==null){
            throw new PropertyNotFoundException();
        }
        double value=0;
        for (EnvironmentSquareDTO environmentSquare : calculateSquare(property.getEnvironments())) {
            value+= environmentSquare.getSquare_meters()*property.getDistrict().getDistrict_price();
        }
        return PropertyMapper.fullDTOtoValueDTO(property,value);
    }

    @Override
    public PropertyBiggestEnvironmentDTO getBiggestEnvironment(int id) {
        PropertyDTO property = propertyRepository.getById(id);
        if(property==null){
            throw new PropertyNotFoundException();
        }
        EnvironmentSquareDTO biggest=null;
        for (EnvironmentSquareDTO environmentSquare : calculateSquare(property.getEnvironments())) {
            if(biggest==null || environmentSquare.getSquare_meters()> biggest.getSquare_meters()){
                biggest=environmentSquare;
            }
        }
        return PropertyMapper.DTOToBiggestDTO(property,biggest);
    }

    @Override
    public PropertyAllSquareDTO getEnvironmentsSquare(int id) {
        PropertyDTO property = propertyRepository.getById(id);
        if(property==null){
            throw new PropertyNotFoundException();
        }
        ArrayList<EnvironmentSquareDTO> environmentSquareList = calculateSquare(property.getEnvironments());
        return PropertyMapper.DTOToAllSquareDTO(property,environmentSquareList);
    }

    private ArrayList<EnvironmentSquareDTO> calculateSquare(ArrayList<EnvironmentDTO> environmentList){
        ArrayList<EnvironmentSquareDTO> environmentSquareList= new ArrayList<>();
        double square=0;
        for (EnvironmentDTO environment:environmentList) {
            square=environment.getEnvironment_length()* environment.getEnvironment_width();
            environmentSquareList.add(EnvironmentMapper.DTOToSquareDTO(environment,square));
        }
        return environmentSquareList;
    }
}
