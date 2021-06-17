package com.tucasita.tasaciones.controller;

import com.tucasita.tasaciones.dto.NeighborhoodDTO;
import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;
import com.tucasita.tasaciones.service.PropertyService;
import com.tucasita.tasaciones.util.TestUtilGenerator;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    PropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void saveProperty() throws IOException {
        PropertyDTO property = TestUtilGenerator.getPropertyDTOWithFourRooms();
        Assertions.assertEquals(ResponseEntity.ok().build(), propertyController.saveProperty(property));

    }

    @Test
    public void getSquareMetersTest() throws PropertyNotFoundException {
        when(propertyService.calculateSquareMeters(1)).thenReturn(34.2);
        assertEquals(ResponseEntity.ok(34.2), propertyController.getSquareMeters(1));
    }

    @Test
    public void getPropertyPriceTest() throws PropertyNotFoundException {
        when(propertyService.getPropertyPrice(1)).thenReturn(18000.0);
        assertEquals(ResponseEntity.ok(18000.0), propertyController.getPropertyPrice(1));
    }

    @Test
    public void getBiggestRoom() throws PropertyNotFoundException {
        PropertyDTO property = TestUtilGenerator.getPropertyDTOWithFourRooms();
        when(propertyService.getBiggestRoom(1)).thenReturn(property.getRooms().get(0));
        assertEquals(ResponseEntity.ok(property.getRooms().get(0)), propertyController.getBiggestRoom(1));
    }
}