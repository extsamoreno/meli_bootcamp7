package unit.service;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryDistrict;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryHouse;
import com.meli.calculatorHouseSquareMeters.model.dto.*;
import com.meli.calculatorHouseSquareMeters.model.exception.*;
import com.meli.calculatorHouseSquareMeters.model.mapper.HouseMapper;
import com.meli.calculatorHouseSquareMeters.model.service.ServiceCalculatorHouseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceCalculatorHouseTest {

    @Mock
    RepositoryHouse repositoryHouse;

    @Mock
    RepositoryDistrict repositoryDistrict;

    @InjectMocks
    ServiceCalculatorHouseImpl serviceCalculatorHouse;

    @Test
    public void createNewHouseCorrectly()
            throws RepeatedHouseException, DistrictNotFoundException, HouseNotCreatedException {

        HouseRequestDTO houseRequestDTO = new HouseRequestDTO();
        houseRequestDTO.setHouseName("Casa1");
        houseRequestDTO.setDistrictName("Barrio Bajo");
        houseRequestDTO.setRooms(new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        District district = new District("Barrio Bajo", 800);

        Mockito.when(repositoryDistrict.getDistrictByName("Barrio Bajo"))
                .thenReturn(new District("Barrio Bajo", 800));

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        Mockito.when(repositoryHouse.putHouse(HouseMapper.toHouseModel(houseRequestDTO, district))).thenReturn(true);

        // Act
        serviceCalculatorHouse.createNewHouse(houseRequestDTO);

        // Assert
        verify(repositoryHouse, atLeastOnce()).putHouse(HouseMapper.toHouseModel(houseRequestDTO, district));
    }

    @Test
    public void createNewHouseRepeatedHouseException()
            throws DistrictNotFoundException, HouseNotCreatedException {

        House house = new House("Casa1",
                new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        HouseRequestDTO houseRequestDTO = new HouseRequestDTO();
        houseRequestDTO.setHouseName("Casa1");
        houseRequestDTO.setDistrictName("Barrio Bajo");
        houseRequestDTO.setRooms(new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        Mockito.when(repositoryDistrict.getDistrictByName("Barrio Bajo"))
                .thenReturn(new District("Barrio Bajo", 800));

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(house);

        //Mockito.when(repositoryHouse.putHouse(HouseMapper.toHouseModel(houseRequestDTO, district))).thenReturn(false);

        // Act
        boolean received = false;
        try {
            serviceCalculatorHouse.createNewHouse(houseRequestDTO);
        } catch (RepeatedHouseException e) {
            received = true;
        }

        // Assert
        verify(repositoryHouse, atLeastOnce()).getHouseByName("Casa1");
        assertTrue(received);

    }

    @Test
    public void createNewHouseDistrictNotFoundException()
            throws RepeatedHouseException, HouseNotCreatedException {

        HouseRequestDTO houseRequestDTO = new HouseRequestDTO();
        houseRequestDTO.setHouseName("Casa1");
        houseRequestDTO.setDistrictName("Barrio Bajo");
        houseRequestDTO.setRooms(new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        Mockito.when(repositoryDistrict.getDistrictByName("Barrio Bajo"))
                .thenReturn(new District("Barrio Bajo", 800));

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        Mockito.when(repositoryDistrict.getDistrictByName("Barrio Bajo")).thenReturn(null);

        // Act
        boolean received = false;
        try {
            serviceCalculatorHouse.createNewHouse(houseRequestDTO);
        } catch (DistrictNotFoundException e) {
            received = true;
        }

        // Assert
        verify(repositoryDistrict, atLeastOnce()).getDistrictByName("Barrio Bajo");
        assertTrue(received);

    }

    @Test
    public void createNewHouseHouseNotCreatedException()
            throws RepeatedHouseException, DistrictNotFoundException  {

        HouseRequestDTO houseRequestDTO = new HouseRequestDTO();
        houseRequestDTO.setHouseName("Casa1");
        houseRequestDTO.setDistrictName("Barrio Bajo");
        houseRequestDTO.setRooms(new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        District district = new District("Barrio Bajo", 800);

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        Mockito.when(repositoryDistrict.getDistrictByName("Barrio Bajo")).thenReturn(district);

        Mockito.when(repositoryHouse.putHouse(HouseMapper.toHouseModel(houseRequestDTO, district))).thenReturn(false);

        // Act
        boolean received = false;
        try {
            serviceCalculatorHouse.createNewHouse(houseRequestDTO);
        } catch (HouseNotCreatedException e) {
            received = true;
        }

        // Assert
        verify(repositoryDistrict, atLeastOnce()).getDistrictByName("Barrio Bajo");
        assertTrue(received);

    }

    @Test
    public void createNewDistrictCorrectly() throws RepeatedDistrictException, DistrictNotCreatedException {
        District district = new District("Barrio Bajo", 1000);

        Mockito.when(repositoryDistrict.getDistrictByName(district.getDistrictName())).thenReturn(null);
        Mockito.when(repositoryDistrict.putDistrict(district)).thenReturn(true);

        // Act
        serviceCalculatorHouse.createNewDistrict(district);

        // Assert
        verify(repositoryDistrict, atLeastOnce()).putDistrict(district);
    }

    @Test
    public void createNewDistrictRepeatedDistrictException() throws DistrictNotCreatedException {
        District district = new District("Barrio Bajo", 1000);

        Mockito.when(repositoryDistrict.getDistrictByName(district.getDistrictName())).thenReturn(district);

        // Act
        boolean received = false;

        try {
            serviceCalculatorHouse.createNewDistrict(district);
        } catch (RepeatedDistrictException e) {
            received = true;
        }

        // Assert
        verify(repositoryDistrict, atLeastOnce()).getDistrictByName(district.getDistrictName());
        assertTrue(received);
    }

    @Test
    public void createNewDistrictDistrictNotCreatedException() throws RepeatedDistrictException {
        District district = new District("Barrio Bajo", 1000);

        Mockito.when(repositoryDistrict.getDistrictByName(district.getDistrictName())).thenReturn(null);

        Mockito.when(repositoryDistrict.putDistrict(district)).thenReturn(false);

        // Act
        boolean received = false;

        try {
            serviceCalculatorHouse.createNewDistrict(district);
        } catch (DistrictNotCreatedException e) {
            received = true;
        }

        // Assert
        verify(repositoryDistrict, atLeastOnce()).getDistrictByName(district.getDistrictName());
        assertTrue(received);
    }

    @Test
    public void getTotalQuantifyOfHouseCorrectly() throws HouseNotFoundException {
        // Arrange
        HouseTotalQuantityResponseDTO expected = new HouseTotalQuantityResponseDTO("Casa1",
                80000,
                100);

        House house = new House("Casa1",
                new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(house);

        //Act
        HouseTotalQuantityResponseDTO received = serviceCalculatorHouse.getTotalQuantifyOfHouse("Casa1");

        // Assert
        assertEquals(expected, received);

    }

    @Test
    public void getTotalQuantifyOfHouseHouseNotFoundException() {
        // Arrange
        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        //Act
        boolean received = false;
        try {
            HouseTotalQuantityResponseDTO houseTotalQuantityResponseDTO = serviceCalculatorHouse.
                    getTotalQuantifyOfHouse("Casa1");
        } catch (HouseNotFoundException e) {
            received = true;
        }

        // Assert
        assertTrue(received);
    }

    @Test
    public void getHouseBiggestRoomOfHouseCorrectly() throws HouseNotFoundException {
        // Arrange
        HouseBiggestRoomResponseDTO expected = new HouseBiggestRoomResponseDTO("Casa1",
                "Habitación 1",
                100);

        House house = new House("Casa1",
                new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10),
                        new Room("Habitación 2", 9, 9),
                        new Room("Habitación 3", 8, 8))));

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(house);

        //Act
        HouseBiggestRoomResponseDTO received = serviceCalculatorHouse.getHouseBiggestRoomOfHouse("Casa1");

        // Assert
        assertEquals(expected, received);
    }

    @Test
    public void getHouseBiggestRoomOfHouseHouseNotFoundException() {
        // Arrange

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        //Act
        boolean received = false;
        try {
            HouseBiggestRoomResponseDTO houseBiggestRoomResponseDTO = serviceCalculatorHouse.
                    getHouseBiggestRoomOfHouse("Casa1");
        } catch (HouseNotFoundException e) {
            received = true;
        }

        // Assert
        assertTrue(received);
    }

    @Test
    public void getHouseRoomListResponseDTOCorrectly() throws HouseNotFoundException {
        // Arrange
        HouseRoomListResponseDTO expected = new HouseRoomListResponseDTO("Casa1",
                new ArrayList<RoomResponseDTO>(Arrays.asList(new RoomResponseDTO("Habitación 1", 100),
                        new RoomResponseDTO("Habitación 2", 81),
                        new RoomResponseDTO("Habitación 3", 64))));

        House house = new House("Casa1",
                new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10),
                        new Room("Habitación 2", 9, 9),
                        new Room("Habitación 3", 8, 8))));

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(house);

        //Act
        HouseRoomListResponseDTO received = serviceCalculatorHouse.getHouseRoomListResponseDTO("Casa1");

        // Assert
        assertEquals(expected, received);
    }

    @Test
    public void getHouseRoomListResponseDTOHouseNotFoundExceptiony() {
        // Arrange
        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        //Act
        boolean received = false;
        try {
            HouseRoomListResponseDTO houseRoomListResponseDTO = serviceCalculatorHouse
                    .getHouseRoomListResponseDTO("Casa1");
        } catch (HouseNotFoundException e) {
            received = true;
        }

        // Assert
        assertTrue(received);
    }
}
