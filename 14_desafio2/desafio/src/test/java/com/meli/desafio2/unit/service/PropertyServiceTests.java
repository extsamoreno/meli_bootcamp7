package com.meli.desafio2.unit.service;

import com.meli.desafio2.exception.DistrictNotFoundException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.Room;
import com.meli.desafio2.unit.repository.IPropertyRepository;
import com.meli.desafio2.unit.service.dto.DistrictDTO;
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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {

    @Mock
    IPropertyRepository propertyRepository;

    @Mock
    ModelMapper mapper;

    @InjectMocks
    PropertyService service;

    @Test
    public void create() {
        // arrange
        PropertyDTO propDTO = TestUtilsGenerator.getPropertyDTO("Juan");
        Property prop = TestUtilsGenerator.getProperty("Juan");

        when(propertyRepository.fetch(prop.getDistrict().getName())).thenReturn(420d);
        when(mapper.map(propDTO, Property.class)).thenReturn(prop);

        // act
        service.create(propDTO);

        // assert
        verify(propertyRepository, atLeastOnce()).create(prop);
        verify(mapper, atLeastOnce()).map(propDTO, Property.class);
    }

    @Test
    public void calculateSquareMeters() {
        // arrange
        Property prop = TestUtilsGenerator.getProperty("Juan");
        Double expected = 680d;
        when(propertyRepository.fetch(prop.getId())).thenReturn(prop);

        // act
        Double result = service.calculateSquareMeters(prop.getId());

        // assert
        verify(propertyRepository, atLeastOnce()).fetch(prop.getId());
        assertEquals(expected, result);
    }

    @Test
    public void calculateValue() {
        // arrange
        Property prop = TestUtilsGenerator.getProperty("Juan");
        when(propertyRepository.fetch(prop.getId())).thenReturn(prop);
        Double expected = 680d*420d;

        // act
        Double result = service.calculateValue(prop.getId());

        // assert
        verify(propertyRepository, atLeastOnce()).fetch(prop.getId());
        assertEquals(expected, result);
    }

    @Test
    public void biggestRoom() {
        // arrange
        Property prop = TestUtilsGenerator.getProperty("Juan");
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTO("Juan");

        when(propertyRepository.fetch(prop.getId())).thenReturn(prop);
        when(mapper.map(prop.getRooms().get(1), RoomDTO.class)).thenReturn(propertyDTO.getRooms().get(1));
        RoomDTO expected = propertyDTO.getRooms().get(1);

        // act
        RoomDTO result = service.biggestRoom(prop.getId());

        // assert
        verify(propertyRepository, atLeastOnce()).fetch(prop.getId());
        verify(mapper, atLeastOnce()).map(prop.getRooms().get(1), RoomDTO.class);
        assertEquals(expected, result);
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    public void roomsWithSquareMeters() {
        // arrange
        Property prop = TestUtilsGenerator.getProperty("Juan");
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTO("Juan");

        RoomSquareMDTO room1 = new RoomSquareMDTO("Matematica", 12d, 15d, 0d);
        RoomSquareMDTO room2 = new RoomSquareMDTO("Fatematica", 20d, 20d, 0d);
        RoomSquareMDTO room3 = new RoomSquareMDTO("Matematica", 10d, 10d, 0d);

        List<RoomSquareMDTO> expected = new ArrayList<>(){{add(room1);add(room2);add(room3);}};

        when(propertyRepository.fetch(prop.getId())).thenReturn(prop);
        when(mapper.map(prop.getRooms().get(0), RoomSquareMDTO.class)).thenReturn(room1);
        when(mapper.map(prop.getRooms().get(1), RoomSquareMDTO.class)).thenReturn(room2);
        when(mapper.map(prop.getRooms().get(2), RoomSquareMDTO.class)).thenReturn(room3);

        // act
        List<RoomSquareMDTO> result = service.roomsWithSquareMeters(prop.getId());

        // assert
        verify(propertyRepository, atLeastOnce()).fetch(prop.getId());
        verify(mapper, atLeastOnce()).map(prop.getRooms().get(0), RoomSquareMDTO.class);
        verify(mapper, atLeastOnce()).map(prop.getRooms().get(1), RoomSquareMDTO.class);
        verify(mapper, atLeastOnce()).map(prop.getRooms().get(2), RoomSquareMDTO.class);
        assertTrue(CollectionUtils.isEqualCollection(expected, result));
    }

    @Test
    public void createDistrictNotFoundException() {
        // arrange
        PropertyDTO propDTO = TestUtilsGenerator.getPropertyDTO("Juan");
        Property prop = TestUtilsGenerator.getProperty("Juan");
        propDTO.getDistrict().setName("hohohohooho");

        when(propertyRepository.fetch(propDTO.getDistrict().getName())).thenThrow(new DistrictNotFoundException(propDTO.getDistrict().getName()));

        // act
        DistrictNotFoundException exception = assertThrows(DistrictNotFoundException.class, () -> {
            service.create(propDTO);
        });

        String expectedException = "DistrictNotFoundException";
        String actualException = exception.getError().getName();
        assertTrue(actualException.contains(expectedException));
    }


}
