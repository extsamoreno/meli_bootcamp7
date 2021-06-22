package com.example.challenge_2.unit.controllers;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.controller.PropertyController;
import com.example.challenge_2.exception.DistrictException;
import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.exception.PropertyException;
import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.service.IPropertyService;
import com.example.challenge_2.service.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void createPropertyTest() throws DistrictException {
        //Arrange

        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();
        NewIdDTO newIdDTO = new NewIdDTO(1);

        when(propertyService.createProperty(propertyDTO)).thenReturn(newIdDTO);

        //Act
        ResponseEntity<NewIdDTO> result = propertyController.createProperty(propertyDTO);

        //Assert

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void createPropertyDistrictNotFoundTest() throws DistrictException {
        //Arrange

        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        when(propertyService.createProperty(propertyDTO)).thenThrow(DistrictNotFoundException.class);

        //Act

        //Assert

        assertThrows(DistrictNotFoundException.class, () -> propertyController.createProperty(propertyDTO));
    }

    @Test
    public void getSquareMetersTest() throws PropertyException {
        //Arrange

        SquareMetersDTO squareMetersDTO = new SquareMetersDTO(350);

        when(propertyService.getSquareMeters(1)).thenReturn(squareMetersDTO);

        //Act
        ResponseEntity<SquareMetersDTO> result = propertyController.getSquareMeters(1);

        //Assert

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getSquareMetersPropertyNotFoundTest() throws PropertyException {
        //Arrange

        when(propertyService.getSquareMeters(1)).thenThrow(PropertyNotFoundException.class);

        //Act

        //Assert

        assertThrows(PropertyNotFoundException.class, () -> propertyController.getSquareMeters(1));
    }

    @Test
    public void getPropertyPriceTest() throws PropertyException {
        //Arrange

        PropertyPriceDTO propertyPriceDTO = new PropertyPriceDTO(3500);

        when(propertyService.getPropertyPrice(1)).thenReturn(propertyPriceDTO);

        //Act
        ResponseEntity<PropertyPriceDTO> result = propertyController.getPropertyPrice(1);

        //Assert

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getPropertyPricePropertyNotFoundTest() throws PropertyException {
        //Arrange

        when(propertyService.getPropertyPrice(1)).thenThrow(PropertyNotFoundException.class);

        //Act

        //Assert

        assertThrows(PropertyNotFoundException.class, () -> propertyController.getPropertyPrice(1));
    }

    @Test
    public void getBiggestEnvironmentTest() throws PropertyException {
        //Arrange

        EnvironmentDTO environmentDTO = new EnvironmentDTO();

        when(propertyService.getBiggestEnvironment(1)).thenReturn(environmentDTO);

        //Act
        ResponseEntity<EnvironmentDTO> result = propertyController.getBiggestEnvironment(1);

        //Assert

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getBiggestEnvironmentPropertyNotFoundTest() throws PropertyException {
        //Arrange

        when(propertyService.getBiggestEnvironment(1)).thenThrow(PropertyNotFoundException.class);

        //Act

        //Assert

        assertThrows(PropertyNotFoundException.class, () -> propertyController.getBiggestEnvironment(1));
    }

    @Test
    public void getSquareMetersEachEnvironmentTest() throws PropertyException {
        //Arrange

        List<EnvironmentSquareMetersDTO> environmentSquareMetersDTOS = new ArrayList<>();

        when(propertyService.getSquareMetersEachEnvironment(1)).thenReturn(environmentSquareMetersDTOS);

        //Act
        ResponseEntity<List<EnvironmentSquareMetersDTO>> result = propertyController.getSquareMetersEachEnvironment(1);

        //Assert

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getSquareMetersEachEnvironmentPropertyNotFoundTest() throws PropertyException {
        //Arrange

        when(propertyService.getSquareMetersEachEnvironment(1)).thenThrow(PropertyNotFoundException.class);

        //Act

        //Assert

        assertThrows(PropertyNotFoundException.class, () -> propertyController.getSquareMetersEachEnvironment(1));
    }

}
