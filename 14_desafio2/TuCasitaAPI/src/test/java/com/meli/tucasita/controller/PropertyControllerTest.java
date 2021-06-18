package com.meli.tucasita.controller;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.model.District;
import com.meli.tucasita.model.Environment;
import com.meli.tucasita.model.Property;
import com.meli.tucasita.service.IPropertyService;
import com.meli.tucasita.service.dto.PropertyDTORequest;
import com.meli.tucasita.service.dto.PropertyWithPriceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void addANewValidProperty() throws DistrictNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        PropertyDTORequest propertyRequested= new PropertyDTORequest(propertyName, "Fontibon", new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        Mockito.when(iPropertyService.addNewProperty(propertyRequested)).thenReturn(HttpStatus.CREATED);
        // Act
        ResponseEntity<HttpStatus> received= propertyController.addNewProperty(propertyRequested);
        // Assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).addNewProperty(propertyRequested);
        Assertions.assertEquals(HttpStatus.CREATED,received.getStatusCode());
    }

    @Test
    public void addAPropertyWithUnknownDistrict() throws DistrictNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        PropertyDTORequest propertyRequested= new PropertyDTORequest(propertyName, "Fon", new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        Mockito.when(iPropertyService.addNewProperty(propertyRequested)).thenThrow(DistrictNotFoundException.class);
        // Act
        // Assert
        Mockito.verify(iPropertyService, Mockito.never()).addNewProperty(propertyRequested);
        Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyController.addNewProperty(propertyRequested));
    }

    @Test
    public void matchThePriceOfAnProperty() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        Property property= new Property(propertyName,new District("Fontibon",2000),new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        PropertyWithPriceDTO expected= new PropertyWithPriceDTO(propertyName,3332000);

        Mockito.when(iPropertyService.getPrice(propertyName)).thenReturn(expected);
        // Act
        ResponseEntity<PropertyWithPriceDTO> received= propertyController.getPrice(propertyName);
        // Assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getPrice(propertyName);
        Assertions.assertEquals(expected,received.getBody());
    }

    @Test
    public void matchThePriceOfAnUnknownProperty() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        Property property= new Property(propertyName+"xxxxx",new District("Fontibon",2000),new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));

        Mockito.when(iPropertyService.getPrice(propertyName)).thenThrow(PropertyNotFoundException.class);
        // Act
        // Assert
        Mockito.verify(iPropertyService, Mockito.never()).getPrice(propertyName);
        Assertions.assertThrows(PropertyNotFoundException.class, () -> propertyController.getPrice(propertyName));
    }
}
