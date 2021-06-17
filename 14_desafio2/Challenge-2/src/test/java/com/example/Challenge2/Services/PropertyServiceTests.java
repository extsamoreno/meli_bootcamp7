package com.example.Challenge2.Services;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Models.Room;
import com.example.Challenge2.Repositories.IDataRepository;
import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.Mapper.DistrictMapper;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {

    @Mock
    IDataRepository iDataRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test

    public void getPropertyDimensionsThrowsPropertyNotFoundExceptionTest() throws PropertyNotFoundException {
        // arrange
        Long id = 1L;
        when(iDataRepository.getPropertyById(id)).thenReturn(null);
        // assert

        assertThrows(PropertyNotFoundException.class, () -> propertyService.getPropertyDimensions(id));
    }

    @Test
    public void getPropertyDimensionsTest() throws PropertyNotFoundException {
        // arrange
        Long id = 1L;
        Property property = TestUtilsGenerator.get50MtProperty(id);
        StructureDTO expectedDimension = new StructureDTO(50.0,property.getName());

        when(iDataRepository.getPropertyById(id)).thenReturn(property);

        // act
        StructureDTO dimensions = propertyService.getPropertyDimensions(id);

        // assert
        verify(iDataRepository, atLeastOnce()).getPropertyById(id);
        assertTrue(expectedDimension.equals(dimensions));
    }

    @Test
    public void getPropertyDimensionsFalseTest() throws PropertyNotFoundException {
        // arrange
        Long id = 1L;
        Property property = TestUtilsGenerator.get50MtProperty(id);
        StructureDTO expectedDimension = new StructureDTO(10.0,property.getName());

        when(iDataRepository.getPropertyById(id)).thenReturn(property);

        // act
        StructureDTO dimensions = propertyService.getPropertyDimensions(id);

        // assert
        verify(iDataRepository, atLeastOnce()).getPropertyById(id);
        assertFalse(expectedDimension.equals(dimensions));
    }

    @Test
    public void getPropertyValueTest() throws PropertyNotFoundException, DistrictNotFoundException {
        // arrange
        Long propertyId = 1L;
        Long districtId = 2L;

        double expectedValue = 5000.0;
        Property property = TestUtilsGenerator.get50MtProperty(propertyId);
        property.setDistrictId(districtId);

        District district = TestUtilsGenerator.get100USDollarsDistrict(districtId);

        when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);
        when(iDataRepository.getDistrictById(districtId)).thenReturn(district);

        // act
        ValueDTO value = propertyService.getPropertyValue(propertyId);

        // assert
        verify(iDataRepository, atLeastOnce()).getPropertyById(propertyId);
        verify(iDataRepository, atLeastOnce()).getDistrictById(districtId);
        assertEquals(value.getAmount(),expectedValue);
    }
    @Test
    public void getPropertyValueFalseTest() throws PropertyNotFoundException, DistrictNotFoundException {
        // arrange
        Long propertyId = 1L;
        Long districtId = 2L;

        double expectedValue = 1000.0;
        Property property = TestUtilsGenerator.get50MtProperty(propertyId);
        property.setDistrictId(districtId);

        District district = TestUtilsGenerator.get100USDollarsDistrict(districtId);

        when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);
        when(iDataRepository.getDistrictById(districtId)).thenReturn(district);

        // act
        ValueDTO value = propertyService.getPropertyValue(propertyId);

        // assert
        verify(iDataRepository, atLeastOnce()).getPropertyById(propertyId);
        verify(iDataRepository, atLeastOnce()).getDistrictById(districtId);
        assertFalse(value.getAmount() == expectedValue);
    }
    @Test
    public void getPropertyValueThrowsDistrictNotFoundExceptionTest() throws PropertyNotFoundException, DistrictNotFoundException {


        // arrange
        Long propertyId = 1L;
        Long districtId = 2L;

        Property property = TestUtilsGenerator.get50MtProperty(propertyId);
        property.setDistrictId(districtId);

        when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);
        when(iDataRepository.getDistrictById(districtId)).thenReturn(null);

        // assert
        assertThrows(DistrictNotFoundException.class, () -> propertyService.getPropertyValue(propertyId));


    }
    @Test
    public void getPropertyValueThrowsPropertyNotFoundExceptionTest() throws PropertyNotFoundException {
        // arrange
        Long id = 1L;
        when(iDataRepository.getPropertyById(id)).thenReturn(null);
        // assert

        assertThrows(PropertyNotFoundException.class, () -> propertyService.getPropertyValue(id));
    }

    @Test
    public void getBiggestRoomFalseTest() throws PropertyNotFoundException {
        // arrange
        Long propertyId = 1L;

        double expectedDimension = 100.0;
        Property property = TestUtilsGenerator.getPropertyWith50M2BiggestRoom(propertyId);

        when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);


        // act
        RoomDTO biggestRoom = propertyService.getBiggestRoom(propertyId);

        // assert
        verify(iDataRepository, atLeastOnce()).getPropertyById(propertyId);

        assertFalse(biggestRoom.getM2() == expectedDimension);
    }
    @Test
    public void getBiggestRoomTest() throws PropertyNotFoundException {
        // arrange
        Long propertyId = 1L;

        double expectedDimension = 100.0;
        Property property = TestUtilsGenerator.getPropertyWith100M2BiggestRoom(propertyId);

        when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);


        // act
        RoomDTO biggestRoom = propertyService.getBiggestRoom(propertyId);

        // assert
        verify(iDataRepository, atLeastOnce()).getPropertyById(propertyId);

        assertEquals(biggestRoom.getM2() , expectedDimension);
    }
    @Test
    public void getBiggestRoomThrowsPropertyNotFoundExceptionTest() throws PropertyNotFoundException {
        // arrange
        Long id = 1L;
        when(iDataRepository.getPropertyById(id)).thenReturn(null);
        // assert

        assertThrows(PropertyNotFoundException.class, () -> propertyService.getBiggestRoom(id));
    }
    @Test
    public void getDimensionedRoomsTest() throws PropertyNotFoundException{
        // arrange
        Long propertyId = 1L;
        double expectedDimension = 25.0;
        List<Room> rooms = TestUtilsGenerator.getTwo25Mt2Rooms();
        Property property = TestUtilsGenerator.get50MtProperty(propertyId);
        property.setRooms(rooms);

        StructureDTO structure1 = new StructureDTO(expectedDimension, rooms.get(0).getName());
        StructureDTO structure2 = new StructureDTO(expectedDimension, rooms.get(1).getName());
        List<StructureDTO> expectedStructures = new ArrayList<>();
        expectedStructures.add(structure1);
        expectedStructures.add(structure2);

        when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);

        // act
        List<StructureDTO> dimensionatedStructures = propertyService.getDimensionedRooms(propertyId);

        // assert
        verify(iDataRepository, atLeastOnce()).getPropertyById(propertyId);

        assertEquals(dimensionatedStructures,expectedStructures);
    }

    @Test
    public void getDimensionedRoomsFalseTest() throws PropertyNotFoundException{
        // arrange
        Long propertyId = 1L;
        double expectedDimension = 10.0;
        List<Room> rooms = TestUtilsGenerator.getTwo25Mt2Rooms();
        Property property = TestUtilsGenerator.get50MtProperty(propertyId);
        property.setRooms(rooms);

        StructureDTO structure1 = new StructureDTO(expectedDimension, rooms.get(0).getName());
        StructureDTO structure2 = new StructureDTO(expectedDimension, rooms.get(1).getName());
        List<StructureDTO> expectedStructures = new ArrayList<>();
        expectedStructures.add(structure1);
        expectedStructures.add(structure2);


        when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);


        // act
        List<StructureDTO> dimensionatedStructures = propertyService.getDimensionedRooms(propertyId);

        // assert
        verify(iDataRepository, atLeastOnce()).getPropertyById(propertyId);

        assertFalse(dimensionatedStructures.equals(expectedStructures));
    }

    @Test

    public void getDimensionedRoomsThrowsPropertyNotFoundExceptionTest() throws PropertyNotFoundException {
        // arrange
        Long id = 1L;
        when(iDataRepository.getPropertyById(id)).thenReturn(null);
        // assert

        assertThrows(PropertyNotFoundException.class, () -> propertyService.getDimensionedRooms(id));
    }

    @Test
    public void storeTest() throws DistrictNotFoundException {

        // arrange
        Long propertyId = 1L;
        Long districtId = 2L;
        PropertyDTO propertyDTO = PropertyMapper.toDTO(TestUtilsGenerator.getPropertyWithTwo25MTsRooms(propertyId));
        District district = TestUtilsGenerator.get100USDollarsDistrict(districtId);

        when(iDataRepository.getDistrictById(propertyDTO.getDistrictId())).thenReturn(district);
        when(iDataRepository.getAllProperties()).thenReturn(new ArrayList<>());

        // act
        Boolean response = propertyService.storeProperty(propertyDTO);

        // assert
        verify(iDataRepository, atLeastOnce()).getAllProperties();
        assertTrue(response);
    }

    @Test
    public void storeThrowsDistrictNotFoundExceptionTest() throws DistrictNotFoundException {

        // arrange
        Long propertyId = 1L;
        PropertyDTO propertyDTO = PropertyMapper.toDTO(TestUtilsGenerator.getPropertyWithTwo25MTsRooms(propertyId));
        when(iDataRepository.getDistrictById(propertyDTO.getDistrictId())).thenReturn(null);

        // assert

        assertThrows(DistrictNotFoundException.class, () -> propertyService.storeProperty(propertyDTO));
    }

}
