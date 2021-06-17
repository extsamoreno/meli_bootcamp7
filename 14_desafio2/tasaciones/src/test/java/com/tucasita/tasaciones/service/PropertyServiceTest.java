package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.NeighborhoodDTO;
import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;
import com.tucasita.tasaciones.model.Neighborhood;
import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.model.Room;
import com.tucasita.tasaciones.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    PropertyRepository propertyRepository;

    @InjectMocks
    PropertyServiceImpl propertyService;

    @Test
    public void saveProperty() throws IOException {
        NeighborhoodDTO neigh = new NeighborhoodDTO("La Plata", 400.0);
        RoomDTO room1 = new RoomDTO("Living room", 5, 4);
        RoomDTO room2 = new RoomDTO("Kitchen", 3.5, 2);
        RoomDTO room3 = new RoomDTO("Bathroom", 1.6, 3);
        RoomDTO room4 = new RoomDTO("Bedroom", 2.6, 3.7);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        PropertyDTO property = new PropertyDTO("home", neigh, rooms);
        Property prop = PropertyMapper.toEntity(property);
        MockedStatic<PropertyMapper> mock = mockStatic(PropertyMapper.class);
        mock.when(() -> PropertyMapper.toEntity(property)).thenReturn(prop);
        propertyService.saveProperty(property);
        verify(propertyRepository, times(1)).saveProperty(prop);
    }

    @Test
    public void getSquareMetersTest() throws PropertyNotFoundException {
        Neighborhood neigh = new Neighborhood("La Plata", 400.0);
        Room room1 = new Room("Living room", 5, 4);
        Room room2 = new Room("Bedroom", 5, 5);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        Property property = new Property(1, "home", neigh, rooms);

        when(propertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(propertyService.calculateSquareMeters(1), 45);
    }
}
