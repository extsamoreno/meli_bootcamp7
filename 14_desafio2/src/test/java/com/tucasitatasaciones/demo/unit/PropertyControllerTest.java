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

    @BeforeEach  @AfterEach
    public void init(){
        propertyDTO = Utils.getPropertyDTO();
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
        int propertyId = 1;
        PropertySquareMettersDTO propertyExpected = new PropertySquareMettersDTO(propertyId, propertyDTO.getName(), 1500);
        HttpStatus statusExpected = HttpStatus.OK;
        when(propertyService.calculateSquareMettersById(propertyId)).thenReturn(propertyExpected);

        //Act
        ResponseEntity<PropertySquareMettersDTO> response = propertyController.getSquareMettersById(propertyId);

        //Assert
        verify(propertyService, atLeastOnce()).calculateSquareMettersById(propertyId);
        assertEquals(propertyExpected, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

    //TODO: Revisar.
    @Test
    public void testGetSquareMettersWithInvalidId() throws BadRequestException {
        //Arrange
        int propertyId = 11;
        when(propertyService.calculateSquareMettersById(propertyId)).thenThrow(new BadRequestException());

        //Act
        //Assert
        assertThrows(BadRequestException.class, () -> {
            propertyController.getSquareMettersById(propertyId);
        });

    }

    @Test
    public void testGetPropertyPriceWithValidId() throws BadRequestException {
        //Arrange
        int propertyId = 1;
        PropertyPriceDTO propertyExpected = new PropertyPriceDTO(propertyId, propertyDTO.getName(), 113850);
        HttpStatus statusExpected = HttpStatus.OK;
        when(propertyService.calculatePropertyPriceById(propertyId)).thenReturn(propertyExpected);

        //Act
        ResponseEntity<PropertyPriceDTO> response = propertyController.getPropertyPriceById(propertyId);

        //Assert
        verify(propertyService, atLeastOnce()).calculatePropertyPriceById(propertyId);
        assertEquals(propertyExpected, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

    @Test
    public void testGetBiggestEnvironmentByIdWithValidId() throws BadRequestException {
        //Arrange
        int propertyId = 1;
        EnvironmentDTO environmentExpected = new EnvironmentDTO("Habitacion", 20, 30);
        PropertyBiggestEnvironmentDTO propertyExpected = new PropertyBiggestEnvironmentDTO(propertyId, propertyDTO.getName(),
                environmentExpected);

        HttpStatus statusExpected = HttpStatus.OK;

        when(propertyService.calculateBiggestEnvironmentById(propertyId)).thenReturn(propertyExpected);

        //Act
        ResponseEntity<PropertyBiggestEnvironmentDTO> response = propertyController.getBiggestEnvironmentById(propertyId);

        //Assert
        verify(propertyService, atLeastOnce()).calculateBiggestEnvironmentById(propertyId);
        assertEquals(propertyExpected, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

    @Test
    public void testGetPropertyEnvironmentsSquareMetters() throws BadRequestException {
        //Arrange
        int propertyId = 1;
        ArrayList<EnvironmentSquareMetterDTO> environmentsExpected = new ArrayList<>();
        environmentsExpected.add(new EnvironmentSquareMetterDTO("Baño", 20, 25,500));
        environmentsExpected.add(new EnvironmentSquareMetterDTO("Cocina", 10, 33,330));
        PropertyEnvironmentSquareMetterDTO propertyExpected = new PropertyEnvironmentSquareMetterDTO(propertyId, propertyDTO.getName(),
                environmentsExpected);

        HttpStatus statusExpected = HttpStatus.OK;

        when(propertyService.calculateSquareMettersEnvironmentsById(propertyId)).thenReturn(propertyExpected);

        //Act
        ResponseEntity<PropertyEnvironmentSquareMetterDTO> response = propertyController.getPropertyEnvironmentsSquareMetters(propertyId);

        //Assert
        verify(propertyService, atLeastOnce()).calculateSquareMettersEnvironmentsById(propertyId);
        assertEquals(propertyExpected, response.getBody());
        assertEquals(statusExpected, response.getStatusCode());
    }

}
