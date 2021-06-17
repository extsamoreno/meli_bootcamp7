package com.meli.desafio2.service;

import com.meli.desafio2.dto.*;
import com.meli.desafio2.exception.PropertyNotFoundException;
import com.meli.desafio2.mapper.DistrictMapper;
import com.meli.desafio2.mapper.EnviromentMapper;
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
    public int newProperty(PropertyInputDTO propertyInput) {
        PropertyDTO property = PropertyMapper.InputDTOToDTO(propertyInput);
        DistrictDTO district = propertyRepository.getDistrictByName(propertyInput.getDistrict().getDistrict_name());
        if(district==null){
            district= DistrictMapper.InputDTOToDto(propertyInput.getDistrict());
            propertyRepository.newDistrict(district);
        }
        property.setDistrict_id(district.getDistrict_id());
        return propertyRepository.newProperty(property);
    }

    @Override
    public PropertyFullDTO getProperty(int id) {
        return propertyRepository.getFullById(id);
    }

    @Override
    public PropertySquareDTO getSquareMeters(int id) {
        PropertyFullDTO property=propertyRepository.getFullById(id);
        Double squareMeters=0.0;

        for (EnviromentSquareDTO enviromentSquare:calculateSquare(property.getEnviroments())) {
            squareMeters+=enviromentSquare.getSquare_meters();
        }
        return PropertyMapper.DTOToSqusreDTO(property,squareMeters);
    }

    @Override
    public PropertyValueDTO getValue(int id) {
        PropertyFullDTO property = propertyRepository.getFullById(id);
        double value=0;
        for (EnviromentSquareDTO enviromentSquare : calculateSquare(property.getEnviroments())) {
            value+= enviromentSquare.getSquare_meters()*property.getDistrict().getDistrict_price();
        }
        return PropertyMapper.fullDTOtoValueDTO(property,value);
    }

    @Override
    public PropertyBiggestEnviromentDTO getBiggestEnviroment(int id) {
        PropertyDTO property = propertyRepository.getById(id);
        EnviromentSquareDTO biggest=null;
        for (EnviromentSquareDTO enviromentSquare : calculateSquare(property.getEnviroments())) {
            if(biggest==null || enviromentSquare.getSquare_meters()> biggest.getSquare_meters()){
                biggest=enviromentSquare;
            }
        }
        return PropertyMapper.DTOToBiggestDTO(property,biggest);
    }

    @Override
    public PropertyAllSquareDTO getEnviromentsSquare(int id) {
        PropertyDTO property = propertyRepository.getById(id);
        ArrayList<EnviromentSquareDTO> enviromentSquareList = calculateSquare(property.getEnviroments());
        return PropertyMapper.DTOToAllSquareDTO(property,enviromentSquareList);
    }

    private ArrayList<EnviromentSquareDTO> calculateSquare(ArrayList<EnviromentDTO> enviromentList){
        ArrayList<EnviromentSquareDTO> enviromentSquareList= new ArrayList<>();
        double square=0;
        for (EnviromentDTO enviroment:enviromentList) {
            square=enviroment.getEnviroment_length()* enviroment.getEnviroment_width();
            enviromentSquareList.add(EnviromentMapper.DTOToSquareDTO(enviroment,square));
        }
        return enviromentSquareList;
    }
}
