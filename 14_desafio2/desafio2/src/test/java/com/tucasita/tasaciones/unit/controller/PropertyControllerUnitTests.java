package com.tucasita.tasaciones.unit.controller;

import com.tucasita.tasaciones.project.controllers.PropertyController;
import com.tucasita.tasaciones.project.exceptions.PropertyDistrictNameNotFoundException;
import com.tucasita.tasaciones.project.exceptions.PropertyNameNotFoundException;
import com.tucasita.tasaciones.project.services.Dto.PropertyEnvironmentDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyTotalSquareMetersDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyValueDto;
import com.tucasita.tasaciones.project.services.IPropertyService;
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

    @Test
    public void getPropertyValueHappyPath() throws PropertyNameNotFoundException, PropertyDistrictNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        PropertyValueDto propertyValueDto = new PropertyValueDto(300000);
        when(iPropertyService.getPropertyValue(propertyName)).thenReturn(propertyValueDto);

        //Act
        ResponseEntity<PropertyValueDto> response = propertyController.getPropertyValue(propertyName);

        //Asserts
        verify(iPropertyService,atLeastOnce()).getPropertyValue(propertyName);
        Assertions.assertEquals(response.getBody().getProperty_value(),300000);
        Assertions.assertEquals(response.getStatusCode(),HttpStatus.OK);
    }



    @Test
    public void getBiggestEnvironmentHappyPath() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        PropertyEnvironmentDto propertyEnvironmentDto = new PropertyEnvironmentDto("Cocina",150);
        when(iPropertyService.getBiggestEnvironment(propertyName)).thenReturn(propertyEnvironmentDto);

        //Act
        ResponseEntity<PropertyEnvironmentDto> response = propertyController.getBiggestEnvironment(propertyName);

        //Asserts
        verify(iPropertyService,atLeastOnce()).getBiggestEnvironment(propertyName);
        Assertions.assertEquals(response.getBody().getEnvironment_name(),"Cocina");
        Assertions.assertEquals(response.getBody().getEnvironment_size(),150);
        Assertions.assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

}
