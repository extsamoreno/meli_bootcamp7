package com.example.desafio2.unit.controller;

import com.example.desafio2.project.controllers.PropertyController;
import com.example.desafio2.project.exceptions.PropertyNameNotFoundException;
import com.example.desafio2.project.services.Dto.PropertyTotalSquareMetersDto;
import com.example.desafio2.project.services.IPropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerUnitTests {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void getTotalSquareMetersHappyPath() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        PropertyTotalSquareMetersDto propertyTotalSquareMetersDto = new PropertyTotalSquareMetersDto(30);
        when(iPropertyService.getTotalSquareMeters(propertyName)).thenReturn(propertyTotalSquareMetersDto);

        //Act
        ResponseEntity<PropertyTotalSquareMetersDto> response = propertyController.getTotalSquareMeters(propertyName);

        //Asserts
        verify(iPropertyService,atLeastOnce()).getTotalSquareMeters(propertyName);
        Assertions.assertEquals(response.getBody().getTotalMeters(),30);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


}
