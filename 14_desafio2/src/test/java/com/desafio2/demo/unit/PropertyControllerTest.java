package com.desafio2.demo.unit;

import com.desafio2.demo.controller.PropertyController;
import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Environment;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;
import com.desafio2.demo.service.IPropertyService;
import com.desafio2.demo.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilGenerator.emptyFiles();
    }

    @Test
    public void createPropertyOk() throws PropertyAlreadyExistException {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        Property expected = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        HttpStatus expectedStatus = HttpStatus.CREATED;
        when(iPropertyService.createProperty(property)).thenReturn(property);

        // act
        ResponseEntity<Property> received = propertyController.createProperty(property);

        // assert
        verify(iPropertyService, atLeastOnce()).createProperty(property);
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }

    @Test
    public void createNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        Neighborhood expected = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        HttpStatus expectedStatus = HttpStatus.CREATED;
        when(iPropertyService.createNeighborhood(neighborhood)).thenReturn(neighborhood);

        // act
        ResponseEntity<Neighborhood> received = propertyController.createNeighborhood(neighborhood);

        // assert
        verify(iPropertyService, atLeastOnce()).createNeighborhood(neighborhood);
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }

    @Test
    public void getSquareMetersOk() throws PropertyNotFoundException {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        double squareMeters = 305.00;
        ResponsePropertySquareDTO response = new ResponsePropertySquareDTO(property.getName(), squareMeters);
        ResponsePropertySquareDTO expected = new ResponsePropertySquareDTO(property.getName(), squareMeters);
        HttpStatus expectedStatus = HttpStatus.OK;
        when(iPropertyService.getSquareMeters(property.getId())).thenReturn(response);

        // act
        ResponseEntity<ResponsePropertySquareDTO> received = propertyController.getSquareMeters(property.getId());

        // assert
        verify(iPropertyService, atLeastOnce()).getSquareMeters(property.getId());
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }

    @Test
    public void getPropertyValueOk() throws PropertyException {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen(property.getNeighborhood());
        double value = 305.00 * neighborhood.getPrice();
        ResponsePropertyValueDTO response = new ResponsePropertyValueDTO(property.getName(), value);
        ResponsePropertyValueDTO expected = new ResponsePropertyValueDTO(property.getName(), value);
        HttpStatus expectedStatus = HttpStatus.OK;
        when(iPropertyService.getPropertyValue(property.getId())).thenReturn(response);

        // act
        ResponseEntity<ResponsePropertyValueDTO> received = propertyController.getPropertyValue(property.getId());

        // assert
        verify(iPropertyService, atLeastOnce()).getPropertyValue(property.getId());
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }

    @Test
    public void getBiggestEnvironmentOk() throws PropertyException {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        Environment environment = TestUtilGenerator.getEnvironment264SquareMeters("Room1");
        double squareMeters = 264.00;
        ResponseBiggestEnvironmentDTO response =
                new ResponseBiggestEnvironmentDTO(property.getName(), squareMeters, environment);
        ResponseBiggestEnvironmentDTO expected =
                new ResponseBiggestEnvironmentDTO(property.getName(), squareMeters, environment);
        HttpStatus expectedStatus = HttpStatus.OK;
        when(iPropertyService.getBiggestEnvironment(property.getId())).thenReturn(response);

        // act
        ResponseEntity<ResponseBiggestEnvironmentDTO> received = propertyController.getBiggestEnvironment(property.getId());

        // assert
        verify(iPropertyService, atLeastOnce()).getBiggestEnvironment(property.getId());
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }

    @Test
    public void getSquareMetersOfEnvironmentsOk() throws PropertyNotFoundException {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        List<ResponseEnvironmentDTO> environments = TestUtilGenerator.getEnvironmentSquareMetersList(property);
        ResponseSquareMetersEnvironmentDTO response =
                new ResponseSquareMetersEnvironmentDTO(property.getName(), environments);
        ResponseSquareMetersEnvironmentDTO expected =
                new ResponseSquareMetersEnvironmentDTO(property.getName(), environments);
        HttpStatus expectedStatus = HttpStatus.OK;
        when(iPropertyService.getSquareMetersOfEnvironments(property.getId())).thenReturn(response);

        // act
        ResponseEntity<ResponseSquareMetersEnvironmentDTO> received =
                propertyController.getSquareMetersOfEnvironments(property.getId());

        // assert
        verify(iPropertyService, atLeastOnce()).getSquareMetersOfEnvironments(property.getId());
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }
}
