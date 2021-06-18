package com.meli.desafio2.unit;

import com.meli.desafio2.controller.PropertyController;
import com.meli.desafio2.exception.DistrictNotFoundException;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.dto.EnvironmentDTO;
import com.meli.desafio2.model.dto.PropertyDTO;
import com.meli.desafio2.service.PropertyService;
import com.meli.desafio2.util.TestUtilGenerator;
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
class PropertyControllerTest {

    @Mock
    PropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;


    @Test
    void saveProperty() throws DistrictNotFoundException {
        //Arrange
        Property property = TestUtilGenerator.getProperty();

        //Act
        ResponseEntity received = propertyController.saveProperty(property);

        //Assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).saveProperty(property);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    void calculateMts2() {
        //Arrange
        PropertyDTO expected = new PropertyDTO("Casa del Barba",131,0,null,null);
        Mockito.when(propertyService.calculateMts2()).thenReturn(expected);

        //Act
        ResponseEntity<PropertyDTO> received = propertyController.calculateMts2();

        //Assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).calculateMts2();
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    void calculatePrice() {
        //Arrange
        PropertyDTO expected = new PropertyDTO("Casa del Barba", 131, 39365.5, null ,null);
        Mockito.when(propertyService.calculatePrice()).thenReturn(expected);

        //Act
        ResponseEntity<PropertyDTO> received = propertyController.calculatePrice();

        //Assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).calculatePrice();
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    void obtainMostGreaterEnvironment() {
        //Arrange
        EnvironmentDTO environment = new EnvironmentDTO("Cocina",56);
        PropertyDTO expected = new PropertyDTO("Casa del Barba", 131, 0, environment, null);
        Mockito.when(propertyService.obtainMostGreaterEnvironment()).thenReturn(expected);

        //Act
        ResponseEntity<PropertyDTO> received = propertyController.obtainMostGreaterEnvironment();

        //Assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).obtainMostGreaterEnvironment();
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    void calculateEnvironmentMts2() {
        //Arrange
        PropertyDTO expected = new PropertyDTO("Casa del Barba", 131, 0, null, TestUtilGenerator.environmentDTOList());
        Mockito.when(propertyService.calculateEnvironmentMts2()).thenReturn(expected);

        //Act
        ResponseEntity<PropertyDTO> received = propertyController.calculateEnvironmentMts2();

        //Assert
        Mockito.verify(propertyService, Mockito.atLeastOnce()).calculateEnvironmentMts2();
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }
}