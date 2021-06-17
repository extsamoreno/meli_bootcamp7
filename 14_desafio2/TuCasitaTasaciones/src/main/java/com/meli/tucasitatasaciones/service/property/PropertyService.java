package com.meli.tucasitatasaciones.service.property;

import com.meli.tucasitatasaciones.dto.PropertyDTO;
import com.meli.tucasitatasaciones.exception.DistrictNotFoundException;
import com.meli.tucasitatasaciones.model.District;
import com.meli.tucasitatasaciones.model.Property;
import com.meli.tucasitatasaciones.repository.district.IDistrictRepository;
import com.meli.tucasitatasaciones.repository.property.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Override
    public void createProperty(PropertyDTO property) {
        District district = iDistrictRepository.findDistrictByName(property.getDistrictName());

        if(district == null) {
            throw new DistrictNotFoundException(property.getDistrictName());
        }

        Property newProperty = mapper.map(property,Property.class);
        newProperty.setDistrict(district);
        iPropertyRepository.saveProperty(newProperty);
    }

    @Override
    public PropertyDTO findProperty(Integer id) {
        return mapper.map(iPropertyRepository.findPropertyById(id),PropertyDTO.class);
    }
}
