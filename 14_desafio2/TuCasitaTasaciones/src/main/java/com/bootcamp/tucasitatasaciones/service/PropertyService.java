package com.bootcamp.tucasitatasaciones.service;

import com.bootcamp.tucasitatasaciones.DTO.*;
import com.bootcamp.tucasitatasaciones.exception.NotFoundException;
import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.model.Environment;
import com.bootcamp.tucasitatasaciones.model.Property;
import com.bootcamp.tucasitatasaciones.repository.IDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IDataRepository dataRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public void registerProperty(PropertyDTO propertyDTO) throws NotFoundException {
        District district = dataRepository.findDistrictByName(propertyDTO.getDistrict().getName());
        if (district == null) {
            throw new NotFoundException("Barrio " + propertyDTO.getDistrict().getName() + " no encontrado");
        }

        Property property = mapper.map(propertyDTO, Property.class);
        property.setDistrictId(district.getId());

        dataRepository.saveProperty(property);
    }

    @Override
    public TotalSquareMetersDTO getTotalSquareMeters(Long propertyId) throws NotFoundException {
        Property property = dataRepository.findPropertyById(propertyId);
        if (property == null) {
            throw new NotFoundException("Propiedad con id " + propertyId + " no encontrada." );
        }

        return new TotalSquareMetersDTO(property.getName(), calculateTotalSquareMeters(property));
    }

    @Override
    public PropertyAppraisalDTO appraiseProperty(Long propertyId) throws NotFoundException {
        Property property = dataRepository.findPropertyById(propertyId);
        if (property == null) {
            throw new NotFoundException("Propiedad con id " + propertyId + " no encontrada." );
        }

        District district = dataRepository.findDistrictById(property.getDistrictId());

        return new PropertyAppraisalDTO(property.getName(),
                calculateTotalSquareMeters(property) * district.getPrice());
    }

    @Override
    public EnvironmentDTO getBiggestEnvironment(Long propertyId) throws NotFoundException {
        Property property = dataRepository.findPropertyById(propertyId);
        if (property == null) {
            throw new NotFoundException("Propiedad con id " + propertyId + " no encontrada." );
        }

        Environment biggestEnvironment = property.getEnvironments()
                .stream()
                .max(Comparator.comparing(this::calculateSquareMeters))
                .get();

        return mapper.map(biggestEnvironment, EnvironmentDTO.class);
    }

    @Override
    public List<EnvironmentWithSquareMetersDTO> getAllEnvironmentsWithSquareMeters(Long propertyId) throws NotFoundException {
        Property property = dataRepository.findPropertyById(propertyId);
        if (property == null) {
            throw new NotFoundException("Propiedad con id " + propertyId + " no encontrada." );
        }

        return property.getEnvironments()
                .stream()
                .map(env -> new EnvironmentWithSquareMetersDTO(env.getName(), calculateSquareMeters(env)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Property> getAllProperties() {
        return dataRepository.getAllProperties();
    }

    private Double calculateTotalSquareMeters(Property property) {
        return property
                .getEnvironments()
                .stream()
                .mapToDouble(env -> calculateSquareMeters(env))
                .sum();
    }

    private Double calculateSquareMeters(Environment environment) {
        return environment.getLength() * environment.getWidth();
    }
}
