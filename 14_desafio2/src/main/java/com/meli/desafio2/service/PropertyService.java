package com.meli.desafio2.service;

import com.meli.desafio2.dto.ResponsePropTotalM2;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.model.Environment;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository propertyRepository;

    // Calculate property total M2
    @Override
    public ResponsePropTotalM2 calcTotalM2(Integer propId) throws PropertyIdNotFoundException {

        Property prop = propertyRepository.getPropertybyId(propId);
        double totalM2 = 0;

        for (Environment env : prop.getEnvironments()) {
            totalM2 += calcRoomM2(env);
        }
        return new ResponsePropTotalM2(prop.getId(), prop.getName(), totalM2);
    }

    // Calculate environment M2
    private Double calcRoomM2(Environment env) {
        return env.getLength() * env.getWidth();
    }
}
