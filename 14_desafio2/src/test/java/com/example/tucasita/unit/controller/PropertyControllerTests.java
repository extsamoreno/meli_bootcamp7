package com.example.tucasita.unit.controller;

import com.example.tucasita.controller.PropertyController;
import com.example.tucasita.dto.EnvironmentDTO;
import com.example.tucasita.dto.PropertyDTO;
import com.example.tucasita.service.PropertyService;
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
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTests {

    @Mock
    PropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void testAddOneProperty() {
        //ARRANGE
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO property = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);

        //ACT
        ResponseEntity<?> receivedResponse = propertyController.addOneProperty(property);

        //ASSERT
        Mockito.verify(propertyService,Mockito.atLeastOnce()).addOneProperty(property);
        Assertions.assertEquals(HttpStatus.CREATED,receivedResponse.getStatusCode());
    }

    @Test
    public void testCalculatePropertyTotalSquareMeters() {
        //ARRANGE
        int idProperty = 1;

        //ACT
        ResponseEntity<?> receivedResponse = propertyController.calculatePropertyTotalSquareMeters(idProperty);

        //ASSERT
        Mockito.verify(propertyService,Mockito.atLeastOnce()).calculatePropertyTotalSquareMeters(idProperty);
        Assertions.assertEquals(HttpStatus.OK,receivedResponse.getStatusCode());
    }

    @Test
    public void testCalculatePropertyPrice() {
        //ARRANGE
        int idProperty = 1;

        //ACT
        ResponseEntity<?> receivedResponse = propertyController.calculatePropertyPrice(idProperty);

        //ASSERT
        Mockito.verify(propertyService,Mockito.atLeastOnce()).calculatePropertyPrice(idProperty);
        Assertions.assertEquals(HttpStatus.OK,receivedResponse.getStatusCode());
    }

    @Test
    public void testGetBiggestEnvironment() {
        //ARRANGE
        int idProperty = 1;

        //ACT
        ResponseEntity<?> receivedResponse = propertyController.getBiggestEnvironment(idProperty);

        //ASSERT
        Mockito.verify(propertyService,Mockito.atLeastOnce()).getBiggestEnvironment(idProperty);
        Assertions.assertEquals(HttpStatus.OK,receivedResponse.getStatusCode());
    }

    @Test
    public void testCalculateEnvironmentsSquareMeters() {
        //ARRANGE
        int idProperty = 1;

        //ACT
        ResponseEntity<?> receivedResponse = propertyController.calculateEnvironmentsSquareMeters(idProperty);

        //ASSERT
        Mockito.verify(propertyService,Mockito.atLeastOnce()).calculateEnvironmentsSquareMeters(idProperty);
        Assertions.assertEquals(HttpStatus.OK,receivedResponse.getStatusCode());
    }
}
