package unit.mapper;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dto.*;
import com.meli.calculatorHouseSquareMeters.model.mapper.HouseMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseMapperTest {

    @Test
    public void generateHouseModelCorrectry() {
        // Arrage
        House expected = new House("Casa1",
                new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        // Data construction to test the received
        HouseRequestDTO houseRequestDTO = new HouseRequestDTO();
        houseRequestDTO.setHouseName("Casa1");
        houseRequestDTO.setDistrictName("Barrio Bajo");
        houseRequestDTO.setRooms(new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        District district = new District("Barrio Bajo", 800);

        // Act
        House received = HouseMapper.toHouseModel(houseRequestDTO, district);

        // Verify
        assertEquals(expected, received);
    }

    @Test
    public void generateHouseTotalQuantityResponseDTOCorrectly() {
        // Arrage
        HouseTotalQuantityResponseDTO expected = new HouseTotalQuantityResponseDTO("Casa1",
                80000,
                100);

        House house = new House("Casa1",
                new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        // Act
        HouseTotalQuantityResponseDTO received = HouseMapper.toHouseTotalQuantityResponseDTO(house);

        // Verify
        assertEquals(expected, received);
    }

    @Test
    public void generateHouseBiggestRoomResponseDTOCorrectly() {
        // Arrage
        HouseBiggestRoomResponseDTO expected = new HouseBiggestRoomResponseDTO("Casa1",
                "Habitación 1",
                100);

        House house = new House("Casa1",
                new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10),
                        new Room("Habitación 2", 9, 9))));

        // Act
        HouseBiggestRoomResponseDTO received = HouseMapper.toHouseBiggestRoomResponseDTO(house);

        // Verify
        assertEquals(expected, received);
    }

    @Test
    public void generateHouseRoomListResponseDTOCorrectly() {
        // Arrage
        HouseRoomListResponseDTO expected = new HouseRoomListResponseDTO("Casa1",
                new ArrayList<RoomResponseDTO>(Arrays.asList(new RoomResponseDTO("Habitación 1", 100))));

        House house = new House("Casa1",
                new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        // Act
        HouseRoomListResponseDTO received = HouseMapper.toHouseRoomListResponseDTO(house);

        // Verify
        assertEquals(expected, received);
    }
}
