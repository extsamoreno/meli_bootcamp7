package com.desafio2.demo.unit.PropertyTest;

import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Environment;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;
import com.desafio2.demo.repository.INeighborhoodRepository;
import com.desafio2.demo.repository.IPropertyRepository;
import com.desafio2.demo.service.PropertyService;
import com.desafio2.demo.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;


@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    INeighborhoodRepository iNeighborhoodRepository;

    @InjectMocks
    PropertyService propertyService;

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
        when(iPropertyRepository.saveProperty(property)).thenReturn(property);

        // act
        Property received = propertyService.createProperty(property);

        // assert
        verify(iPropertyRepository, atLeastOnce()).saveProperty(property);
        assertEquals(expected, received);
    }

    @Test
    public void getSquareMetersOk() throws PropertyNotFoundException {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa de Madera");
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
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen(property.getNeighborhood());
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
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        Environment environment = TestUtilGenerator.getEnvironment264SquareMeters("Room1");
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
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        List<ResponseEnvironmentDTO> environments = TestUtilGenerator.getEnvironmentSquareMetersList(property);
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
