package com.example.desafio2.unit.service;

import com.example.desafio2.exception.NeighborhoodExceptionNotFound;
import com.example.desafio2.exception.PropertyAlreadyExistsException;
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

import java.util.LinkedList;
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
    public void getTotalMetresSuccesful() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");

        when(iPropertyRepository.findPropertyByName(property.getName())).thenReturn(property);

        // act
        Double total = service.getTotalMetres(property.getName());
        Double totalExpected = (double) 6.0;
        // assert
        verify(iPropertyRepository, atLeastOnce()).findPropertyByName(property.getName());
        assertEquals(totalExpected, total);
    }
    @Test
    public void getTotalMetresNotFound() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");

        // act
        when(iPropertyRepository.findPropertyByName(property.getName())).thenThrow(PropertyExceptionNotFound.class);

        // assert
        assertThrows(PropertyExceptionNotFound.class, () -> iPropertyRepository.findPropertyByName(property.getName()));

    }

    @Test
    public void getPropertyValueSuccesful() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        when(iPropertyRepository.findPropertyByName(property.getName())).thenReturn(property);

        // act
        Double total = service.getValue(property.getName());
        Double totalExpected = (double) 60.0;

        // assert
        verify(iPropertyRepository, atLeastOnce()).findPropertyByName(property.getName());
        assertEquals(totalExpected, total);
    }
    @Test
    public void getPropertyValueNotFound() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        // act
        when(iPropertyRepository.findPropertyByName(property.getName())).thenThrow(PropertyExceptionNotFound.class);

        // assert
        assertThrows(PropertyExceptionNotFound.class, () -> iPropertyRepository.findPropertyByName(property.getName()));

    }
    @Test
    public void getBiggestRoomSuccesful() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        when(iPropertyRepository.findPropertyByName(property.getName())).thenReturn(property);

        // act
        RoomDTO room = service.getBiggestRoom(property.getName());
        RoomDTO biggestExpected = new RoomDTO("Bathroom",2,2);

        // assert
        verify(iPropertyRepository, atLeastOnce()).findPropertyByName(property.getName());
        assertEquals(biggestExpected,room);

    }
    @Test
    public void getBiggestRoomNotFound() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith3Room("Centro");
        // act
        when(iPropertyRepository.findPropertyByName(property.getName())).thenThrow(PropertyExceptionNotFound.class);



        // assert
        assertThrows(PropertyExceptionNotFound.class, () -> iPropertyRepository.findPropertyByName(property.getName()));

    }
    @Test
    public void getMetresAmountOfEachRoomSuccesful() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
            when(iPropertyRepository.findPropertyByName(property.getName())).thenReturn(property);

            // act
            List<PropertyTotalMetresRoomDTO> rooms = service.getTotalEachRoom(property.getName());
            PropertyTotalMetresRoomDTO expectedRoom1 = new PropertyTotalMetresRoomDTO(property.getRooms().get(0).getName(),1);
            List<PropertyTotalMetresRoomDTO> expectedRooms = new LinkedList<PropertyTotalMetresRoomDTO>();
            expectedRooms.add(expectedRoom1);

            // assert
            verify(iPropertyRepository, atLeastOnce()).findPropertyByName(property.getName());
            assertEquals(expectedRooms.size(), rooms.size());
            assertEquals(expectedRooms.get(0).getName(), rooms.get(0).getName());
            assertEquals(expectedRooms.get(0).getTotalMetres(), rooms.get(0).getTotalMetres());
    }
    @Test
    public void getMetresAmountOfEachRoomNotFound() throws PropertyExceptionNotFound {
        // arrange
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        // act
        when(iPropertyRepository.findPropertyByName(property.getName())).thenThrow(PropertyExceptionNotFound.class);

        // assert
        assertThrows(PropertyExceptionNotFound.class, () -> iPropertyRepository.findPropertyByName(property.getName()));
    }
    @Test
    public void createPropertySuccesful() throws NeighborhoodExceptionNotFound, PropertyAlreadyExistsException { //throws NeighborhoodExceptionNotFound, PropertyAlreadyExistsException
        List<Property> properties = new LinkedList<>();
        properties.add(TestUtilsGenerator.getPropertyWith1Room("Centro"));

        when(iPropertyRepository.getProperties()).thenReturn(properties);
        when(iPropertyRepository.findNeighborhoodByName(properties.get(0).getNeighborhood().getName())).thenReturn(properties.get(0).getNeighborhood());

        List<Property> propertiesFromRepo = iPropertyRepository.getProperties();
        service.createProperty(TestUtilsGenerator.getPropertyDTOWith1Room("Bathroom","Centro"));

        assertEquals(2,propertiesFromRepo.size());

    }
}