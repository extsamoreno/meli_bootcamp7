package com.tucasita.tasaciones.controller;

import com.tucasita.tasaciones.dto.NeighborhoodDTO;
import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    PropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

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
        Assertions.assertEquals(ResponseEntity.ok().build(), propertyController.saveProperty(property));

    }
}