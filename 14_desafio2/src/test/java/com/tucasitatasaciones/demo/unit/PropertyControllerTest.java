package com.tucasitatasaciones.demo.unit;

import com.tucasitatasaciones.demo.controller.PropertyController;
import com.tucasitatasaciones.demo.dto.*;
import com.tucasitatasaciones.demo.exception.BadRequestException;
import com.tucasitatasaciones.demo.service.IPropertyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    private PropertyDTO propertyDTO;
    private PropertySquareMettersDTO propertySquareMetters;
    private PropertyPriceDTO propertyPrice;
    private PropertyBiggestEnvironmentDTO propertyBiggestEnvironment;
    private PropertyEnvironmentSquareMetterDTO propertyEnvironmentMetters;

    @BeforeEach  @AfterEach
    public void init(){
        propertyDTO = Utils.getPropertyDTO();
        propertySquareMetters = Utils.getPropertySquareMetters();
        propertyPrice = Utils.getPropertyPrice();
        propertyBiggestEnvironment = Utils.getPropertyBiggestEnvironment();
        propertyEnvironmentMetters = Utils.getPropertyEnviromentsSquareMetters();
    }

    @Test
    public void testPostPropertyWithValidPayload() throws BadRequestException {
        //Arrange
        PropertyDTO propertyExpected = propertyDTO;
        HttpStatus statusExpected = HttpStatus.OK;
        when(propertyService.addProperty(propertyExpected)).thenReturn(propertyExpected);

        //Act
        ResponseEntity<PropertyDTO> response = propertyController.postProperty(propertyExpected);

        //Assert
        verify(propertyService, atLeastOnce()).addProperty(propertyExpected);
        assertEquals(propertyExpected, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

    @Test
    public void testGetSquareMettersByIdWithValidId() throws BadRequestException {
        //Arrange
        HttpStatus statusExpected = HttpStatus.OK;
        when(propertyService.calculateSquareMettersById(1)).thenReturn(propertySquareMetters);

        //Act
        ResponseEntity<PropertySquareMettersDTO> response = propertyController.getSquareMettersById(1);

        //Assert
        verify(propertyService, atLeastOnce()).calculateSquareMettersById(1);
        assertEquals(propertySquareMetters, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

    @Test
    public void testGetPropertyPriceWithValidId() throws BadRequestException {
        //Arrange
        HttpStatus statusExpected = HttpStatus.OK;
        when(propertyService.calculatePropertyPriceById(1)).thenReturn(propertyPrice);

        //Act
        ResponseEntity<PropertyPriceDTO> response = propertyController.getPropertyPriceById(1);

        //Assert
        verify(propertyService, atLeastOnce()).calculatePropertyPriceById(1);
        assertEquals(propertyPrice, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

    @Test
    public void testGetBiggestEnvironmentByIdWithValidId() throws BadRequestException {
        //Arrange
        HttpStatus statusExpected = HttpStatus.OK;

        when(propertyService.calculateBiggestEnvironmentById(1)).thenReturn(propertyBiggestEnvironment);

        //Act
        ResponseEntity<PropertyBiggestEnvironmentDTO> response = propertyController.getBiggestEnvironmentById(1);

        //Assert
        verify(propertyService, atLeastOnce()).calculateBiggestEnvironmentById(1);
        assertEquals(propertyBiggestEnvironment, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

    @Test
    public void testGetPropertyEnvironmentsSquareMetters() throws BadRequestException {
        //Arrange
        HttpStatus statusExpected = HttpStatus.OK;

        when(propertyService.calculateSquareMettersEnvironmentsById(1)).thenReturn(propertyEnvironmentMetters);

        //Act
        ResponseEntity<PropertyEnvironmentSquareMetterDTO> response = propertyController.getPropertyEnvironmentsSquareMetters(1);

        //Assert
        verify(propertyService, atLeastOnce()).calculateSquareMettersEnvironmentsById(1);
        assertEquals(propertyEnvironmentMetters, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

}
