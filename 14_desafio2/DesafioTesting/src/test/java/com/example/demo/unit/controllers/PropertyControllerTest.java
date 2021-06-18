package com.example.demo.unit.controllers;

import com.example.demo.Utils;
import com.example.demo.controllers.PropertyController;
import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.Property;
import com.example.demo.services.PropertyService;
import com.example.demo.dtos.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    PropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void getSquareMetersHappyPath() throws PropertyDontFoundException {

        //arr
        PropertyM2ResponseDTO expected = Utils.getPropertyM2ResponseDTO();
        int id =1;
        Mockito.when(propertyService.getMeterSquare(id)).thenReturn(expected);
        HttpStatus statusExpected = HttpStatus.OK;

        //act
        ResponseEntity<?> received = propertyController.getSquareMeters(id);
        PropertyM2ResponseDTO receivedBody = (PropertyM2ResponseDTO) received.getBody();

        //assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).getMeterSquare(id);
        HttpStatus statusReceived = received.getStatusCode();
        Assertions.assertEquals(expected,receivedBody);
        Assertions.assertEquals(statusExpected, statusReceived);
    }

    @Test
    public void getPriceHappyPath() throws PropertyDontFoundException {

        //arrange
        PropertyPriceResponseDTO expected = Utils.getPropertyPriceResponseDTO();
        int id = 1;
        Mockito.when(propertyService.getPrice(id)).thenReturn(expected);
        HttpStatus statusExpected = HttpStatus.OK;

        //act
        ResponseEntity<?> received = propertyController.getPrice(id);
        PropertyPriceResponseDTO receivedBody = (PropertyPriceResponseDTO) received.getBody();

        //assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).getPrice(id);
        HttpStatus statusReceived = received.getStatusCode();
        Assertions.assertEquals(expected,receivedBody);
        Assertions.assertEquals(statusExpected, statusReceived);

    }

    @Test
    public void getBiggestEnvPropTest() throws PropertyDontFoundException {

        //arrange
        BiggestPropResponseDTO expected = Utils.getBiggestEnvPropDTO();
        int id = 1;
        Mockito.when(propertyService.getBiggestEnvProp(id)).thenReturn(expected);
        HttpStatus statusExpected = HttpStatus.OK;

        //act
        ResponseEntity<?> received = propertyController.getBiggestEnvProp(id);
        BiggestPropResponseDTO receivedBody = (BiggestPropResponseDTO) received.getBody();

        //assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).getBiggestEnvProp(id);
        HttpStatus statusReceived = received.getStatusCode();
        Assertions.assertEquals(expected,receivedBody);
        Assertions.assertEquals(statusExpected, statusReceived);
    }

    @Test
    public void getSquareMetersEnv() throws PropertyDontFoundException {

        //arrange
        PropertyM2EnvsResponseDTO expected = Utils.getSquareMetersEnvDTO();
        int id = 1;
        Mockito.when(propertyService.getMeterSquareEnvs(id)).thenReturn(expected);
        HttpStatus statusExpected = HttpStatus.OK;

        //act
        ResponseEntity<?> received = propertyController.getSquareMetersEnv(id);
        PropertyM2EnvsResponseDTO receivedBody = (PropertyM2EnvsResponseDTO) received.getBody();

        //assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).getMeterSquareEnvs(id);
        HttpStatus statusReceived = received.getStatusCode();
        Assertions.assertEquals(expected,receivedBody);
        Assertions.assertEquals(statusExpected, statusReceived);
    }

    @Test
    public void findPropertyByIdHappyPath() throws PropertyDontFoundException {
        //arrange
        Property expected = Utils.getProperty();
        int id = 1;
        Mockito.when(propertyService.findPropertyById(id)).thenReturn(expected);

        //act
        ResponseEntity receivedR = propertyController.findPropertyById(id);
        Property received = (Property) receivedR.getBody();


        //assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).findPropertyById(id);
        Assertions.assertEquals(expected,received);

    }

    @Test
    public void addPropertyHappyPath() throws DistrictDontFoundException {
        //arrange
        PropertyRequestDTO expected = Utils.getPropertyRequestDTO();
        Mockito.when(propertyService.addProperty(expected)).thenReturn(expected);

        //act
        ResponseEntity receivedR = propertyController.addProperty(expected);
        PropertyRequestDTO received = (PropertyRequestDTO) receivedR.getBody();
        //assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).addProperty(expected);
        Assertions.assertEquals(expected,received);
    }

}
