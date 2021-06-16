package com.tucasitatasaciones.demo.service;

import com.tucasitatasaciones.demo.dto.PropertyDTO;
import com.tucasitatasaciones.demo.exception.ResponseException;
import com.tucasitatasaciones.demo.models.District;
import com.tucasitatasaciones.demo.models.Property;
import com.tucasitatasaciones.demo.repository.IDistrictRepository;
import com.tucasitatasaciones.demo.repository.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    IDistrictRepository districtRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public PropertyDTO addProperty(PropertyDTO property){
        District district = districtRepository.findDistrictById(property.getDistrictId());

        if(district == null)
            return null;

        Property propertyToAdd = mapper.map(property, Property.class);

        PropertyDTO propertyAdded = mapper.map(propertyRepository.addProperty(propertyToAdd), PropertyDTO.class);

        return propertyAdded;
    }

}
