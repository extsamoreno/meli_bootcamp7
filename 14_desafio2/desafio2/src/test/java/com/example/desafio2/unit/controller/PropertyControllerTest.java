package com.example.desafio2.unit.controller;

import com.example.desafio2.controller.PropertyController;
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
        public void createProperty() {
            // arrange
            try{
                PropertyDTO prop = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
                Mockito.doNothing().when(service).createProperty(prop);
                // act
                controller.createProperty(prop);

                // assert
                verify(service, atLeastOnce()).createProperty(prop);
            }
            catch(Exception ex){
            }
        }
    @Test
    public void getTotalMetresSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        try {
            when(service.getTotalMetres(property.getName())).thenReturn(6.0);

            // act
            Double totalExpected = (double) 6.0;
            // assert
            ResponseEntity<Double> response = controller.getTotalMetres(property.getName());
            verify(service, atLeastOnce()).getTotalMetres(property.getName());
            assertEquals(totalExpected,response.getBody());
        }
        catch (Exception ex){

        }
    }

    @Test
    public void getPropertyValueSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        try {
            when(service.getValue(property.getName())).thenReturn(60.0);

            // act
            Double totalExpected = (double) 60.0;
            // assert
            ResponseEntity<Double> response = controller.getValue(property.getName());
            verify(service, atLeastOnce()).getValue(property.getName());
            assertEquals(totalExpected,response.getBody());
        }
        catch (Exception ex){

        }
    }
    @Test
    public void getBiggestRoomSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        try {
            RoomDTO biggestExpected = new RoomDTO("Bathroom",2,2);
            when(service.getBiggestRoom(property.getName())).thenReturn(biggestExpected);

            // act
            ResponseEntity<RoomDTO> response = controller.getBiggestRoom(property.getName());
            // assert
            verify(service, atLeastOnce()).getBiggestRoom(property.getName());
            assertEquals(biggestExpected,response.getBody());
        }
        catch (Exception ex){

        }
    }
    /*
    @Test
    public void getMetresAmountOfEachRoomSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        try {
            List<PropertyTotalMetresRoomDTO> rooms = service.getTotalEachRoom(property.getName());
            PropertyTotalMetresRoomDTO expectedRoom1 = new PropertyTotalMetresRoomDTO("Bathroom",1);
            rooms.add(expectedRoom1);
            when(service.getTotalEachRoom(property.getName())).thenReturn(rooms);

            // act

            // assert
            verify(service, atLeastOnce()).getTotalEachRoom(property.getName());
            assertEquals(rooms.size(), 1);
            for(PropertyTotalMetresRoomDTO room : rooms){
                if(room.equals(expectedRoom1.getName()))
                    assertEquals(room.getTotalMetres(),expectedRoom1.getTotalMetres());
            }
        }
        catch (Exception ex){

        }
    }*/
}




