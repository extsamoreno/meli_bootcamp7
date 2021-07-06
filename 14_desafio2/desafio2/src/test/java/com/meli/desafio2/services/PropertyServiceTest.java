package com.meli.desafio2.services;

import com.meli.desafio2.BaseTest;
import com.meli.desafio2.dtos.*;
import com.meli.desafio2.exceptions.DistrictNotFoundException;
import com.meli.desafio2.repositories.IDistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class PropertyServiceTest extends BaseTest {
    @Autowired
    private PropertyService propertyService;

    @MockBean
    private IDistrictRepository districtRepository;


     //Prueba unitaria para validar el valor total de los metros cuadrados de una propiedad.
     //Entrada: PropertyDTO con valores validos

    @Test
    void testCalculateTotalSquareMetersValidInput() {
        // Arrange
        // Response
        PropertyResponseTotalSquareMetersDTO expectedDTO = new PropertyResponseTotalSquareMetersDTO(18);

        // Act
        PropertyResponseTotalSquareMetersDTO responseDTO = propertyService.calculateTotalSquareMeters(payloadPropertyDTO);

        // Assert
        Assertions.assertEquals(expectedDTO, responseDTO);
    }

     //Prueba unitaria para validar el precio de una propiedad en base a sus metros cuadrados.
     //Entrada: PropertyDTO con todos los valores validos

    @Test
    void testCalculatePriceValidInput() throws NoSuchFieldException {
        // Arrange
        // Response
        PropertyResponseValueDTO expectedDTO = new PropertyResponseValueDTO(18000.0);

        Mockito.when(districtRepository.getDistrictByNameAndPrice("Alberdi", 1000.0)).thenReturn(new DistrictDTO("Alberdi", 1000.0));

        // Act
        PropertyResponseValueDTO responseDTO = propertyService.calculatePrice(payloadPropertyDTO);

        // Assert
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).getDistrictByNameAndPrice("Alberdi", 1000.0);
        Assertions.assertEquals(expectedDTO, responseDTO);
    }

     //Prueba unitaria para validar DistrictNotFoundException al calcular el precio de una casa cuando el nombre del distrito no pertenece al archivo Json de los districts.

    @Test
    void testCalculatePriceDistrictNameNotFound() throws NoSuchFieldException {
        // Arrange
        Mockito.when(districtRepository.getDistrictByNameAndPrice("Alberdi", 1000.0)).thenThrow(DistrictNotFoundException.class);

        // Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyService.calculatePrice(payloadPropertyDTO));
    }

    //Prueba unitaria para validar DistrictNotFoundException al calcular el precio de una casa cuando el precio del distrito no pertenece al archivo Json de los districts.

    @Test
    void testCalculatePriceDistrictPriceNotFound() throws NoSuchFieldException {
        // Arrange
        Mockito.when(districtRepository.getDistrictByNameAndPrice("Alberdi", 1000.0)).thenThrow(DistrictNotFoundException.class);

        // Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyService.calculatePrice(payloadPropertyDTO));
    }

     //Prueba unitaria para validar el ambiente mas grande
     //Entrada: PropertyDTO con todos los valores validos

    @Test
    void testGetBiggestEnvironmentValidInput() {
        // Arrange
        // Response
        EnvironmentDTO expectedDTO = new EnvironmentDTO("Cocina", 2, 4);

        // Act
        EnvironmentDTO responseDTO = propertyService.getBiggestEnvironment(payloadPropertyDTO);

        // Assert
        Assertions.assertEquals(expectedDTO, responseDTO);
    }

     //Prueba unitaria para validar el total de los metros cuadrados por ambiente
     //Entrada: PropertyDTO con todos los valores validos

    @Test
    void testCalculateSquareMetersPerRoomValidInput() throws NoSuchFieldException {
        // Arrange
        // Response
        EnvironmentSquareMetersDTO environmentSM1 = new EnvironmentSquareMetersDTO("Habitacion", 6);
        EnvironmentSquareMetersDTO environmentSM2 = new EnvironmentSquareMetersDTO("Cocina", 8);
        EnvironmentSquareMetersDTO environmentSM3 = new EnvironmentSquareMetersDTO("Banio", 4);

        PropertyResponseSquareMetersPerEnvDTO expectedDTO = new PropertyResponseSquareMetersPerEnvDTO(List.of(environmentSM1, environmentSM2, environmentSM3));

        // Act
        PropertyResponseSquareMetersPerEnvDTO responseDTO = propertyService.calculateSquareMetersPerEnv(payloadPropertyDTO);

        // Assert
        Assertions.assertEquals(expectedDTO, responseDTO);
    }
}
