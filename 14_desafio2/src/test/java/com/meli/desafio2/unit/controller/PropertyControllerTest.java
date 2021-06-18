package com.meli.desafio2.unit.controller;

import com.meli.desafio2.controller.PropertyController;
import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalAreaDTO;
import com.meli.desafio2.dto.property.ResponsePropValueDTO;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.service.IPropertyService;
import com.meli.desafio2.util.TestUtilsGen;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    // EndPoint 1
    @Test
    public void calcTotalAreaHappyPath() throws PropertyIdNotFoundException {

        // Arrange
        int propId = 0;
        ResponsePropTotalAreaDTO prop = TestUtilsGen.getResponsePropTotalAreaDTO(propId);
        when(propertyService.calcTotalArea(propId)).thenReturn(prop);

        // Act
        ResponseEntity<ResponsePropTotalAreaDTO> responseProp = propertyController.calcTotalArea(propId);

        // Assert
        verify(propertyService, atLeastOnce()).calcTotalArea(propId);
        Assertions.assertEquals(prop, responseProp.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseProp.getStatusCode());
    }

    // EndPoint 2
    @Test
    public void calcPropValueHappyPath() throws PropertyIdNotFoundException, DistrictIdNotFoundException {

        // Arrange
        int propId = 0;
        ResponsePropValueDTO prop = TestUtilsGen.getResponsePropValueDTO(propId);
        when(propertyService.calcPropValue(propId)).thenReturn(prop);

        // Act
        ResponseEntity<ResponsePropValueDTO> responseProp = propertyController.calcPropValue(propId);

        // Assert
        verify(propertyService, atLeastOnce()).calcPropValue(propId);
        Assertions.assertEquals(prop, responseProp.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseProp.getStatusCode());
    }

    // EndPoint 3
    @Test
    public void getBigEnvironmentHappyPath() throws PropertyIdNotFoundException {

        int propId = 0;
        ResponseBigEnvironmentDTO env = TestUtilsGen.getResponseBigEnvironmentDTO();
        when(propertyService.getBigEnvironment(propId)).thenReturn(env);

        // Act
        ResponseEntity<ResponseBigEnvironmentDTO> responseEnv = propertyController.getBigEnvironment(propId);

        // Assert
        verify(propertyService, atLeastOnce()).getBigEnvironment(propId);
        Assertions.assertEquals(env, responseEnv.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEnv.getStatusCode());
    }

    // EndPoint 4
    @Test
    public void listEnvAreaHappyPath() throws PropertyIdNotFoundException {

        // Arrange
        int propId = 0;
        List<ResponseEnvironmentDTO> listEnv = TestUtilsGen.getListResponseEnvironmentDTO();
        when(propertyService.listEnvironmentsArea(propId)).thenReturn(listEnv);

        // Act
        ResponseEntity<List<ResponseEnvironmentDTO>> responseListEnv = propertyController.listEnvArea(propId);

        // Assert
        verify(propertyService, atLeastOnce()).listEnvironmentsArea(propId);
        Assertions.assertTrue(CollectionUtils.isEqualCollection(listEnv, responseListEnv.getBody()));
        Assertions.assertEquals(HttpStatus.OK, responseListEnv.getStatusCode());
    }

    // EndPoint 5
    @Test
    public void createNewPropHappyPath() throws PropertyIdAlreadyExistException, DistrictIdNotFoundException {

        // Arrange
        int propId = 5;
        String message = "Property successfully created";
        PropertyDTO prop = TestUtilsGen.getPropDTOWithId(0);
        when(propertyService.createNewProperty(prop)).thenReturn(message);

        // Act
        ResponseEntity<String> response = propertyController.createNewProp(prop);

        // Assert
        verify(propertyService, atLeastOnce()).createNewProperty(prop);
        Assertions.assertEquals(message, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
