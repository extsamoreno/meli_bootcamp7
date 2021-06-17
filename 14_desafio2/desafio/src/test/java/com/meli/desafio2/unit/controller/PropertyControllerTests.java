package com.meli.desafio2.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.Room;
import com.meli.desafio2.unit.service.IPropertyService;
import com.meli.desafio2.unit.service.dto.PropertyDTO;
import com.meli.desafio2.unit.service.dto.RoomDTO;
import com.meli.desafio2.unit.service.dto.RoomSquareMDTO;
import com.meli.desafio2.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTests {

    @Mock
    IPropertyService service;

    @InjectMocks
    PropertyController controller;

    @Test
    public void registerProperty() {
        // arrange
        PropertyDTO prop = TestUtilsGenerator.getPropertyWith3Rooms("Marco");

        // act
        controller.registerProperty(prop);

        // assert
        verify(service, atLeastOnce()).create(prop);
    }

    @Test
    public void calculateSquareMeters() {
        // arrange
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Matematica", 10d, 12d));

        PropertyDTO prop = new PropertyDTO();
        prop.setId(9999L);
        prop.setName("Juan");
        prop.setRooms(rooms);
        //10 x 12 + 15 x 15 = 345
        when(service.calculateSquareMeters(prop.getId())).thenReturn(345d);

        // act
        controller.calculateSquareMeters(prop.getId());

        // assert
        verify(service, atLeastOnce()).calculateSquareMeters(prop.getId());
    }

    @Test
    public void calculateValue() {
        // arrange
        PropertyDTO prop = TestUtilsGenerator.getPropertyWith3Rooms("Marco");
        Double price = prop.getRooms().stream().map(item -> item.getWidth() * item.getLength()).reduce(0d, (a, b) -> a + b) * prop.getDistrict().getPrice();
        when(service.calculateValue(prop.getId())).thenReturn(price);

        // act
        controller.calculateValue(prop.getId());

        // assert
        verify(service, atLeastOnce()).calculateValue(prop.getId());
    }

    @Test
    public void getBiggestRoom() {
        // arrange
        RoomDTO room1 = new RoomDTO("Matematica3", 15d, 15d);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Matematica", 10d, 12d));
        rooms.add(room1);

        PropertyDTO prop = new PropertyDTO();
        prop.setId(9999L);
        prop.setName("Juan");
        prop.setRooms(rooms);
        //10 x 12 + 15 x 15 = 345
        when(service.biggestRoom(prop.getId())).thenReturn(room1);

        // act
        ResponseEntity<RoomDTO> responseEntity = controller.getBiggestRoom(prop.getId());

        // assert
        verify(service, atLeastOnce()).biggestRoom(prop.getId());
        assertEquals(responseEntity.getBody(), room1);
    }

    @Test
    public void squareMetersRooms() {
        // arrange
        PropertyDTO prop = TestUtilsGenerator.getPropertyWith3Rooms("Jose");

        ModelMapper mapper = new ModelMapper();
        List<RoomSquareMDTO> roomsDTO = prop.getRooms()
                .stream()
                .map(room -> mapper.map(room, RoomSquareMDTO.class))
                .collect(Collectors.toList());

        roomsDTO.stream().forEach(item -> item.setSquareMeters(item.getWidth() * item.getLength()));

        when(service.roomsWithSquareMeters(prop.getId())).thenReturn(roomsDTO);

        // act
        ResponseEntity<List<RoomSquareMDTO>> result = controller.squareMetersRooms(prop.getId());

        // assert
        verify(service, atLeastOnce()).roomsWithSquareMeters(prop.getId());
        assertTrue(CollectionUtils.isEqualCollection(roomsDTO, result.getBody()));
    }
}
