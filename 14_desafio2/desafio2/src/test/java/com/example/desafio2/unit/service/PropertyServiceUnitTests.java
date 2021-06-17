package com.example.desafio2.unit.service;

import com.example.desafio2.TestUtils.TestUtils;
import com.example.desafio2.project.exceptions.PropertyAlreadyExistsException;
import com.example.desafio2.project.exceptions.PropertyDistrictNameNotFoundException;
import com.example.desafio2.project.exceptions.PropertyNameNotFoundException;
import com.example.desafio2.project.models.Environment;
import com.example.desafio2.project.models.Property;
import com.example.desafio2.project.repository.IPropertyRepository;
import com.example.desafio2.project.services.Dto.PropertyDto;
import com.example.desafio2.project.services.Dto.PropertyEnvironmentDto;
import com.example.desafio2.project.services.Dto.PropertyTotalSquareMetersDto;
import com.example.desafio2.project.services.IPropertyService;
import com.example.desafio2.project.services.PropertyService;
import com.example.desafio2.project.services.mapper.mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceUnitTests {

    @Mock
    IPropertyRepository iPropertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void getTotalSquareMetersHappyPath() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        Property property = TestUtils.getNewProperty(propertyName);
        double totalSquareMetersExpected = 300;
        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);

        //Act
        PropertyTotalSquareMetersDto response = propertyService.getTotalSquareMeters(propertyName);


        //Asserts
        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        Assertions.assertEquals(response.getTotalMeters(),totalSquareMetersExpected);
    }

    @Test
    public void getBiggestEnvironmentHappyPath() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        Property property = TestUtils.getNewProperty(propertyName);
        PropertyEnvironmentDto expected = new PropertyEnvironmentDto("Cocina",150);

        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);
        //Act
        PropertyEnvironmentDto response = this.propertyService.getBiggestEnvironment(property.getProp_name());

        //Assert
        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        Assertions.assertEquals(response,expected);
    }

    @Test
    public void getEnvironmentSizesListHappyPath() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        Property property = TestUtils.getNewProperty(propertyName);
        PropertyEnvironmentDto expected1 = new PropertyEnvironmentDto("Banio", 50);
        PropertyEnvironmentDto expected2 = new PropertyEnvironmentDto("Cocina", 150);
        PropertyEnvironmentDto expected3 = new PropertyEnvironmentDto("Living", 100);
        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);

        //Act
        ArrayList<PropertyEnvironmentDto> response = this.propertyService.getEnvironmentSizesList(propertyName);

        //Assert
        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        Assertions.assertEquals(response.get(0),expected1);
        Assertions.assertEquals(response.get(1),expected2);
        Assertions.assertEquals(response.get(2),expected3);
    }

}
