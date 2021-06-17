package com.example.demo.services;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.District;
import com.example.demo.model.Property;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.repositories.PropertyRepository;
import com.example.demo.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImple implements PropertyService{

    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    DistrictRepository districtRepository;

    @Override
    public void load() {
        propertyRepository.loadData();
        districtRepository.loadData();
    }

    @Override
    public PropertyM2ResponseDTO getMeterSquare(int propId) throws PropertyDontFoundException {
        return propertyRepository.getSquareMeter(propId);
    }

    @Override
    public PropertyPriceResponseDTO getPrice(int proId) throws PropertyDontFoundException {
        return propertyRepository.getPrice(proId);
    }

    @Override
    public BiggestPropResponseDTO getBiggestEnvProp(int propId) throws PropertyDontFoundException {
        return propertyRepository.getBiggestEnvProp(propId);
    }

    @Override
    public PropertyM2EnvsResponseDTO getMeterSquareEnvs(int propId) throws PropertyDontFoundException {
        return propertyRepository.getMeterSquareEnvs(propId);
    }

    @Override
    public PropertyRequestDTO addProperty(PropertyRequestDTO propertyRequestDTO) throws DistrictDontFoundException {
        districtRepository.findDistrictById(propertyRequestDTO.getDistrict().getDistrict_id());
        return propertyRepository.addProperty(propertyRequestDTO);
    }

    @Override
    public Property findPropertyById(int propId) throws PropertyDontFoundException {
        return propertyRepository.findPropertyById(propId);
    }
}
