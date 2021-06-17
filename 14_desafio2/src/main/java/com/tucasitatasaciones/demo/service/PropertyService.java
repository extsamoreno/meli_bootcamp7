package com.tucasitatasaciones.demo.service;

import com.tucasitatasaciones.demo.dto.*;
import com.tucasitatasaciones.demo.exception.BadRequestException;
import com.tucasitatasaciones.demo.models.District;
import com.tucasitatasaciones.demo.models.Property;
import com.tucasitatasaciones.demo.repository.IDistrictRepository;
import com.tucasitatasaciones.demo.repository.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    IDistrictRepository districtRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public PropertyDTO addProperty(PropertyDTO property) throws BadRequestException {
        District district = districtRepository.findDistrictById(property.getDistrictId());
        Property propertyExist = propertyRepository.findPropertyByName(property.getName());

        if(district == null)
            throw new BadRequestException("El id de barrio no corresponde a ningun barrio existente.");

        if(propertyExist != null)
            throw new BadRequestException("La propiedad que intenta crear ya existe.");

        propertyExist = mapper.map(property, Property.class);

        PropertyDTO propertyAdded = mapper.map(propertyRepository.addProperty(propertyExist), PropertyDTO.class);

        return propertyAdded;
    }

    @Override
    public PropertySquareMettersDTO calculateSquareMettersById(int id) throws BadRequestException {

        if(id <= 0)
            throw new BadRequestException("El id ingresado es invalido.");

        PropertyDTO property = mapper.map(propertyRepository.findPropertyById(id), PropertyDTO.class);

        if(property == null)
            throw new BadRequestException("La propiedad con el id " + id + " no existe.");

        PropertySquareMettersDTO propertySquareMetters = mapper.map(property, PropertySquareMettersDTO.class);

        propertySquareMetters.setSquareMetters(calculateSquareMettersList(property.getEnvironments()));

        return propertySquareMetters;

    }

    @Override
    public PropertyPriceDTO calculatePropertyPriceById(int id) throws BadRequestException {
        if(id <= 0)
            throw new BadRequestException("El id ingresado es invalido.");

        PropertyDTO property = mapper.map(propertyRepository.findPropertyById(id), PropertyDTO.class);

        if(property == null)
            throw new BadRequestException("La propiedad con el id " + id + " no existe.");

        DistrictDTO district = mapper.map(districtRepository.findDistrictById(property.getDistrictId()), DistrictDTO.class);

        double squareMetters = calculateSquareMettersList(property.getEnvironments());

        double price = squareMetters * district.getPrice();

        PropertyPriceDTO propertyPrice = mapper.map(property, PropertyPriceDTO.class);
        propertyPrice.setPrice(price);

        return propertyPrice;
    }

    @Override
    public PropertyBiggestEnvironmentDTO calculateBiggestEnvironmentById(int id) throws BadRequestException {
        if(id <= 0)
            throw new BadRequestException("El id ingresado es invalido.");

        PropertyDTO property = mapper.map(propertyRepository.findPropertyById(id), PropertyDTO.class);

        if(property == null)
            throw new BadRequestException("La propiedad con el id " + id + " no existe.");

        PropertyBiggestEnvironmentDTO biggestProperty = mapper.map(property, PropertyBiggestEnvironmentDTO.class);

        biggestProperty.setBiggestEnvironment(calculateBiggestEnvironment(property.getEnvironments()));

        return biggestProperty;
    }

    @Override
    public PropertyEnvironmentSquareMetterDTO calculateSquareMettersEnvironmentsById(int id) throws BadRequestException {
        if(id <= 0)
            throw new BadRequestException("El id ingresado es invalido.");

        PropertyDTO property = mapper.map(propertyRepository.findPropertyById(id), PropertyDTO.class);

        if(property == null)
            throw new BadRequestException("La propiedad con el id " + id + " no existe.");

        ArrayList<EnvironmentSquareMetterDTO> environments = new ArrayList<>();

        for (EnvironmentDTO environment : property.getEnvironments()) {
            EnvironmentSquareMetterDTO environmentSquare = mapper.map(environment, EnvironmentSquareMetterDTO.class);
            double squareMetters = calculateSquareMettersByEnvironment(environment);
            environmentSquare.setSquareMetters(squareMetters);
            environments.add(environmentSquare);
        }
        PropertyEnvironmentSquareMetterDTO propertyEnvironmentDTO = mapper.map(property, PropertyEnvironmentSquareMetterDTO.class);
        propertyEnvironmentDTO.setEnvironments(environments);

        return propertyEnvironmentDTO;
    }

    private EnvironmentDTO calculateBiggestEnvironment(List<EnvironmentDTO> environments){
        EnvironmentDTO biggest = environments.get(0);
        double maxRoom = calculateSquareMettersByEnvironment(biggest);
        for (int i = 1; i < environments.size(); i++) {
            double squareMetters = calculateSquareMettersByEnvironment(environments.get(i));
            if(squareMetters > maxRoom){
                maxRoom = squareMetters;
                biggest = environments.get(i);
            }
        }
        return biggest;
    }

    private double calculateSquareMettersList(List<EnvironmentDTO> environments){
        double squareMetters = 0;
        for (EnvironmentDTO environment: environments) {
            squareMetters += calculateSquareMettersByEnvironment(environment);
        }
        return squareMetters;
    }

    private double calculateSquareMettersByEnvironment(EnvironmentDTO environment){

        return environment.getLength() * environment.getWidth();
    }

}
