package com.example.desafio2.integration;

import com.example.desafio2.dtos.*;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.EnvironmentDTO;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;
import com.example.desafio2.services.IPropertyService;
import com.example.desafio2.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyServiceTests {

    @Autowired
    IPropertyService iPropertyService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyFiles();
    }

    @Test
    public void shouldCreateAPropertyOK() throws PropertyAlreadyExistException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Mali");
        PropertyDTO expected = TestUtilsGenerator.getPropertyWithId("Casa de Mali", 2);

        // Act
        PropertyDTO received = iPropertyService.createProperty(property);

        // Assert
        assertEquals(expected, received);
    }

    @Test
    public void shouldGetSquareMetersOK() throws PropertyNotFoundException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        double squareMeters = 305.00;
        TestUtilsGenerator.appendNewProperty(property);
        ResponsePropertySquareDTO expected = new ResponsePropertySquareDTO(property.getName(), squareMeters);

        // Act
        ResponsePropertySquareDTO received = iPropertyService.getSquareMeters(property.getId());

        // Assert
        assertEquals(expected, received);
    }

    @Test
    public void getPropertyValueOk() throws PropertyException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen(property.getNeighborhood());
        double value = 305.00 * neighborhood.getPrice();
        TestUtilsGenerator.appendNewProperty(property);
        TestUtilsGenerator.appendNewNeighborhood(neighborhood);
        ResponsePropertyValueDTO expected = new ResponsePropertyValueDTO(property.getName(), value);

        // act
        ResponsePropertyValueDTO received = iPropertyService.getPropertyValue(property.getId());

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void getBiggestEnvironmentOk() throws PropertyException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        EnvironmentDTO environment = TestUtilsGenerator.getEnvironment264SquareMeters("Habitación 1");
        double squareMeters = 264.00;
        TestUtilsGenerator.appendNewProperty(property);
        ResponseBiggestEnvironmentDTO expected =
                new ResponseBiggestEnvironmentDTO(property.getName(), squareMeters, environment);

        // act
        ResponseBiggestEnvironmentDTO received = iPropertyService.getBiggestEnvironment(property.getId());

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void getSquareMetersOfEnvironmentsOk() throws PropertyNotFoundException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        List<ResponseEnvironmentDTO> environments = TestUtilsGenerator.getEnvironmentSquareMetersList(property);
        TestUtilsGenerator.appendNewProperty(property);
        ResponseSquareMetersEnvironmentDTO expected =
                new ResponseSquareMetersEnvironmentDTO(property.getName(), environments);

        // act
        ResponseSquareMetersEnvironmentDTO received = iPropertyService.getSquareMetersOfEnvironments(property.getId());

        // assert
        assertEquals(expected, received);
    }
}
