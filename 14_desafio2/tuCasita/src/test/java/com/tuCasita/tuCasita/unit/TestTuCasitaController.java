package com.tuCasita.tuCasita.unit;

import com.tuCasita.tuCasita.controller.TuCasitaController;
import com.tuCasita.tuCasita.models.DTO.HouseDTO;
import com.tuCasita.tuCasita.models.DTO.ResponseRoomsDTO;
import com.tuCasita.tuCasita.models.DTO.RoomDTO;
import com.tuCasita.tuCasita.models.District;
import com.tuCasita.tuCasita.models.House;
import com.tuCasita.tuCasita.models.Room;
import com.tuCasita.tuCasita.service.TuCasitaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.net.ssl.HostnameVerifier;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestTuCasitaController {

    @InjectMocks
    TuCasitaController controller;
    @Mock
    TuCasitaService service;

    House house;
    District district;

    @BeforeEach
    void initHouse(){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Living", 10d, 5d));
        rooms.add(new Room("Comedor", 6d, 4d));
        rooms.add(new Room("Habitacion", 15d, 9d));
        district = new District("Flores", 250d);
        house = new House("Monoambiente en Flores", district, rooms);
    }

    @Test
    void calculateTotalM2Controller() {
        //arrange
        HouseDTO houseDtoExpected = new HouseDTO("Monoambiente en Flores", 209d);
        ResponseEntity<HouseDTO> expected = new ResponseEntity<>(houseDtoExpected, HttpStatus.OK);
        when(service.calculateTotalM2(house)).thenReturn(houseDtoExpected);

        //act
        ResponseEntity<HouseDTO> obtained = controller.calculateTotalM2(house);

        //assert
        verify(service, atLeastOnce()).calculateTotalM2(house);
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    void calculateHouseValueController() {
        //arrange
        HouseDTO houseDtoExpected = new HouseDTO("Monoambiente en Flores", 52250d);
        ResponseEntity<HouseDTO> expected = new ResponseEntity<>(houseDtoExpected, HttpStatus.OK);
        when(service.calculateHouseValue(house)).thenReturn(houseDtoExpected);

        //act
        ResponseEntity<HouseDTO> obtained = controller.calculateHouseValue(house);

        //assert
        verify(service, atLeastOnce()).calculateHouseValue(house);
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    void biggestRoomController() {
        //arrange
        Room roomExpected = new Room("Habitacion", 15d, 9d);
        ResponseEntity<Room> expected = new ResponseEntity<>(roomExpected, HttpStatus.OK);
        when(service.biggestRoom(house)).thenReturn(roomExpected);

        //act
        ResponseEntity<Room> obtained = controller.biggestRoom(house);

        //assert
        verify(service, atLeastOnce()).biggestRoom(house);
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    void calculateRoomM2Controller() {
        //arrange
        ResponseRoomsDTO responseExpected = new ResponseRoomsDTO("Monoambiente en Flores", new ArrayList<>(){{
            add(new RoomDTO("Living", 50d));
            add(new RoomDTO("Comedor", 24d));
            add(new RoomDTO("Habitacion", 135d));
        }});
        ResponseEntity<ResponseRoomsDTO> expected = new ResponseEntity<>(responseExpected, HttpStatus.OK);
        when(service.calculateRoomM2(house)).thenReturn(responseExpected);

        //act
        ResponseEntity<ResponseRoomsDTO> obtained = controller.calculateRoomM2(house);

        //assert
        verify(service, atLeastOnce()).calculateRoomM2(house);
        Assertions.assertEquals(expected, obtained);
    }


}
