package com.example.tucasita.service;

import com.example.tucasita.exception.InvalidPropertyException;
import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.model.EnvironmentDTO;
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
    public ResponseDTO calculatePropertyTotalSquareMeters(int idProperty) {
        PropertyDTO property = propertyDAO.findById(idProperty);
        Double totalSquareMeters = 0.00;

        for (int i = 0; i < property.getEnvironments().size(); i++) {
            EnvironmentDTO environment = property.getEnvironments().get(i);

            Double environmentSquareMeters = environment.getEnvironmentLength() * environment.getEvironmentWidth();
            totalSquareMeters = totalSquareMeters + environmentSquareMeters;
        }

        ResponseDTO response = new ResponseDTO(200, "La propiedad con ID " + idProperty + " tiene un total de " + totalSquareMeters + " metros cuadrados.");

        return response;
    }

    @Override
    public ResponseDTO calculatePropertyPrice(int idProperty){
        PropertyDTO property = propertyDAO.findById(idProperty);
        DistrictDTO district = districtDAO.findByName(property.getDistrictName());
        Double totalSquareMeters = 0.00;
        Double price;

        for (int i = 0; i < property.getEnvironments().size(); i++) {
            EnvironmentDTO environment = property.getEnvironments().get(i);

            Double environmentSquareMeters = environment.getEnvironmentLength() * environment.getEvironmentWidth();
            totalSquareMeters = totalSquareMeters + environmentSquareMeters;
        }

        price = totalSquareMeters * district.getDistrictPrize();

        ResponseDTO response = new ResponseDTO(200, "La propiedad con ID " + idProperty + " tiene un valor de " + price + " U$S.");

        return response;
    }

    @Override
    public ResponseDTO getBiggestEnvironment(int idProperty){
        PropertyDTO property = propertyDAO.findById(idProperty);
        String biggestEnvironmentName = "";
        Double environmentSquareMeters = 0.00;

        for (int i = 0; i < property.getEnvironments().size(); i++) {
            EnvironmentDTO environment = property.getEnvironments().get(i);

            if(environment.getEnvironmentLength() * environment.getEvironmentWidth() > environmentSquareMeters){
                environmentSquareMeters = environment.getEnvironmentLength() * environment.getEvironmentWidth();
                biggestEnvironmentName = environment.getEnvironmentName();
            }
        }

        ResponseDTO response = new ResponseDTO(200, "El ambiente más grande de la propiedad con ID " + idProperty + " es el ambiente " + biggestEnvironmentName + " con un total de " + environmentSquareMeters + " metros cuadrados.");

        return response;
    }

    @Override
    public Set<PropertyDTO> getAllProperties() {
        return this.propertyRepository.findAll();
    }
}
