package com.example.tucasita.service;

import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.repository.PropertyDAO;
import com.example.tucasita.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PropertyServiceImple implements PropertyService{

    @Autowired
    PropertyDAO propertyDAO;

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public ResponseDTO addOneProperty(PropertyDTO property) {
        propertyDAO.create(property);

        ResponseDTO response = new ResponseDTO(201, "La propiedad se ha agregado con éxito al repositorio local");

        return response;
    }

    @Override
    public Set<PropertyDTO> getAllProperties() {
        return this.propertyRepository.findAll();
    }
}
