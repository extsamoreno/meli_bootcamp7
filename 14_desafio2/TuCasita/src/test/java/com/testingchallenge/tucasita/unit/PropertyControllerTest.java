package com.testingchallenge.tucasita.unit;

import com.testingchallenge.tucasita.controller.PropertyController;
import com.testingchallenge.tucasita.dto.PropertyReqDTO;
import com.testingchallenge.tucasita.dto.PropertyValueDTO;
import com.testingchallenge.tucasita.exception.NeighborhoodNotFoundException;
import com.testingchallenge.tucasita.exception.PropertyNotFoundException;
import com.testingchallenge.tucasita.model.Neighborhood;
import com.testingchallenge.tucasita.model.Property;
import com.testingchallenge.tucasita.model.Room;
import com.testingchallenge.tucasita.service.iPropertyService;
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
    iPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void addPropertyOK() throws NeighborhoodNotFoundException {

        // arrange
        String propertyName = "Casa de Diego";
        PropertyReqDTO expected = new PropertyReqDTO(
                propertyName,"Recoleta",
                new ArrayList<>(Arrays.asList(
                        new Room("Comedor", (double) 25, (double) 20),
                        new Room("Cocina", (double) 15, (double) 10),
                        new Room("Dormitorio", (double) 12, (double) 10)
                )));
        Mockito.when(iPropertyService.addProperty(expected)).thenReturn(HttpStatus.CREATED);

        // act
        ResponseEntity<HttpStatus> received = propertyController.addProperty(expected);

        // assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).addProperty(expected);
        Assertions.assertEquals(HttpStatus.CREATED, received.getStatusCode());
    }

    @Test
    public void addPropertyBadNeighborhood() throws NeighborhoodNotFoundException {

        // arrange
        String propertyName = "Casa de Diego";
        PropertyReqDTO expected = new PropertyReqDTO(
                propertyName, "Quilmes",
                new ArrayList<>(Arrays.asList(
                        new Room("Comedor", (double) 25, (double) 20),
                        new Room("Cocina", (double) 15, (double) 10),
                        new Room("Dormitorio", (double) 12, (double) 10)
                )));

        // assert
        Mockito.verify(iPropertyService, Mockito.never()).addProperty(expected);
        Assertions.assertThrows(NeighborhoodNotFoundException.class,
                () -> propertyController.addProperty(expected));

    }

    @Test
    public void matchPropertyValue() throws PropertyNotFoundException {

        // arrange
        String propertyName = "Casa de Diego";
        Property property = new Property(
                propertyName, new Neighborhood("Recoleta", (double) 1000),
                new ArrayList<>(Arrays.asList(
                        new Room("Comedor", (double) 25, (double) 20),
                        new Room("Cocina", (double) 15, (double) 10),
                        new Room("Dormitorio", (double) 12, (double) 10)
                )));
        PropertyValueDTO expected = new PropertyValueDTO(propertyName, (double) 770000);

        Mockito.when(iPropertyService.getValue(propertyName)).thenReturn(expected);

        // act
        ResponseEntity<PropertyValueDTO> received = propertyController.getPropertyValue(propertyName);

        // assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getValue(propertyName);
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void unMatchPropertyValueBadPropertyName() throws PropertyNotFoundException {

        // arrange
        String propertyName = "Casa de Diego";
        Property property = new Property(
                propertyName.concat("------"),
                new Neighborhood("Recoleta", (double) 1000),
                new ArrayList<>(Arrays.asList(
                        new Room("Comedor", (double) 25, (double) 20),
                        new Room("Cocina", (double) 15, (double) 10),
                        new Room("Dormitorio", (double) 12, (double) 10)
                )));

        Mockito.when(iPropertyService.getValue(propertyName)).thenThrow(PropertyNotFoundException.class);

        // assert
        Mockito.verify(iPropertyService, Mockito.never()).getValue(propertyName);
        Assertions.assertThrows(PropertyNotFoundException.class,
                () -> propertyController.getPropertyValue(propertyName));
    }

}
