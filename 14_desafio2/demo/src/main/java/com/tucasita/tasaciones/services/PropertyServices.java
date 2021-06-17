package com.tucasita.tasaciones.services;

import com.tucasita.tasaciones.DTO.PropertyDTO;
import com.tucasita.tasaciones.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServices implements IPropertyServices{

    @Autowired
    IPropertyRepository propertyRepository;

    @Override
    public PropertyDTO calculateSquareMeter(Integer id) {
        PropertyDTO property = propertyRepository.findPropertyById(id);
        return null;
    }
}
