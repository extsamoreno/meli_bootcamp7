package com.testingchallenge.tucasita.unit;

import com.testingchallenge.tucasita.dto.*;
import com.testingchallenge.tucasita.exception.NeighborhoodNotFoundException;
import com.testingchallenge.tucasita.exception.PropertyNotFoundException;
import com.testingchallenge.tucasita.model.Neighborhood;
import com.testingchallenge.tucasita.model.Property;
import com.testingchallenge.tucasita.model.Room;
import com.testingchallenge.tucasita.repository.iNeighborhoodRepository;
import com.testingchallenge.tucasita.repository.iPropertyRepository;
import com.testingchallenge.tucasita.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {
    @Mock
    iPropertyRepository iPropertyRepository;

    @Mock
    iNeighborhoodRepository iNeighborhoodRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void matchPropertyArea() throws PropertyNotFoundException {

        // arrange
        String propertyName = "Casa de Diego";
        Property property = new Property(
                propertyName, new Neighborhood("Recoleta", (double) 1000),
                new ArrayList<>(Arrays.asList(
                        new Room("Comedor", (double) 25, (double) 20),
                        new Room("Cocina", (double) 15, (double) 10),
                        new Room("Dormitorio", (double) 12, (double) 10)
                ))
        );

        Mockito.when(iPropertyRepository.getByName(propertyName)).thenReturn(property);

        // act
        double expected = 770;
        PropertyDTO response = propertyService.getArea(propertyName);
        double received = response.getArea();

        // assert
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void matchPropertyValue() throws PropertyNotFoundException {

        // arrange
        String propertyName = "Casa de Diego";
        Property property = new Property(
                propertyName, new Neighborhood("Recoleta", (double) 1000),
                new ArrayList<>(Arrays.asList(
                        new Room("Comedor", (double) 25, (double) 20),
                        new Room("Cocina", (double) 15, (double) 10),
                        new Room("Dormitorio", (double) 12, (double) 10)
                ))
        );
        Mockito.when(iPropertyRepository.getByName(propertyName)).thenReturn(property);

        // act
        PropertyValueDTO received = propertyService.getValue(propertyName);

        // assert
        PropertyValueDTO expected = new PropertyValueDTO(propertyName, (double) 770000);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getTheBiggerRoom() throws PropertyNotFoundException {

        // arrange
        String propertyName = "Casa de Diego";
        Property property = new Property(
                propertyName, new Neighborhood("Recoleta", (double) 1000),
                new ArrayList<>(Arrays.asList(
                        new Room("Comedor", (double) 25, (double) 20),
                        new Room("Cocina", (double) 15, (double) 10),
                        new Room("Dormitorio", (double) 12, (double) 10)
                ))
        );
        Mockito.when(iPropertyRepository.getByName(propertyName)).thenReturn(property);

        // act
        BiggerRoomDTO expected = new BiggerRoomDTO(
                propertyName,
                new RoomDTO("Comedor",500)
        );
        BiggerRoomDTO received = propertyService.getTheBiggerRoom(propertyName);

        // assert
        Assertions.assertEquals(expected, received);
    }


    @Test
    public void checkRoomArea() throws PropertyNotFoundException {

        // arrange
        String propertyName = "Casa de Diego";
        Property property = new Property(
                propertyName, new Neighborhood("Recoleta", (double) 1000),
                new ArrayList<>(Arrays.asList(
                        new Room("Comedor", (double) 25, (double) 20),
                        new Room("Cocina", (double) 15, (double) 10),
                        new Room("Dormitorio", (double) 12, (double) 10)
                ))
        );
        Mockito.when(iPropertyRepository.getByName(propertyName)).thenReturn(property);

        // act
        PropertyRoomsDTO received = propertyService.getRoomArea(propertyName);

        // assert
        PropertyRoomsDTO expected = new PropertyRoomsDTO(
                propertyName, new ArrayList<>(Arrays.asList(
                    new RoomDTO("Comedor",500),
                    new RoomDTO("Cocina",150),
                    new RoomDTO("Dormitorio",120)
                ))
        );
        Assertions.assertEquals(expected, received);
    }


    @Test
    public void addPropertyToNeighborhood() throws NeighborhoodNotFoundException {

        // arrange
        String propertyName= "Casa de Diego";
        String neighborhoodName= "Recoleta";
        PropertyReqDTO propertyReqDTO = new PropertyReqDTO(
                propertyName, neighborhoodName,
                new ArrayList<>(Arrays.asList(
                    new Room("Comedor", (double) 25, (double) 20),
                    new Room("Cocina", (double) 15, (double) 10),
                    new Room("Dormitorio", (double) 12, (double) 10)
                ))
        );

        Property property = new Property(
                propertyName,
                new Neighborhood(neighborhoodName,(double) 1000),
                new ArrayList<>(Arrays.asList(
                     new Room("Comedor", (double) 25, (double) 20),
                     new Room("Cocina", (double) 15, (double) 10),
                     new Room("Dormitorio", (double) 12, (double) 10)
                ))
        );

        Neighborhood neighborhood = new Neighborhood(neighborhoodName, (double) 1000);
        Mockito.when(iNeighborhoodRepository.getByName(neighborhoodName)).thenReturn(neighborhood);
        Mockito.when(iPropertyRepository.addProperty(property)).thenReturn(HttpStatus.CREATED);

        // act
        HttpStatus received= propertyService.addProperty(propertyReqDTO);

        // assert
        Assertions.assertEquals(HttpStatus.CREATED, received);
    }

}
