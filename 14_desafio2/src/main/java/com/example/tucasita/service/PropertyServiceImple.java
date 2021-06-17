package com.example.tucasita.service;

import com.example.tucasita.exception.InvalidPropertyException;
import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.repository.DistrictDAO;
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

    @Autowired
    DistrictDAO districtDAO;

    @Override
    public ResponseDTO addOneProperty(PropertyDTO property) {
        if (districtDAO.findByName(property.getDistrictName()) != null) {
            propertyDAO.create(property);

            ResponseDTO response = new ResponseDTO(201, "La propiedad se ha agregado con éxito al repositorio local");

            return response;
        } else {
            throw new InvalidPropertyException(property.getDistrictName());
        }
    }

    @Override
    public Set<PropertyDTO> getAllProperties() {
        return this.propertyRepository.findAll();
    }
}
