package com.tucasitaTasaciones.service;

import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.exceptions.DistrictNotFoundException;
import com.tucasitaTasaciones.model.District;
import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IDistrictRepository;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PropertyService implements IPropertyService {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    IDistrictRepository districtRepository;


    @Override
    public void addNewProperty(PropertyDTO property) {
        District district = districtRepository.findDistrictByName(property.getDistrict_name());
        if (district == null) {
            throw new DistrictNotFoundException(property.getDistrict_name());
        }
        Property newProperty = mapper.map(property, Property.class);
        newProperty.setDistrict(district);
        propertyRepository.addNewProperty(newProperty);
    }

    @Override
    public List<PropertyDTO> getProperties() {
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for (Property p : propertyRepository.getProperties()) {
            PropertyDTO newProperty = mapper.map(p, PropertyDTO.class);
            propertyDTOList.add(newProperty);
        }
        return propertyDTOList;
    }
}