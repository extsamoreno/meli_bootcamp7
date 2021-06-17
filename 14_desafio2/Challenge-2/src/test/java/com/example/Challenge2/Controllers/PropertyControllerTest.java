package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Services.DTOs.PropertyDTO;
import com.example.Challenge2.Services.DTOs.RoomDTO;
import com.example.Challenge2.Services.DTOs.StructureDTO;
import com.example.Challenge2.Services.DTOs.ValueDTO;
import com.example.Challenge2.Services.IPropertyService;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import com.example.Challenge2.Services.Mapper.RoomMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;




    @Test
    public void getBiggestRoomTest() throws PropertyNotFoundException {

        // arrange,
        Long id = 1L;
        RoomDTO expectedRoom = RoomMapper.toDTO(TestUtilsGenerator.get25Mt2Room());
        Property property = TestUtilsGenerator.getPropertyWith100M2BiggestRoom(id);
        when(iPropertyService.getBiggestRoom(id)).thenReturn(expectedRoom);

        // act
        ResponseEntity<RoomDTO> biggestRoomResponse = propertyController.getBiggestRoom(property.getId());

        // assert
        verify(iPropertyService, atLeastOnce()).getBiggestRoom(property.getId());
        assertEquals(biggestRoomResponse.getBody(), expectedRoom);
    }
    @Test
    public void getBiggestRoomFalseTest() throws PropertyNotFoundException {

        // arrange,
        Long id = 1L;
        RoomDTO expectedRoom = RoomMapper.toDTO(TestUtilsGenerator.get25Mt2Room());
        RoomDTO notExpectedRoom = RoomMapper.toDTO(TestUtilsGenerator.get100Mt2Room());
        Property property = TestUtilsGenerator.getPropertyWith100M2BiggestRoom(id);
        when(iPropertyService.getBiggestRoom(id)).thenReturn(expectedRoom);

        // act
        ResponseEntity<RoomDTO> biggestRoomResponse = propertyController.getBiggestRoom(property.getId());

        // assert
        verify(iPropertyService, atLeastOnce()).getBiggestRoom(property.getId());
        assertNotEquals(biggestRoomResponse.getBody(), notExpectedRoom);
    }




    @Test
    public void getValueTest() throws PropertyNotFoundException, DistrictNotFoundException {

        // arrange,
        Long id = 1L;
        ValueDTO expectedValue = TestUtilsGenerator.get1000USDValue();
        when(iPropertyService.getPropertyValue(id)).thenReturn(expectedValue);

        // act
        ResponseEntity<ValueDTO> valueResponse = propertyController.getValue(id);

        // assert
        verify(iPropertyService, atLeastOnce()).getPropertyValue(id);
        assertEquals(valueResponse.getBody(), expectedValue);
    }

    @Test
    public void getValueFalseTest() throws PropertyNotFoundException, DistrictNotFoundException {

        // arrange,
        Long id = 1L;
        ValueDTO expectedValue = TestUtilsGenerator.get1000USDValue();
        ValueDTO notExpectedValue = TestUtilsGenerator.get10000USDValue();
        when(iPropertyService.getPropertyValue(id)).thenReturn(expectedValue);

        // act
        ResponseEntity<ValueDTO> valueResponse = propertyController.getValue(id);

        // assert
        verify(iPropertyService, atLeastOnce()).getPropertyValue(id);
        assertNotEquals(valueResponse.getBody(), notExpectedValue);
    }

    @Test
    public void getDimensionsTest() throws PropertyNotFoundException {

        // arrange,
        Long id = 1L;
        StructureDTO expectedStructures = TestUtilsGenerator.get100Mts2Structure();
        when(iPropertyService.getPropertyDimensions(id)).thenReturn(expectedStructures);

        // act
        ResponseEntity<StructureDTO> structureResponse = propertyController.getDimensions(id);

        // assert
        verify(iPropertyService, atLeastOnce()).getPropertyDimensions(id);
        assertEquals(structureResponse.getBody(), expectedStructures);
    }
    @Test
    public void getDimensionsFalseTest() throws PropertyNotFoundException {

        // arrange,
        Long id = 1L;
        StructureDTO expectedStructures = TestUtilsGenerator.get100Mts2Structure();
        StructureDTO notExpectedStructures = TestUtilsGenerator.get101Mts2Structure();
        when(iPropertyService.getPropertyDimensions(id)).thenReturn(expectedStructures);

        // act
        ResponseEntity<StructureDTO> structureResponse = propertyController.getDimensions(id);

        // assert
        verify(iPropertyService, atLeastOnce()).getPropertyDimensions(id);
        assertNotEquals(structureResponse.getBody(), notExpectedStructures);
    }

    @Test
    public void getRoomsTest() throws PropertyNotFoundException {

        // arrange,
        Long id = 1L;
        List<StructureDTO> expectedStructures = TestUtilsGenerator.getThree25Mts2Structures();
        when(iPropertyService.getDimensionedRooms(id)).thenReturn(expectedStructures);

        // act
        ResponseEntity<List<StructureDTO>> structureResponse = propertyController.getRooms(id);

        // assert
        verify(iPropertyService, atLeastOnce()).getDimensionedRooms(id);
        assertEquals(structureResponse.getBody(), expectedStructures);
    }

    @Test
    public void getRoomsFalseTest() throws PropertyNotFoundException {

        // arrange,
        Long id = 1L;
        List<StructureDTO> expectedStructures = TestUtilsGenerator.getThree25Mts2Structures();
        List<StructureDTO> notExpectedStructures = TestUtilsGenerator.getThree30Mts2Structures();
        when(iPropertyService.getDimensionedRooms(id)).thenReturn(expectedStructures);

        // act
        ResponseEntity<List<StructureDTO>> structureResponse = propertyController.getRooms(id);

        // assert
        verify(iPropertyService, atLeastOnce()).getDimensionedRooms(id);
        assertNotEquals(structureResponse.getBody(), notExpectedStructures);
    }

    @Test
    public void storeTest() throws DistrictNotFoundException {

        // arrange,
        Long id = 1L;
        PropertyDTO propertyDTO = PropertyMapper.toDTO(TestUtilsGenerator.get50MtProperty(null));
        when(iPropertyService.storeProperty(propertyDTO)).thenReturn(true);

        // act
        ResponseEntity<Boolean> structureResponse = propertyController.store(propertyDTO);

        // assert
        verify(iPropertyService, atLeastOnce()).storeProperty(propertyDTO);
        assertTrue(structureResponse.getBody());
    }
}
