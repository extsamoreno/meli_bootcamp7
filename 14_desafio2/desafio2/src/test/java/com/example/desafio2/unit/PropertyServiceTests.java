package com.example.desafio2.unit;

import com.example.desafio2.dtos.*;
import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.EnvironmentDTO;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;
import com.example.desafio2.repositories.IPropertyRepository;
import com.example.desafio2.services.PropertyService;
import com.example.desafio2.utils.TestUtilsGenerator;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {

    @Mock
    IPropertyRepository iPropertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyFiles();
    }

    @Test
    public void createPropertyOk() throws PropertyAlreadyExistException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        PropertyDTO expected = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        when(iPropertyRepository.saveProperty(property)).thenReturn(property);

        // act
        PropertyDTO received = propertyService.createProperty(property);

        // assert
        verify(iPropertyRepository, atLeastOnce()).saveProperty(property);
        assertEquals(expected, received);
    }
/*
    @Test
    public void createNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        NeighborhoodDTO expected = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        HttpStatus expectedStatus = HttpStatus.CREATED;
        when(iPropertyService.createNeighborhood(neighborhood)).thenReturn(neighborhood);

        // act
        ResponseEntity<NeighborhoodDTO> received = propertyController.createNeighborhood(neighborhood);

        // assert
        verify(iPropertyService, atLeastOnce()).createNeighborhood(neighborhood);
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }

    @Test
    public void getSquareMetersOk() throws PropertyNotFoundException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
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
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen(property.getNeighborhood());
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
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        EnvironmentDTO environment = TestUtilsGenerator.getEnvironment264SquareMeters("Habitación 1");
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
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        List<ResponseEnvironmentDTO> environments = TestUtilsGenerator.getEnvironmentSquareMetersList(property);
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
 */
}
