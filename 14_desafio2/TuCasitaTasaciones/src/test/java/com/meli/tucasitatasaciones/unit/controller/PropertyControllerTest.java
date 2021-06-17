package com.meli.tucasitatasaciones.unit.controller;

import com.meli.tucasitatasaciones.controller.PropertyController;
import com.meli.tucasitatasaciones.dto.PropertyDTO;
import com.meli.tucasitatasaciones.service.property.IPropertyService;
import com.meli.tucasitatasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void registerNewProperty() {
        //Arrange
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("Alto Alberdi");

        //Act
        ResponseEntity<?> received = propertyController.registerNewProperty(propertyDTO);

        //Asset
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).createProperty(propertyDTO);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    @Test
    public void getAllProperties() {
        //Arrange
        List<PropertyDTO> propertyDTOS = TestUtilGenerator.getPropertiesDTO();
        Mockito.when(iPropertyService.getAllProperties()).thenReturn(propertyDTOS);

        //Act
        ResponseEntity<?> received = propertyController.getAllProperties();

        //Asset
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).getAllProperties();
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(propertyDTOS,received.getBody());
    }
}
