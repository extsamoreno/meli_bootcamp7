package com.meli.tucasita.service;

import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.model.Environment;
import com.meli.tucasita.model.Property;
import com.meli.tucasita.repository.IPropertyRepository;
import com.meli.tucasita.service.dto.PropertyWithM2DTO;
import com.meli.tucasita.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public PropertyWithM2DTO getTotalM2(String name) throws PropertyNotFoundException {
        Property p= iPropertyRepository.getPropertyByName(name);
        List<Environment> environments= p.getEnvironments();
        double totalM2= environments.stream().mapToDouble(environment -> environment.getWidth() * environment.getLength()).sum();
        return Mapper.toPropertyWithM2(p,totalM2);
    }
}
