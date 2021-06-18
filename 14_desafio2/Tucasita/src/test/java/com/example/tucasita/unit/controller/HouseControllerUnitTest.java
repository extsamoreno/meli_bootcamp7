package com.example.tucasita.unit.controller;

import com.example.tucasita.controller.TuCasitaController;
import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.response.*;
import com.example.tucasita.service.IHouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static com.example.tucasita.TestUtil.getSampleHouseDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HouseControllerUnitTest {

    @Mock
    IHouseService houseService;

    @InjectMocks
    TuCasitaController controller;

    HouseDTO houseDTO;

    @BeforeEach
    private void init() {
        houseDTO = getSampleHouseDTO();
    }

    /**
     * Happy paths
     */

    @Test
    public void calculateTotalMetersHappyPath() {
        HouseWithTotalMetersDTO expected = new HouseWithTotalMetersDTO("Casa", 80);
        Mockito.when(houseService.calculateTotalMeters(houseDTO)).thenReturn(expected);

        ResponseEntity<HouseWithTotalMetersDTO> received = controller.calculateTotalMeters(houseDTO);

        assertEquals(expected, received.getBody());
        assertEquals(200, received.getStatusCodeValue());
    }

    @Test
    public void calculateTotalValueHappyPath() {
        HouseWithTotalValueDTO expected = new HouseWithTotalValueDTO("Casa", 8000);
        Mockito.when(houseService.calculateTotalValue(houseDTO)).thenReturn(expected);

        ResponseEntity<HouseWithTotalValueDTO> received = controller.calculateTotalValue(houseDTO);

        assertEquals(expected, received.getBody());
        assertEquals(200, received.getStatusCodeValue());
    }

    @Test
    public void calculateLargestRoomHappyPath() {
        RoomWithMetersDTO largest = new RoomWithMetersDTO("Room2", 60);
        HouseWithLargestRoomDTO expected = new HouseWithLargestRoomDTO("Casa", largest);
        Mockito.when(houseService.calculateLargestRoom(houseDTO)).thenReturn(expected);

        ResponseEntity<HouseWithLargestRoomDTO> received = controller.calculateLargestRoom(houseDTO);

        assertEquals(expected, received.getBody());
        assertEquals(200, received.getStatusCodeValue());
    }

    @Test
    public void calculateRoomsSquareMetersHappyPath() {
        RoomWithMetersDTO room1 = new RoomWithMetersDTO("Room1", 20);
        RoomWithMetersDTO room2 = new RoomWithMetersDTO("Room2", 60);
        HouseWithRoomsMetersDTO expected = new HouseWithRoomsMetersDTO("Casa", Arrays.asList(room1, room2));
        Mockito.when(houseService.calculateRoomsSquareMeters(houseDTO)).thenReturn(expected);

        ResponseEntity<HouseWithRoomsMetersDTO> received = controller.calculateRoomsSquareMeters(houseDTO);

        assertEquals(expected, received.getBody());
        assertEquals(200, received.getStatusCodeValue());
    }


}
