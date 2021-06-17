package com.example.testingchallengev2.unit;

import com.example.testingchallengev2.controller.HouseInfoController;
import com.example.testingchallengev2.controller.HouseInfoExceptionsController;
import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.House;
import com.example.testingchallengev2.model.Room;
import com.example.testingchallengev2.model.response.*;
import com.example.testingchallengev2.service.IHouseInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.testingchallengev2.unit.TestUtils.getHouseWithName;

@ExtendWith(MockitoExtension.class)
public class HouseInfoControllerTest {

    @Mock
    IHouseInfoService iHouseInfoService;

    @InjectMocks
    HouseInfoController houseInfoController;


    @Test
    public void getDistrictListCallingService()
    {
        //arrange
        HashMap<String, Double> dist = new HashMap<>();
        dist.put("Centro", 123.0);
        dist.put("Nueva Córdoba", 150.0);
        DistrictListResponseDTO expected = new DistrictListResponseDTO(dist);
        Mockito.when(iHouseInfoService.getDistrictListDTO()).thenReturn(expected);

        //act
        ResponseEntity<DistrictListResponseDTO> received = houseInfoController.getDistrictList();

        //assert
        Mockito.verify(iHouseInfoService, Mockito.atLeastOnce()).getDistrictListDTO();
        Assertions.assertEquals(expected, received.getBody());
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void getHouseListCallingService()
    {
        //arrange
        House house = getHouseWithName("casa");
        HashMap<String, House> houses = new HashMap<>();
        houses.put(house.getName(), house);
        HouseListResponseDTO expected = new HouseListResponseDTO(houses);
        Mockito.when(iHouseInfoService.getHouseListDTO()).thenReturn(expected);

        //act
        ResponseEntity<HouseListResponseDTO> received = houseInfoController.getHouseList();

        //assert
        Mockito.verify(iHouseInfoService, Mockito.atLeastOnce()).getHouseListDTO();
        Assertions.assertEquals(expected, received.getBody());
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void getTotalAreaTest() throws Exception {

        String name = "casa";
        House house = getHouseWithName(name);
        TotalHouseAreaResponseDTO expected = new TotalHouseAreaResponseDTO(name, 4.0);
        Mockito.when(iHouseInfoService.getTotalHouseAreaResponseDTO(name)).thenReturn(expected);

        ResponseEntity<TotalHouseAreaResponseDTO> received = houseInfoController.getTotalHouseArea(name);

        Mockito.verify(iHouseInfoService, Mockito.atLeastOnce()).getTotalHouseAreaResponseDTO(name);
        Assertions.assertEquals(expected, received.getBody());
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void getHousePriceTest() throws Exception {

        String name = "casa";
        House house = getHouseWithName(name);
        HouseValueResponseDTO expected = new HouseValueResponseDTO("casa", 1200.0);
        Mockito.when(iHouseInfoService.getHouseValueResponseDTO(name)).thenReturn(expected);

        ResponseEntity<HouseValueResponseDTO> received = houseInfoController.getHousePrice(name);

        Mockito.verify(iHouseInfoService, Mockito.atLeastOnce()).getHouseValueResponseDTO(name);
        Assertions.assertEquals(expected, received.getBody());
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void getBiggestRoomTest() throws Exception {

        String name = "casa";
        House house = getHouseWithName(name);
        HouseBiggestRoomResponseDTO expected = new HouseBiggestRoomResponseDTO(name, "baño", 4.0);
        Mockito.when(iHouseInfoService.getHouseBiggestRoomResponseDTO(name)).thenReturn(expected);

        ResponseEntity<HouseBiggestRoomResponseDTO> received = houseInfoController.getBiggestRoom(name);

        Mockito.verify(iHouseInfoService, Mockito.atLeastOnce()).getHouseBiggestRoomResponseDTO(name);
        Assertions.assertEquals(expected, received.getBody());
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void getRoomsTest() throws Exception {

        String name = "casa";
        HashMap<String, Double> rooms = new HashMap<>();
        rooms.put("baño", 4.0);
        RoomsSizeResponseDTO expected = new RoomsSizeResponseDTO(rooms);
        Mockito.when(iHouseInfoService.getRoomsSizeResponseDTO(name)).thenReturn(expected);

        ResponseEntity<RoomsSizeResponseDTO> received = houseInfoController.getRoomsSize(name);

        Mockito.verify(iHouseInfoService, Mockito.atLeastOnce()).getRoomsSizeResponseDTO(name);
        Assertions.assertEquals(expected, received.getBody());
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

}
