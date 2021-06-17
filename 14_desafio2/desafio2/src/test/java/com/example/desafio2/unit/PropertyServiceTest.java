package com.example.desafio2.unit;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.exceptions.DistrictIdNotValidException;
import com.example.desafio2.exceptions.PropertyIdNotValidException;
import com.example.desafio2.models.District;
import com.example.desafio2.models.Property;
import com.example.desafio2.repositories.IDistrictRepository;
import com.example.desafio2.repositories.IPropertyRepository;
import com.example.desafio2.services.PropertyService;
import com.example.desafio2.services.mappers.PropertyMapper;
import com.example.desafio2.services.mappers.RoomMapper;
import com.example.desafio2.services.utils.PropertyUtil;
import com.example.desafio2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {
    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    IDistrictRepository iDistrictRepository;

    @InjectMocks
    PropertyService service;

    @Test
    public void getAreaHappyPath() throws PropertyIdNotValidException {
        //arrange
        int propId = 1;

        Property prop = TestUtilsGenerator.getPropertyWith3Rooms("GetAreaTestingHouse");
        when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        double expected = PropertyUtil.getArea(prop);

        //act
        double result = service.getArea(propId);

        //assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void getAreaWithInvalidPropertyIdShouldThrowPropertyNotValidException() {
        //arrange
        int propId = 1;
        when(iPropertyRepository.getPropertyById(propId)).thenReturn(null);

        //act & assert
        Assertions.assertThrows(PropertyIdNotValidException.class,()->service.getArea(propId));
    }

    @Test
    public void getBiggestRoomHappyPath() throws PropertyIdNotValidException {
        //arrange
        int propId = 1;

        Property prop = TestUtilsGenerator.getPropertyWith3RoomsDetailed("GetBiggestRoomTestingHouse",
                "Living",5.0,6.0,
                "Bedroom",2.0,3.0,
                "Kitchen",3.0,3.0);
        when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        RoomDTO expected = RoomMapper.toDTO(prop.getRoomList().get(0));

        //act
        RoomDTO result = service.getBiggestRoom(propId);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getBiggestRoomWithInvalidPropertyIdShouldThrowPropertyNotValidException() {
        //arrange
        int propId = 1;
        when(iPropertyRepository.getPropertyById(propId)).thenReturn(null);

        //act & assert
        Assertions.assertThrows(PropertyIdNotValidException.class,()->service.getBiggestRoom(propId));
    }

    @Test
    public void getRoomsAreasHappyPath() throws PropertyIdNotValidException {
        //arrange
        int propId = 1;

        Property prop = TestUtilsGenerator.getPropertyWith3RoomsDetailed("GetRoomsAreasTestingHouse",
                "Living",5.0,6.0,
                "Bedroom",2.0,3.0,
                "Kitchen",3.0,3.0);

        when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        List<RoomAreaDTO> expected = TestUtilsGenerator.get3RoomAreasListDetailed(
                "Living",(5.0 * 6.0),
                "Bedroom",(2.0 * 3.0),
                "Kitchen",(3.0 * 3.0));

        //act
        List<RoomAreaDTO> result = service.getRoomsAreas(propId);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getRoomsAreasWithInvalidPropertyIdShouldThrowPropertyNotValidException() {
        //arrange
        int propId = 1;
        when(iPropertyRepository.getPropertyById(propId)).thenReturn(null);

        //act & assert
        Assertions.assertThrows(PropertyIdNotValidException.class,()->service.getRoomsAreas(propId));
    }

    @Test
    public void addPropertyWithValidDistrictIdHappyPath() throws DistrictIdNotValidException {
        //arrange
        int expected = 1;
        PropertyDTO prop = TestUtilsGenerator.getPropertyDTOWith3Rooms("GetAreaTestingHouse");
        District dist = new District("GetAreaTestingDistrict", 500);
        when(iPropertyRepository.add(PropertyMapper.toModel(prop))).thenReturn(1);
        when(iDistrictRepository.getById(prop.getDistrictId())).thenReturn(dist);

        //act
        int result = service.add(prop);

        //assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void addPropertyWithInvalidDistrictIdShouldThrowDistrictNotValidException() {
        //arrange
        PropertyDTO prop = TestUtilsGenerator.getPropertyDTOWith3Rooms("GetAreaTestingHouse");
        when(iDistrictRepository.getById(prop.getDistrictId())).thenReturn(null);

        //act & assert
        Assertions.assertThrows(DistrictIdNotValidException.class,()->service.add(prop));
    }



}

