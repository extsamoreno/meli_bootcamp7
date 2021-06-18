package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.PropertyDTO;
import com.didney.junit.tucasitatasaciones.dto.response.EnvironmentDTOResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalSquareMeterByEnvironmentResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalSquareMeterPropertyDTOResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalValuePropertyByEnvironmentDTOResponse;
import com.didney.junit.tucasitatasaciones.mapper.EnvironmentMapper;
import com.didney.junit.tucasitatasaciones.mapper.PropertyMapper;
import com.didney.junit.tucasitatasaciones.repository.IPropertyRepository;
import com.didney.junit.tucasitatasaciones.util.PropertyUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PropertyService implements IPropertyService {

    IPropertyRepository propertyRepository;
    PropertyUtil propertyUtil;
    EnvironmentMapper environmentMapper;
    PropertyMapper propertyMapper;

    public PropertyService(IPropertyRepository propertyRepository,
                           PropertyUtil propertyUtil,
                           EnvironmentMapper environmentMapper,
                           PropertyMapper propertyMapper

    ) {
        this.propertyRepository = propertyRepository;
        this.propertyUtil = propertyUtil;
        this.environmentMapper = environmentMapper;
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }

    //US-0001 Calcular el total de metros cuadrados de la propiedad
    @Override
    public TotalSquareMeterPropertyDTOResponse getTotalSquareMeterProperty(int id) {
        return new TotalSquareMeterPropertyDTOResponse(HttpStatus.OK, propertyUtil.getTotalMeterSquare(propertyRepository.getPropertyById(id)));
    }

    //US-0002 Indicar el valor de una propiedad a partir de sus ambientes y medidas **Precio según Barrio
    @Override
    public TotalValuePropertyByEnvironmentDTOResponse getTotalValuePropertyByEnvironment(int id) {
        return new TotalValuePropertyByEnvironmentDTOResponse(HttpStatus.OK, propertyUtil.getTotalValueProperty(propertyRepository.getPropertyById(id)));
    }

    //US-0003 Determinar el ambiente mas grande -- de la propiedad
    @Override
    public EnvironmentDTOResponse getBiggerEnvironment(int id) {
        return new EnvironmentDTOResponse(HttpStatus.OK, environmentMapper.environmentToListEnvironmentDTO(propertyUtil.getBiggerEnvironment(propertyRepository.getPropertyById(id))));
    }

    @Override
    public TotalSquareMeterByEnvironmentResponse getTotalSquareMeterByEnvironment(int id) {
        return new TotalSquareMeterByEnvironmentResponse(HttpStatus.OK, propertyUtil.getEnvironmentSquareMeter(propertyRepository.getPropertyById(id)));
    }

    @Override
    public PropertyDTO addProperty(PropertyDTO propertyDTO) {
        return propertyMapper.propertyToPropertyDTO(propertyRepository.addProperty(propertyMapper.propertyDTOToProperty(propertyDTO)));
    }

    @Override
    public List<PropertyDTO> addProperties(List<PropertyDTO> propertyDTOList) {
        List<PropertyDTO> response = new ArrayList<>();
        for (PropertyDTO obj : propertyDTOList) {
            response.add(addProperty(obj));
        }
        return response;
    }

    @Override
    public List<PropertyDTO> getPropertiesList() {
        return propertyMapper.propertyToPropertyDTO( propertyRepository.getProperties());
    }
}
