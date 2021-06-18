package com.meli.desafio2.service;

import com.meli.desafio2.exception.DistrictNotFoundException;
import com.meli.desafio2.model.Environment;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.dto.EnvironmentDTO;
import com.meli.desafio2.model.dto.PropertyDTO;
import com.meli.desafio2.repository.DistrictRepository;
import com.meli.desafio2.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public void saveProperty(Property prop) throws DistrictNotFoundException {
        int id = prop.getDistrict().getId();
        if(districtRepository.findDistrictByID(id) == null)
            throw new DistrictNotFoundException(prop.getDistrict());

        propertyRepository.save(prop);
    }

    @Override
    public PropertyDTO calculateMts2(){
        PropertyDTO result = new PropertyDTO();
        Property prop = propertyRepository.getProperty();

        double mts2 = prop.getEnvironmentList().stream()
                .mapToDouble(value -> value.getEnvironment_length() * value.getEnvironment_width())
                .sum();

        result.setProp_name(prop.getProp_name());
        result.setProp_mts2(mts2);

        return result;
    }

    @Override
    public PropertyDTO calculatePrice() {
        PropertyDTO result = calculateMts2();
        Property prop = propertyRepository.getProperty();

        result.setProp_price(prop.getDistrict().getDistrict_price() * result.getProp_mts2());

        return result;
    }

    @Override
    public PropertyDTO obtainMostGreaterEnvironment() {
        PropertyDTO result = calculateMts2();
        Property prop = propertyRepository.getProperty();
        EnvironmentDTO environmentDTO = null;

        for (Environment e : prop.getEnvironmentList()){
            double auxMts2 = e.getEnvironment_length() * e.getEnvironment_width();

            if(environmentDTO == null || environmentDTO.getEnvironment_mts2() < auxMts2)
                environmentDTO = new EnvironmentDTO(e.getEnvironment_name(),auxMts2);

        }

        result.setProp_environment_most_great(environmentDTO);

        return result;
    }

    @Override
    public PropertyDTO calculateEnvironmentMts2() {
        PropertyDTO result = calculateMts2();
        Property prop = propertyRepository.getProperty();
        EnvironmentDTO environment;
        List<EnvironmentDTO> environmentList = new ArrayList<>();

        for(Environment e : prop.getEnvironmentList()){
            environment = new EnvironmentDTO();
            environment.setEnvironment_name(e.getEnvironment_name());
            environment.setEnvironment_mts2(e.getEnvironment_length() * e.getEnvironment_width());
            environmentList.add(environment);
        }

        result.setEnvironmentList(environmentList);

        return result;
    }


}
