package com.example.desafio2.unit;

import com.example.desafio2.dtos.*;
import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.EnvironmentDTO;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;
import com.example.desafio2.repositories.INeighborhoodRepository;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {

    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    INeighborhoodRepository iNeighborhoodRepository;

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

    @Test
    public void getSquareMetersOk() throws PropertyNotFoundException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        double squareMeters = 305.00;
        ResponsePropertySquareDTO expected = new ResponsePropertySquareDTO(property.getName(), squareMeters);
        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);

        // act
        ResponsePropertySquareDTO received = propertyService.getSquareMeters(property.getId());

        // assert
        verify(iPropertyRepository, atLeastOnce()).getPropertyById(property.getId());
        assertEquals(expected, received);
    }

    @Test
    public void getPropertyValueOk() throws PropertyException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen(property.getNeighborhood());
        double value = 305.00 * neighborhood.getPrice();
        ResponsePropertyValueDTO expected = new ResponsePropertyValueDTO(property.getName(), value);

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);
        when(iNeighborhoodRepository.getNeighborhoodByName(property.getNeighborhood())).thenReturn(neighborhood);

        // act
        ResponsePropertyValueDTO received = propertyService.getPropertyValue(property.getId());

        // assert
        verify(iPropertyRepository, atLeastOnce()).getPropertyById(property.getId());
        verify(iNeighborhoodRepository, atLeastOnce()).getNeighborhoodByName(property.getNeighborhood());
        assertEquals(expected, received);
    }

    @Test
    public void getBiggestEnvironmentOk() throws PropertyException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        EnvironmentDTO environment = TestUtilsGenerator.getEnvironment264SquareMeters("Habitación 1");
        double squareMeters = 264.00;
        ResponseBiggestEnvironmentDTO expected =
                new ResponseBiggestEnvironmentDTO(property.getName(), squareMeters, environment);
        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);

        // act
        ResponseBiggestEnvironmentDTO received = propertyService.getBiggestEnvironment(property.getId());

        // assert
        verify(iPropertyRepository, atLeastOnce()).getPropertyById(property.getId());
        assertEquals(expected, received);
    }

    @Test
    public void getSquareMetersOfEnvironmentsOk() throws PropertyNotFoundException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        List<ResponseEnvironmentDTO> environments = TestUtilsGenerator.getEnvironmentSquareMetersList(property);
        ResponseSquareMetersEnvironmentDTO expected =
                new ResponseSquareMetersEnvironmentDTO(property.getName(), environments);
        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);

        // act
        ResponseSquareMetersEnvironmentDTO received = propertyService.getSquareMetersOfEnvironments(property.getId());

        // assert
        verify(iPropertyRepository, atLeastOnce()).getPropertyById(property.getId());
        assertEquals(expected, received);
    }
}
