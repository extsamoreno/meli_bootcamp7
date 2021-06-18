package com.example.desafio2.unit.controller;

import com.example.desafio2.controller.PropertyController;
import com.example.desafio2.exception.NeighborhoodExceptionNotFound;
import com.example.desafio2.exception.PropertyAlreadyExistsException;
import com.example.desafio2.exception.PropertyExceptionNotFound;
import com.example.desafio2.model.Property;
import com.example.desafio2.service.DTO.PropertyDTO;
import com.example.desafio2.service.DTO.PropertyTotalMetresRoomDTO;
import com.example.desafio2.service.DTO.RoomDTO;
import com.example.desafio2.service.IPropertyService;
import com.example.desafio2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

        @Mock
        IPropertyService service;

        @InjectMocks
        PropertyController controller;

        @Test
        public void createProperty() throws NeighborhoodExceptionNotFound, PropertyAlreadyExistsException, PropertyExceptionNotFound {
            // arrange

            PropertyDTO prop = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
            Mockito.doNothing().when(service).createProperty(prop);
            // act
            ResponseEntity<?> response = controller.createProperty(prop);

            // assert
            verify(service, atLeastOnce()).createProperty(prop);
            assertEquals(HttpStatus.OK, response.getStatusCode());

        }
    @Test
    public void createPropertyNeighborhoodNotFound() throws NeighborhoodExceptionNotFound, PropertyAlreadyExistsException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
        doThrow(new NeighborhoodExceptionNotFound(property.getName())).when(service).createProperty(property);

        // act

        // assert
        assertThrows(NeighborhoodExceptionNotFound.class, () -> service.createProperty(property));

    }
    @Test
    public void createPropertyPropAlreadyExistNotFound() throws NeighborhoodExceptionNotFound, PropertyAlreadyExistsException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
        doThrow(new PropertyAlreadyExistsException(property.getName())).when(service).createProperty(property);
        // act

        // assert
        assertThrows(PropertyAlreadyExistsException.class, () -> service.createProperty(property));

    }
    @Test
    public void getTotalMetresSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        try {
            when(service.getTotalMetres(property.getName())).thenReturn(6.0);
            Double totalExpected = (double) 6.0;

            // act
            ResponseEntity<Double> response = controller.getTotalMetres(property.getName());

            // assert
            verify(service, atLeastOnce()).getTotalMetres(property.getName());
            assertEquals(totalExpected,response.getBody());
            assertEquals(HttpStatus.OK, response.getStatusCode());

        }
        catch (Exception ex){

        }
    }
    @Test
    public void getTotalMetresNotFound() throws PropertyExceptionNotFound {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
        when(service.getTotalMetres(property.getName())).thenThrow(new PropertyExceptionNotFound(property.getName()));


        assertThrows(PropertyExceptionNotFound.class, () -> service.getTotalMetres(property.getName()));
    }

    @Test
    public void getPropertyValueSuccesful() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
            when(service.getValue(property.getName())).thenReturn(60.0);
            Double totalExpected = (double) 60.0;

            // act
            ResponseEntity<Double> response = controller.getValue(property.getName());

            // assert
            verify(service, atLeastOnce()).getValue(property.getName());
            assertEquals(totalExpected,response.getBody());
            assertEquals(HttpStatus.OK, response.getStatusCode());


    }
    @Test
    public void getPropertyValueNotFound() throws PropertyExceptionNotFound {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
        when(service.getValue(property.getName())).thenThrow(new PropertyExceptionNotFound(property.getName()));


        assertThrows(PropertyExceptionNotFound.class, () -> service.getValue(property.getName()));
    }
    @Test
    public void getBiggestRoomSuccesful() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
            RoomDTO biggestExpected = new RoomDTO("Bathroom",2,2);
            when(service.getBiggestRoom(property.getName())).thenReturn(biggestExpected);

            // act
            ResponseEntity<RoomDTO> response = controller.getBiggestRoom(property.getName());
            // assert
            verify(service, atLeastOnce()).getBiggestRoom(property.getName());
            assertEquals(biggestExpected,response.getBody());
            assertEquals(HttpStatus.OK, response.getStatusCode());


    }
    @Test
    public void getBiggestRoomNotFound() throws PropertyExceptionNotFound {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
        when(service.getBiggestRoom(property.getName())).thenThrow(new PropertyExceptionNotFound(property.getName()));


        assertThrows(PropertyExceptionNotFound.class, () -> service.getBiggestRoom(property.getName()));
    }
    @Test
    public void getMetresAmountOfEachRoomSuccesful() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
            List<PropertyTotalMetresRoomDTO> rooms = service.getTotalEachRoom(property.getName());
            PropertyTotalMetresRoomDTO expectedRoom1 = new PropertyTotalMetresRoomDTO(property.getName(), 1);
            rooms.add(expectedRoom1);
            when(service.getTotalEachRoom(property.getName())).thenReturn(rooms);

            // act
            ResponseEntity<List<PropertyTotalMetresRoomDTO>> response = controller.getTotalEachRoom(property.getName());

            // assert
            verify(service, atLeastOnce()).getTotalEachRoom(property.getName());
            assertEquals(rooms.size(), 1);
            assertEquals(rooms, response.getBody());
            assertEquals(HttpStatus.OK, response.getStatusCode());

    }
        @Test
        public void getMetresAmountOfEachRoomNotFound() throws PropertyExceptionNotFound {
            // arrange
            PropertyDTO property = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
            when(service.getTotalEachRoom(property.getName())).thenThrow(new PropertyExceptionNotFound(property.getName()));


            assertThrows(PropertyExceptionNotFound.class, () -> service.getTotalEachRoom(property.getName()));
        }
    }





