package com.example.tucasita.service;

import com.example.tucasita.exception.InvalidPropertyException;
import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.EnvironmentDTO;
import com.example.tucasita.dto.PropertyDTO;
import com.example.tucasita.dto.ResponseDTO;
import com.example.tucasita.model.District;
import com.example.tucasita.model.Environment;
import com.example.tucasita.model.Property;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.repository.PropertyDAO;
import com.example.tucasita.repository.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImple implements PropertyService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PropertyDAO propertyDAO;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    DistrictDAO districtDAO;

    @Override
    public ResponseDTO addOneProperty(PropertyDTO propertyDTO) {
        if (districtDAO.findByName(propertyDTO.getDistrictName()) != null) {
            Property property = modelMapper.map(propertyDTO, Property.class);
            propertyDAO.create(property);

            ResponseDTO response = new ResponseDTO(201, "La propiedad se ha agregado con éxito al repositorio local");

            return response;
        } else {
            throw new InvalidPropertyException(propertyDTO.getDistrictName());
        }
    }

    @Override
    public ResponseDTO calculatePropertyTotalSquareMeters(int idProperty) {
        Property property = propertyDAO.findById(idProperty);
        PropertyDTO propertyDTO = modelMapper.map(property, PropertyDTO.class);
        Double totalSquareMeters = 0.00;

        for (int i = 0; i < propertyDTO.getEnvironments().size(); i++) {
            Environment environment = property.getEnvironments().get(i);
            EnvironmentDTO environmentDTO = modelMapper.map(environment, EnvironmentDTO.class);

            Double environmentSquareMeters = environmentDTO.getEnvironmentLength() * environmentDTO.getEvironmentWidth();
            totalSquareMeters = totalSquareMeters + environmentSquareMeters;
        }

        ResponseDTO response = new ResponseDTO(200, "La propiedad con ID " + idProperty + " tiene un total de " + totalSquareMeters + " metros cuadrados.");

        return response;
    }

    @Override
    public ResponseDTO calculatePropertyPrice(int idProperty){
        Property property = propertyDAO.findById(idProperty);
        PropertyDTO propertyDTO = modelMapper.map(property, PropertyDTO.class);
        District district = districtDAO.findByName(property.getDistrictName());
        DistrictDTO districtDTO = modelMapper.map(district, DistrictDTO.class);
        Double totalSquareMeters = 0.00;
        Double price;

        for (int i = 0; i < propertyDTO.getEnvironments().size(); i++) {
            Environment environment = property.getEnvironments().get(i);
            EnvironmentDTO environmentDTO = modelMapper.map(environment, EnvironmentDTO.class);

            Double environmentSquareMeters = environmentDTO.getEnvironmentLength() * environmentDTO.getEvironmentWidth();
            totalSquareMeters = totalSquareMeters + environmentSquareMeters;
        }

        price = totalSquareMeters * districtDTO.getDistrictPrize();

        ResponseDTO response = new ResponseDTO(200, "La propiedad con ID " + idProperty + " tiene un valor de " + price + " U$S.");

        return response;
    }

    @Override
    public ResponseDTO getBiggestEnvironment(int idProperty){
        Property property = propertyDAO.findById(idProperty);
        PropertyDTO propertyDTO = modelMapper.map(property, PropertyDTO.class);
        String biggestEnvironmentName = "";
        Double environmentSquareMeters = 0.00;

        for (int i = 0; i < propertyDTO.getEnvironments().size(); i++) {
            Environment environment = property.getEnvironments().get(i);
            EnvironmentDTO environmentDTO = modelMapper.map(environment, EnvironmentDTO.class);

            if(environmentDTO.getEnvironmentLength() * environmentDTO.getEvironmentWidth() > environmentSquareMeters){
                environmentSquareMeters = environmentDTO.getEnvironmentLength() * environmentDTO.getEvironmentWidth();
                biggestEnvironmentName = environmentDTO.getEnvironmentName();
            }
        }

        ResponseDTO response = new ResponseDTO(200, "El ambiente más grande de la propiedad con ID " + idProperty + " es el ambiente " + biggestEnvironmentName + " con un total de " + environmentSquareMeters + " metros cuadrados.");

        return response;
    }

    @Override
    public List<EnvironmentDTO> calculateEnvironmentsSquareMeters(int idProperty){
        Property property = propertyDAO.findById(idProperty);
        PropertyDTO propertyDTO = modelMapper.map(property, PropertyDTO.class);
        List<EnvironmentDTO> environments = new ArrayList<>();

        for (int i = 0; i < propertyDTO.getEnvironments().size(); i++) {
            Environment environment = property.getEnvironments().get(i);
            EnvironmentDTO environmentDTO = modelMapper.map(environment, EnvironmentDTO.class);

            Double environmentSquareMeters = environmentDTO.getEnvironmentLength() * environmentDTO.getEvironmentWidth();
            environmentDTO.setSquareMeters(environmentSquareMeters);
            environments.add(environmentDTO);
        }

        return environments;
    }
}
