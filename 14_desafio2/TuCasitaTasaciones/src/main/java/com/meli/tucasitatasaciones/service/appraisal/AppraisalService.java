package com.meli.tucasitatasaciones.service.appraisal;

import com.meli.tucasitatasaciones.dto.EnvironmentDTO;
import com.meli.tucasitatasaciones.dto.ResponseDTO;
import com.meli.tucasitatasaciones.exception.PropertyNotFoundException;
import com.meli.tucasitatasaciones.model.Environment;
import com.meli.tucasitatasaciones.model.Property;
import com.meli.tucasitatasaciones.repository.property.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppraisalService implements IAppraisalService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public ResponseDTO getPropertyTotalSquareMeters(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);

        if(property == null) {
            throw new PropertyNotFoundException(propertyId);
        }

        ResponseDTO response = new ResponseDTO();
        response.setTotalSquareMeters(this.calculateTotalSquareMeters(property.getEnvironments()));
        return response;
    }

    private Double calculateTotalSquareMeters(List<Environment> environments) {
        return environments.stream().mapToDouble(this::calculateSquareMeters).sum();
    }

    private double calculateSquareMeters(Environment environment) {
        return environment.getWidth() * environment.getLength();
    }

    @Override
    public ResponseDTO getPropertyValue(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);

        if(property == null) {
            throw new PropertyNotFoundException(propertyId);
        }

        Double propertyValue = calculateTotalSquareMeters(property.getEnvironments()) * property.getDistrict().getPrice();

        ResponseDTO response = new ResponseDTO();
        response.setPropertyValue(propertyValue);
        return response;
    }

    @Override
    public ResponseDTO getBiggestEnvironment(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);

        if(property == null) {
            throw new PropertyNotFoundException(propertyId);
        }

        EnvironmentDTO environmentDTO = findBiggestEnvironment(property.getEnvironments());

        ResponseDTO response = new ResponseDTO();
        response.setBiggestEnvironment(environmentDTO);
        return response;
    }

    private EnvironmentDTO findBiggestEnvironment(List<Environment> environments) {
        Optional<Environment> biggestEnv = environments.stream().max((env1, env2) -> (int) (calculateSquareMeters(env1) - (calculateSquareMeters(env2))));
        return biggestEnv.map(environment -> mapper.map(environment, EnvironmentDTO.class)).orElse(null);
    }

    @Override
    public ResponseDTO getEnvironmentsSquareMeters(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);

        if(property == null) {
            throw new PropertyNotFoundException(propertyId);
        }

        ResponseDTO response = new ResponseDTO();
        response.setEnvironmentsSquareMeters(getEnvironmentsDTO(property.getEnvironments()));
        return response;
    }

    private List<EnvironmentDTO> getEnvironmentsDTO(List<Environment> environments) {
        List<EnvironmentDTO> environmentDTOS = new ArrayList<>();
        for(Environment env : environments) {
            environmentDTOS.add(createEnvironmentDTO(env));
        }
        return environmentDTOS;
    }

    private EnvironmentDTO createEnvironmentDTO(Environment environment) {
        EnvironmentDTO environmentDTO = new EnvironmentDTO();
        environmentDTO.setName(environment.getName());
        environmentDTO.setSquareMeters(calculateSquareMeters(environment));
        return environmentDTO;
    }
}
