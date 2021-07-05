package com.example.demo.unit.services;

import com.example.demo.Utils.Utils;
import com.example.demo.dtos.*;
import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.Property;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.repositories.PropertyRepository;
import com.example.demo.services.PropertyServiceImple;
import com.example.demo.services.mappers.MapperEnviroment;
import com.example.demo.services.mappers.MapperProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    MapperProperty mapperProperty;

    @Mock
    MapperEnviroment mapperEnviroment;

    @Mock
    PropertyRepository propertyRepository;
    @Mock
    DistrictRepository districtRepository;
    @InjectMocks
    PropertyServiceImple propertyServiceImple;


    @Test
    public void getSquareMetersHappyPath() throws PropertyDontFoundException {

        //arr
        Property property = Utils.getProperty();

        int id =1;
        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);
        PropertyM2ResponseDTO propertyM2ResponseDTO = new PropertyM2ResponseDTO();
        propertyM2ResponseDTO.setProp_name(property.getProp_name());
        Mockito.when(mapperProperty.toPropertyM2ResponseDTO(property)).thenReturn(propertyM2ResponseDTO);
        double expected = 148d;

        //act
        PropertyM2ResponseDTO received = propertyServiceImple.getMeterSquare(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).findPropertyById(id);
        Mockito.verify(mapperProperty, Mockito.atLeastOnce()).toPropertyM2ResponseDTO(property);
        Assertions.assertEquals(expected,received.getProp_square_meters());

    }

    @Test
    public void getPriceHappyPath() throws PropertyDontFoundException {

        //arrange
        Property property = Utils.getProperty();

        int id = 1;
        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);
        PropertyPriceResponseDTO propertyPriceResponseDTO = new PropertyPriceResponseDTO();
        propertyPriceResponseDTO.setProp_name(property.getProp_name());
        Mockito.when(mapperProperty.toPropertyPriceResponseDTO(property)).thenReturn(propertyPriceResponseDTO);
        double expected = 74000d;

        //act
        PropertyPriceResponseDTO received = propertyServiceImple.getPrice(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).findPropertyById(id);
        Mockito.verify(mapperProperty, Mockito.atLeastOnce()).toPropertyPriceResponseDTO(property);
        Assertions.assertEquals(expected,received.getProp_price());

    }

    @Test
    public void getBiggestEnvPropHappyPath() throws PropertyDontFoundException {

        //arrange
        Property property = Utils.getProperty();

        int id = 1;
        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);
        BiggestPropResponseDTO biggestPropResponseDTO = new BiggestPropResponseDTO();
        biggestPropResponseDTO.setProp_name(property.getProp_name());
        Mockito.when(mapperProperty.toBiggestPropResponseDTO(property)).thenReturn(biggestPropResponseDTO);
        BiggestEnvironmentDTO expected = new BiggestEnvironmentDTO("Environment3",56d);

        //act
        BiggestPropResponseDTO received = propertyServiceImple.getBiggestEnvProp(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).findPropertyById(id);
        Mockito.verify(mapperProperty, Mockito.atLeastOnce()).toBiggestPropResponseDTO(property);
        Assertions.assertEquals(expected,received.getBiggestEnvironment());
    }

    @Test
    public void getSquareMetersEnvHappyPath() throws PropertyDontFoundException {

        //arrange
        Property property = Utils.getProperty();
        int id = 1;
        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);
        PropertyM2EnvsResponseDTO propertyM2EnvsResponseDTO = new PropertyM2EnvsResponseDTO();
        propertyM2EnvsResponseDTO.setProp_name(property.getProp_name());
        Mockito.when(mapperProperty.toPropertyM2EnvsDTO(property)).thenReturn(propertyM2EnvsResponseDTO);
        List<EnvironmentM2DTO> expected = Utils.getSquareMetersEnvListDTO();


        //act
        PropertyM2EnvsResponseDTO received = propertyServiceImple.getMeterSquareEnvs(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).findPropertyById(id);
        Mockito.verify(mapperProperty,Mockito.atLeastOnce()).toPropertyM2EnvsDTO(property);
        Assertions.assertEquals(expected,received.getEnviroments());

    }

    @Test
    public void findPropertyByIdHappyPath() throws PropertyDontFoundException {

        //arrange
        Property expected = Utils.getProperty();
        int id = 1;
        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(expected);

        //act
        Property received = propertyServiceImple.findPropertyById(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).findPropertyById(id);
        Assertions.assertEquals(expected,received);

    }

    @Test
    public void addPropertyHappyPath() throws DistrictDontFoundException {

        //arrange
        Property property = Utils.getProperty();
        PropertyRequestDTO expected = Utils.getPropertyRequestDTO();
        DistrictDTO districtDTO = Utils.getDistrictDTO();
        int idDistrict = 1;
        Mockito.when(districtRepository.findDistrictById(idDistrict)).thenReturn(districtDTO);
        Mockito.when(mapperProperty.toProperty(expected)).thenReturn(property);
        Mockito.when(propertyRepository.addProperty(property)).thenReturn(property);
        Mockito.when(mapperProperty.toPropertyDTO(property)).thenReturn(expected);

        //act
        PropertyRequestDTO received = propertyServiceImple.addProperty(expected);

        //assert
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findDistrictById(idDistrict);
        Mockito.verify(mapperProperty,Mockito.atLeastOnce()).toProperty(expected);
        Mockito.verify(propertyRepository,Mockito.atLeastOnce()).addProperty(property);
        Mockito.verify(mapperProperty,Mockito.atLeastOnce()).toPropertyDTO(property);
        Assertions.assertEquals(expected,received);
    }

}
