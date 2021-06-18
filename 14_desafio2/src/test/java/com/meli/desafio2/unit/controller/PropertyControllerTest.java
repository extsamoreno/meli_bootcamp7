package com.meli.desafio2.unit.controller;

import com.meli.desafio2.unit.Utils;
import com.meli.desafio2.web.controller.PropertyController;
import com.meli.desafio2.web.dto.request.PropertyDTO;
import com.meli.desafio2.web.exception.DistrictNotFoundException;
import com.meli.desafio2.web.exception.PropertyAlreadyExistException;
import com.meli.desafio2.web.exception.PropertyNameNotFoundException;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.response.BiggestEnvironmentResponse;
import com.meli.desafio2.web.response.PropertyValueResponse;
import com.meli.desafio2.web.response.SquareMetersEnvironmentResponse;
import com.meli.desafio2.web.response.SquareMetersResponse;
import com.meli.desafio2.web.service.IPropertyService;
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
    IPropertyService iPropertyService;
    @InjectMocks
    PropertyController propertyController;

    PropertyDTO propertyDTO = Utils.initValidPropertyDTO();
    String name = propertyDTO.getProp_name();

    @Test
    public void getBiggestEnvironmentHappyPath() throws PropertyNameNotFoundException {
        //arrange
        BiggestEnvironmentResponse expectedBody = Utils.getBiggestEnvironment();
        Mockito.when(iPropertyService.getBiggestEnvironment(name)).thenReturn(expectedBody);

        //act
        ResponseEntity<BiggestEnvironmentResponse> response = propertyController.getBiggestEnvironment(name);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).getBiggestEnvironment(name);
        Assertions.assertEquals(expectedBody,response.getBody());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());

    }
    @Test
    public void getPropertyValueHappyPath() throws PropertyNameNotFoundException {
        //arrange
        PropertyValueResponse expectedBody = Utils.getPropertyValue();
        Mockito.when(iPropertyService.getValue(name)).thenReturn(expectedBody);

        //act
        ResponseEntity<PropertyValueResponse> response = propertyController.getPropertyValue(name);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).getValue(name);
        Assertions.assertEquals(expectedBody,response.getBody());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    public void getPropertySquareMetersHappyPath() throws PropertyNameNotFoundException {
        //arrange
        SquareMetersResponse expectedBody = Utils.getSquareMetersResponse();
        Mockito.when(iPropertyService.getSquareMeters(name)).thenReturn(expectedBody);

        //act
        ResponseEntity<SquareMetersResponse> response = propertyController.getPropertySquareMeters(name);

        //assert

        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).getSquareMeters(name);
        Assertions.assertEquals(expectedBody,response.getBody());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void getEnvironmentSquareMetersHappyPath() throws PropertyNameNotFoundException {
        //arrange
        SquareMetersEnvironmentResponse expectedBody = Utils.getEnvironmentSquareMeters();
        Mockito.when(iPropertyService.getEnvironmentSquareMeters(name)).thenReturn(expectedBody);

        //act
        ResponseEntity<SquareMetersEnvironmentResponse> response = propertyController.getEnvironmentsSquareMeters(name);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).getEnvironmentSquareMeters(name);
        Assertions.assertEquals(expectedBody,response.getBody());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void addPropertyHappyPath() throws PropertyAlreadyExistException, DistrictNotFoundException {
        //arrange
        Mockito.doNothing().when(iPropertyService).addProperty(propertyDTO);

        //act
        ResponseEntity<?> response = propertyController.addProperty(propertyDTO);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).addProperty(propertyDTO);
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
    }
}
