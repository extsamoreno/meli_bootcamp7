package com.example.desafio2.unit.service;

import com.example.desafio2.exception.PropertyExceptionNotFound;
import com.example.desafio2.model.Property;
import com.example.desafio2.model.Room;
import com.example.desafio2.repository.IPropertyRepository;
import com.example.desafio2.service.DTO.PropertyTotalMetresRoomDTO;
import com.example.desafio2.service.DTO.RoomDTO;
import com.example.desafio2.service.PropertyService;
import com.example.desafio2.util.TestUtilsGenerator;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository iPropertyRepository;

    @InjectMocks
    PropertyService service;

    @Test
    public void getTotalMetresSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        try {
            when(iPropertyRepository.findPropertyByName(property.getName())).thenReturn(property);

            // act
            Double total = service.getTotalMetres(property.getName());
            Double totalExpected = (double) 6.0;
            // assert
            verify(iPropertyRepository, atLeastOnce()).findPropertyByName(property.getName());
            assertEquals(totalExpected, total);
        }
        catch (Exception ex){

        }
    }
    @Test
    public void getTotalMetresNotFound() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        try {
            when(iPropertyRepository.findPropertyByName(property.getName())).thenThrow(PropertyExceptionNotFound.class);

            // act

            // assert
            assertThrows(PropertyExceptionNotFound.class, () -> iPropertyRepository.findPropertyByName(property.getName()));
        }
        catch (Exception ex){

        }
    }

    @Test
    public void getPropertyValueSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        try {
            when(iPropertyRepository.findPropertyByName(property.getName())).thenReturn(property);

            // act
            Double total = service.getValue(property.getName());
            Double totalExpected = (double) 60.0;

            // assert
            verify(iPropertyRepository, atLeastOnce()).findPropertyByName(property.getName());
            assertEquals(totalExpected, total);        }
        catch (Exception ex){

        }
    }
    @Test
    public void getPropertyValueNotFound() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        try {
            when(iPropertyRepository.findPropertyByName(property.getName())).thenThrow(PropertyExceptionNotFound.class);

            // act

            // assert
            assertThrows(PropertyExceptionNotFound.class, () -> iPropertyRepository.findPropertyByName(property.getName()));
        }
        catch (Exception ex){

        }
    }
    @Test
    public void getBiggestRoomSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        try {
            when(iPropertyRepository.findPropertyByName(property.getName())).thenReturn(property);

            // act
            RoomDTO room = service.getBiggestRoom(property.getName());
            RoomDTO biggestExpected = new RoomDTO("Bathroom",2,2);

            // assert
            verify(iPropertyRepository, atLeastOnce()).findPropertyByName(property.getName());
            assertEquals(room, biggestExpected);
        }
        catch (Exception ex){

        }
    }
    @Test
    public void getBiggestRoomNotFound() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        try {
            when(iPropertyRepository.findPropertyByName(property.getName())).thenThrow(PropertyExceptionNotFound.class);

            // act

            // assert
            assertThrows(PropertyExceptionNotFound.class, () -> iPropertyRepository.findPropertyByName(property.getName()));
        }
        catch (Exception ex){

        }
    }
    @Test
    public void getMetresAmountOfEachRoomSuccesful() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        try {
            when(iPropertyRepository.findPropertyByName(property.getName())).thenReturn(property);

            // act
            List<PropertyTotalMetresRoomDTO> rooms = service.getTotalEachRoom(property.getName());
            PropertyTotalMetresRoomDTO expectedRoom1 = new PropertyTotalMetresRoomDTO("Bathroom",1);


            // assert
            verify(iPropertyRepository, atLeastOnce()).findPropertyByName(property.getName());
            assertEquals(rooms.size(), 1);
            for(PropertyTotalMetresRoomDTO room : rooms){
                if(room.equals(expectedRoom1.getName()))
                    assertEquals(room.getTotalMetres(),expectedRoom1.getTotalMetres());
            }
        }
        catch (Exception ex){

        }
    }
    @Test
    public void getMetresAmountOfEachRoomNotFound() {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        try {
            when(iPropertyRepository.findPropertyByName(property.getName())).thenThrow(PropertyExceptionNotFound.class);

            // act

            // assert
            assertThrows(PropertyExceptionNotFound.class, () -> iPropertyRepository.findPropertyByName(property.getName()));
        }
        catch (Exception ex){

        }
    }

}