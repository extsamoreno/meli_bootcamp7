package com.meli.calculatorHouseSquareMeters.unit.controller;

import com.meli.calculatorHouseSquareMeters.controller.CalculatorHouseController;
import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dto.*;
import com.meli.calculatorHouseSquareMeters.model.exception.*;
import com.meli.calculatorHouseSquareMeters.model.service.ServiceCalculatorHouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CalculatorHouseControllerTest {
    @Mock
    ServiceCalculatorHouse serviceCalculatorHouse;

    @InjectMocks
    CalculatorHouseController calculatorHouseController;

    @Test
    public void createNewHouseCorrectly()
            throws RepeatedHouseException, DistrictNotFoundException, HouseNotCreatedException {
        // Arrange
        HouseRequestDTO houseRequestDTO = new HouseRequestDTO("Casa1",
                "Barrio Bajo", new ArrayList<Room>(Arrays.asList(
                        new Room("Habitación 1", 10, 10),
                        new Room("Habitación 2", 9, 9),
                        new Room("Habitación 3", 8, 8)
                )));

        Mockito.doNothing().when(serviceCalculatorHouse).createNewHouse(houseRequestDTO);

        // Act
        ResponseEntity<?> received = calculatorHouseController.createNewHouse(houseRequestDTO);

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).createNewHouse(houseRequestDTO);
        assertThat(received.getStatusCode().is2xxSuccessful());

    }

    @Test
    public void createNewHouseRepeatedHouseException()
            throws DistrictNotFoundException, HouseNotCreatedException, RepeatedHouseException {
        // Arrange
        RepeatedHouseException expected = new RepeatedHouseException("Casa1");

        HouseRequestDTO houseRequestDTO = new HouseRequestDTO("Casa1",
                "Barrio Bajo", new ArrayList<Room>(Arrays.asList(
                new Room("Habitación 1", 10, 10),
                new Room("Habitación 2", 9, 9),
                new Room("Habitación 3", 8, 8)
        )));

        Mockito.doThrow(new RepeatedHouseException(houseRequestDTO.getHouseName()))
                .when(serviceCalculatorHouse).createNewHouse(houseRequestDTO);

        // Act
        RepeatedHouseException received = null;
        try {
            ResponseEntity<?> responseEntity = calculatorHouseController.createNewHouse(houseRequestDTO);
        } catch (RepeatedHouseException e) {
            received = e;
        }

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).createNewHouse(houseRequestDTO);
        Assertions.assertEquals(expected.getError().getMessage(), received.getError().getMessage());

    }

    @Test
    public void createNewHouseDistrictNotFoundException()
            throws DistrictNotFoundException, HouseNotCreatedException, RepeatedHouseException {
        // Arrange
        DistrictNotFoundException expected = new DistrictNotFoundException("Barrio BajoError");

        HouseRequestDTO houseRequestDTO = new HouseRequestDTO("Casa1",
                "Barrio BajoError", new ArrayList<Room>(Arrays.asList(
                new Room("Habitación 1", 10, 10),
                new Room("Habitación 2", 9, 9),
                new Room("Habitación 3", 8, 8)
        )));

        Mockito.doThrow(new DistrictNotFoundException(houseRequestDTO.getDistrictName()))
                .when(serviceCalculatorHouse).createNewHouse(houseRequestDTO);

        // Act
        DistrictNotFoundException received = null;
        try {
            ResponseEntity<?> responseEntity = calculatorHouseController.createNewHouse(houseRequestDTO);
        } catch (DistrictNotFoundException e) {
            received = e;
        }

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).createNewHouse(houseRequestDTO);
        Assertions.assertEquals(expected.getError().getMessage(), received.getError().getMessage());

    }

    @Test
    public void createNewHouseHouseNotCreatedException()
            throws DistrictNotFoundException, HouseNotCreatedException, RepeatedHouseException {
        // Arrange
        HouseNotCreatedException expected = new HouseNotCreatedException("Casa1");

        HouseRequestDTO houseRequestDTO = new HouseRequestDTO("Casa1",
                "Barrio Bajo", new ArrayList<Room>(Arrays.asList(
                new Room("Habitación 1", 10, 10),
                new Room("Habitación 2", 9, 9),
                new Room("Habitación 3", 8, 8)
        )));

        Mockito.doThrow(new HouseNotCreatedException(houseRequestDTO.getHouseName()))
                .when(serviceCalculatorHouse).createNewHouse(houseRequestDTO);

        // Act
        HouseNotCreatedException received = null;
        try {
            ResponseEntity<?> responseEntity = calculatorHouseController.createNewHouse(houseRequestDTO);
        } catch (HouseNotCreatedException e) {
            received = e;
        }

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).createNewHouse(houseRequestDTO);
        Assertions.assertEquals(expected.getError().getMessage(), received.getError().getMessage());

    }

    @Test
    public void createNewDistrictCorrectly() throws RepeatedDistrictException, DistrictNotCreatedException {
        // Arrange
        District district = new District("Barrio Nuevo", 1000);

        Mockito.doNothing().when(serviceCalculatorHouse).createNewDistrict(district);

        // Act
        ResponseEntity<?> received = calculatorHouseController.createNewDistrict(district);

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).createNewDistrict(district);
        assertThat(received.getStatusCode().is2xxSuccessful());

    }

    @Test
    public void createNewDistrictRepeatedDistrictException()
            throws RepeatedDistrictException, DistrictNotCreatedException {
        // Arrange
        RepeatedDistrictException expected = new RepeatedDistrictException("Barrio Nuevo");

        District district = new District("Barrio Nuevo", 1000);

        Mockito.doThrow(new RepeatedDistrictException(district.getDistrictName()))
                .when(serviceCalculatorHouse).createNewDistrict(district);

        // Act
        RepeatedDistrictException received = null;
        try {
            ResponseEntity<?> responseEntity = calculatorHouseController.createNewDistrict(district);
        } catch (RepeatedDistrictException e) {
            received = e;
        }

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).createNewDistrict(district);
        Assertions.assertEquals(expected.getError().getMessage(), received.getError().getMessage());

    }

    @Test
    public void createNewDistrictDistrictNotCreatedException()
            throws RepeatedDistrictException, DistrictNotCreatedException {
        // Arrange
        DistrictNotCreatedException expected = new DistrictNotCreatedException("Barrio Nuevo");

        District district = new District("Barrio Nuevo", 1000);

        Mockito.doThrow(new DistrictNotCreatedException(district.getDistrictName()))
                .when(serviceCalculatorHouse).createNewDistrict(district);

        // Act
        DistrictNotCreatedException received = null;
        try {
            ResponseEntity<?> responseEntity = calculatorHouseController.createNewDistrict(district);
        } catch (DistrictNotCreatedException e) {
            received = e;
        }

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).createNewDistrict(district);
        Assertions.assertEquals(expected.getError().getMessage(), received.getError().getMessage());

    }

    @Test
    public void getTotalQuantityCorrectly() throws HouseNotFoundException {
        // Arrange
        HouseTotalQuantityResponseDTO expected = new HouseTotalQuantityResponseDTO(
                "Casa 1",80000, 100);

        Mockito.when(serviceCalculatorHouse.getTotalQuantifyOfHouse("Casa 1"))
                .thenReturn(expected);

        // Act
        ResponseEntity<HouseTotalQuantityResponseDTO> received = calculatorHouseController
                .getTotalQuantity("Casa 1");

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).getTotalQuantifyOfHouse("Casa 1");
        Assertions.assertEquals(expected.toString(), received.getBody().toString());

    }

    @Test
    public void getTotalQuantityHouseNotFoundException() throws HouseNotFoundException {
        // Arrange
        HouseNotFoundException expected = new HouseNotFoundException("Casa 1");

        Mockito.doThrow(new HouseNotFoundException("Casa 1")).when(serviceCalculatorHouse)
                .getTotalQuantifyOfHouse("Casa 1");

        // Act
        HouseNotFoundException received = null;
        try {
            ResponseEntity<HouseTotalQuantityResponseDTO> responseEntity = calculatorHouseController
                    .getTotalQuantity("Casa 1");
        } catch (HouseNotFoundException e) {
            received = e;
        }


        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).getTotalQuantifyOfHouse("Casa 1");
        Assertions.assertEquals(expected.getError().getMessage(), received.getError().getMessage());

    }

    @Test
    public void getBiggestRoomCorrectly() throws HouseNotFoundException {
        // Arrange
        HouseBiggestRoomResponseDTO expected = new HouseBiggestRoomResponseDTO(
                "Casa 1","Habitación 1", 100);

        Mockito.when(serviceCalculatorHouse.getHouseBiggestRoomOfHouse("Casa 1"))
                .thenReturn(expected);

        // Act
        ResponseEntity<HouseBiggestRoomResponseDTO> received = calculatorHouseController
                .getBiggestRoom("Casa 1");

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).getHouseBiggestRoomOfHouse("Casa 1");
        Assertions.assertEquals(expected.toString(), received.getBody().toString());

    }

    @Test
    public void getBiggestRoomHouseNotFoundException() throws HouseNotFoundException {
        /// Arrange
        HouseNotFoundException expected = new HouseNotFoundException("Casa 1");

        Mockito.doThrow(new HouseNotFoundException("Casa 1")).when(serviceCalculatorHouse)
                .getHouseBiggestRoomOfHouse("Casa 1");

        // Act
        HouseNotFoundException received = null;
        try {
            ResponseEntity<HouseBiggestRoomResponseDTO> responseEntity = calculatorHouseController
                    .getBiggestRoom("Casa 1");
        } catch (HouseNotFoundException e) {
            received = e;
        }


        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).getHouseBiggestRoomOfHouse("Casa 1");
        Assertions.assertEquals(expected.getError().getMessage(), received.getError().getMessage());

    }

    @Test
    public void getRoomListCorrectly() throws HouseNotFoundException {
        // Arrange
        HouseRoomListResponseDTO expected = new HouseRoomListResponseDTO("Casa 1",
                new ArrayList<RoomResponseDTO>(Arrays.asList(new RoomResponseDTO("Habitación 1", 100),
                        new RoomResponseDTO("Habitación 2", 81),
                        new RoomResponseDTO("Habitación 3", 64))));

        Mockito.when(serviceCalculatorHouse.getHouseRoomListResponseDTO("Casa 1"))
                .thenReturn(expected);

        // Act
        ResponseEntity<HouseRoomListResponseDTO> received = calculatorHouseController
                .getRoomList("Casa 1");

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).getHouseRoomListResponseDTO("Casa 1");
        Assertions.assertEquals(expected.toString(), received.getBody().toString());

    }

    @Test
    public void getRoomListHouseNotFoundException() throws HouseNotFoundException {
        /// Arrange
        HouseNotFoundException expected = new HouseNotFoundException("Casa 1");

        Mockito.doThrow(new HouseNotFoundException("Casa 1")).when(serviceCalculatorHouse)
                .getHouseRoomListResponseDTO("Casa 1");

        // Act
        HouseNotFoundException received = null;
        try {
            ResponseEntity<HouseRoomListResponseDTO> responseEntity = calculatorHouseController
                    .getRoomList("Casa 1");
        } catch (HouseNotFoundException e) {
            received = e;
        }

        // Assert
        Mockito.verify(serviceCalculatorHouse, Mockito.atLeastOnce()).getHouseRoomListResponseDTO("Casa 1");
        Assertions.assertEquals(expected.getError().getMessage(), received.getError().getMessage());

    }
}
