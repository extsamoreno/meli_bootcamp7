package com.tucasitaTasaciones.service;

import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.model.District;
import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IDistrictRepository;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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

        District district= districtRepository.findDistrictByName(property.getDistrictName());

        Property newProperty = mapper.map(property,Property.class);
        newProperty.setDistrict(district);
        propertyRepository.addNewProperty(newProperty);

    }

    @Override
    public List<Property> getProperties() {
        return propertyRepository.getProperties();
    }
}
