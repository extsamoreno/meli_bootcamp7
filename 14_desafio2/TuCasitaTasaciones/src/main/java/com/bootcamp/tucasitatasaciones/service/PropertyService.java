package com.bootcamp.tucasitatasaciones.service;

import com.bootcamp.tucasitatasaciones.DTO.PropertyDTO;
import com.bootcamp.tucasitatasaciones.exception.DistrictNotFoundException;
import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.repository.IDatatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IDatatRepository datatRepository;

    @Override
    public void registerProperty(PropertyDTO propertyDTO) throws DistrictNotFoundException {
        District district = datatRepository.findDistrictByName(propertyDTO.getDistrict().getName());
        if (district == null) {
            throw new DistrictNotFoundException(propertyDTO.getDistrict().getName());
        }

    }
}
