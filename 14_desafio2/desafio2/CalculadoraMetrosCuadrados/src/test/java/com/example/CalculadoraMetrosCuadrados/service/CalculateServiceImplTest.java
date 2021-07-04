package com.example.CalculadoraMetrosCuadrados.service;

import com.example.CalculadoraMetrosCuadrados.BaseTest;
import com.example.CalculadoraMetrosCuadrados.dto.*;
import com.example.CalculadoraMetrosCuadrados.exceptions.DistrictNotFoundException;
import com.example.CalculadoraMetrosCuadrados.repository.IDistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class CalculateServiceImplTest extends BaseTest {

    @Autowired
    private CalculateServiceImpl calculateService;

    @MockBean
    private IDistrictRepository districtRepository;

    /*
     * Unit test for validating the total square feet of a house.
     * Inputs: HouseDTO, which properties contains all valid values.
     */
    @Test
    void testCalculateTotalSquareFeetValidInput() {
        // Arrange
        // Response
        HouseResponseTotalSquareFeetDTO expectedDTO = new HouseResponseTotalSquareFeetDTO(18);

        // Act
        HouseResponseTotalSquareFeetDTO responseDTO = calculateService.calculateTotalSquareFeet(payloadHouseDTO);

        // Assert
        Assertions.assertEquals(expectedDTO, responseDTO);
    }

    /*
     * Unit test for validating the price of a house based in it's total square feet.
     * Inputs: HouseDTO, which properties contains all valid values.
     */
    @Test
    void testCalculatePriceValidInput() throws NoSuchFieldException {
        // Arrange
        // Response
        HouseResponseValueDTO expectedDTO = new HouseResponseValueDTO(18000.0);

        Mockito.when(districtRepository.getDistrictByNameAndPrice("Belgrano", 1000.0)).thenReturn(new District("Belgrano", 1000.0));

        // Act
        HouseResponseValueDTO responseDTO = calculateService.calculatePrice(payloadHouseDTO);

        // Assert
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).getDistrictByNameAndPrice("Belgrano", 1000.0);
        Assertions.assertEquals(expectedDTO, responseDTO);
    }

    /*
     * Unit test for validating DistrictNotFoundException when calculating the price
     * of a house when the district's name doesn't belong to the districts' Json file.
     */
    @Test
    void testCalculatePriceDistrictNameNotFound() throws NoSuchFieldException {
        // Arrange
        Mockito.when(districtRepository.getDistrictByNameAndPrice("Belgrano", 1000.0)).thenThrow(DistrictNotFoundException.class);

        // Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> calculateService.calculatePrice(payloadHouseDTO));
    }

    /*
     * Unit test for validating DistrictNotFoundException when calculating the price
     * of a house when the district's price doesn't belong to the districts' Json file.
     */
    @Test
    void testCalculatePriceDistrictPriceNotFound() throws NoSuchFieldException {
        // Arrange
        Mockito.when(districtRepository.getDistrictByNameAndPrice("Belgrano", 1000.0)).thenThrow(DistrictNotFoundException.class);

        // Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> calculateService.calculatePrice(payloadHouseDTO));
    }

    /*
     * Unit test for validating the biggest room in a house.
     * Inputs: HouseDTO, which properties contains all valid values.
     */
    @Test
    void testGetBiggestRoomValidInput() {
        // Arrange
        // Response
        RoomDTO expectedDTO = new RoomDTO("Cocina", 2, 4);

        // Act
        RoomDTO responseDTO = calculateService.getBiggestRoom(payloadHouseDTO);

        // Assert
        Assertions.assertEquals(expectedDTO, responseDTO);
    }

    /*
     * Unit test for validating the total square feet of each room in a house.
     * Inputs: HouseDTO, which properties contains all valid values.
     */
    @Test
    void testCalculateSquareFeetPerRoomValidInput() throws NoSuchFieldException {
        // Arrange
        // Response
        RoomSquareFeetDTO roomSq1 = new RoomSquareFeetDTO("Habitacion", 6);
        RoomSquareFeetDTO roomSq2 = new RoomSquareFeetDTO("Cocina", 8);
        RoomSquareFeetDTO roomSq3 = new RoomSquareFeetDTO("Banio", 4);

        HouseResponseSquareFeetPerRoomDTO expectedDTO = new HouseResponseSquareFeetPerRoomDTO(List.of(roomSq1, roomSq2, roomSq3));

        // Act
        HouseResponseSquareFeetPerRoomDTO responseDTO = calculateService.calculateSquareFeetPerRoom(payloadHouseDTO);

        // Assert
        Assertions.assertEquals(expectedDTO, responseDTO);
    }
}