package com.meli.desafio.unit;

import com.meli.desafio.controllers.CalculateController;
import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.Room;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.models.dto.RoomResponseDTO;
import com.meli.desafio.services.ICalculateService;
import com.meli.desafio.utils.Mappers;
import com.meli.desafio.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateControllerUnitTests {

    @Mock
    private ICalculateService calculateService;

    @InjectMocks
    private CalculateController calculateController;

    @Test
    public void getHouseHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        HouseDTO house = TestUtils.getTotalHouseDTO("House1");
        Integer houseId = 1;
        when(calculateService.getHouseById(houseId)).thenReturn(house);

        ResponseEntity<HouseDTO> response = calculateController.getHouse(houseId);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), house);
        verify(calculateService, atLeastOnce()).getHouseById(houseId);
    }

    @Test
    public void getHouseTotalMetersHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        Integer houseId = 1;
        when(calculateService.getTotalMeters(houseId)).thenReturn(50.00);

        ResponseEntity<String> response = calculateController.getTotalMeters(houseId);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), "50.0m2");
        verify(calculateService, atLeast(1)).getTotalMeters(houseId);
    }

    @Test
    public void getHouseTotalPriceHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        Integer houseId = 1;
        when(calculateService.getTotalPrice(houseId)).thenReturn(5000.00);

        ResponseEntity<String> response = calculateController.getTotalPrice(houseId);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), "U$D 5000.0");
        verify(calculateService, atLeast(1)).getTotalPrice(houseId);
    }

    @Test
    public void getHouseBiggerRoomHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        Integer houseId = 1;
        Room room = TestUtils.getRoom("Room");
        when(calculateService.getBiggerRoom(houseId)).thenReturn(room);

        ResponseEntity<Room> response = calculateController.getBiggerRoom(houseId);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), room);
        verify(calculateService, atLeast(1)).getBiggerRoom(houseId);
    }

    @Test
    public void getHouseMetterByRoomRoomHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        Integer houseId = 1;
        List<Room> rooms = TestUtils.getTotalHouse("House").getRooms();
        List<RoomResponseDTO> expected = new ArrayList<>();
        for(Room r:rooms){
            Mappers.roomToResponseDTO(r, r.getLength() * r.getWidth());
        }
        when(calculateService.getmetterByRoom(houseId)).thenReturn(expected);

        ResponseEntity<List<RoomResponseDTO>> response = calculateController.getmettersByRoom(houseId);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), expected);
        verify(calculateService, atLeast(1)).getmetterByRoom(houseId);
    }
}
