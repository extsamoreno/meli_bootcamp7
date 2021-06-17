package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.NeighborhoodDTO;
import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.dto.RoomSquareMetersDTO;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;
import com.tucasita.tasaciones.model.Neighborhood;
import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.model.Room;
import com.tucasita.tasaciones.repository.PropertyRepository;
import com.tucasita.tasaciones.util.TestUtilGenerator;
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
        PropertyDTO property = TestUtilGenerator.getPropertyDTOWithFourRooms();
        Property prop = PropertyMapper.toEntity(property);
        MockedStatic<PropertyMapper> mock = mockStatic(PropertyMapper.class);
        mock.when(() -> PropertyMapper.toEntity(property)).thenReturn(prop);
        propertyService.saveProperty(property);
        verify(propertyRepository, times(1)).saveProperty(prop);
    }

    @Test
    public void getSquareMetersTest() throws PropertyNotFoundException {

        Property property = TestUtilGenerator.getPropertyWithTwoRooms();

        when(propertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(propertyService.calculateSquareMeters(1), 45);
    }

    @Test
    public void getPropertyPrice() throws PropertyNotFoundException {

        Property property = TestUtilGenerator.getPropertyWithTwoRooms();

        when(propertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(propertyService.getPropertyPrice(1), 18000);
    }

    @Test
    public void getBiggestRoom() throws PropertyNotFoundException {

        Property property = TestUtilGenerator.getPropertyWithTwoRooms();

        when(propertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(property.getRooms().get(1).getName(), propertyService.getBiggestRoom(1).getName());
    }

    @Test
    public void getRoomsSquareMeters() throws PropertyNotFoundException {
        Property property = TestUtilGenerator.getPropertyWithTwoRooms();
        RoomSquareMetersDTO room = new RoomSquareMetersDTO(property.getRooms().get(0).getName(), property.getRooms().get(0).getLength() * property.getRooms().get(0).getWidth());
        RoomSquareMetersDTO room2 = new RoomSquareMetersDTO(property.getRooms().get(1).getName(), property.getRooms().get(1).getLength() * property.getRooms().get(1).getWidth());
        MockedStatic<PropertyMapper> mock = mockStatic(PropertyMapper.class);
        mock.when(() -> PropertyMapper.toSquareMetersDTO(property.getRooms().get(0))).thenReturn(room);
        mock.when(() -> PropertyMapper.toSquareMetersDTO(property.getRooms().get(1))).thenReturn(room2);
        when(propertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(propertyService.getRoomsSquareMeters(1).get(0), room);
        assertEquals(propertyService.getRoomsSquareMeters(1).get(1), room2);
    }
}
