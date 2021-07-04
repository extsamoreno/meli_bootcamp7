package com.example.CalculadoraMetrosCuadrados.repository;

import com.example.CalculadoraMetrosCuadrados.dto.District;
import com.example.CalculadoraMetrosCuadrados.exceptions.DistrictNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DistrictRepositoryTest {

    @Autowired
    private IDistrictRepository districtRepository;

    /*
     * Test unitario para validación del IllegalArgumentExceptions en el districtsRepository's
     * private method 'loadFromDB'.
     */
    @Test
    void testGetDistrictByNameAndPriceNonExistenFileName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    ReflectionTestUtils.setField(districtRepository, "FILE_NAME", "failTest");
                    ReflectionTestUtils.invokeMethod(districtRepository, "loadFromDB");
                });
    }

    /*
     *  DistrictNotFoundException in districtsRepository's
     * 'getDistrictByNameAndPrice' method when the district's name doesn't
     * belong to the database.
     * Inputs: valid district's price and invalid name.
     */
    @Test
    void testGetDistrictByNameAndPriceDistrictNameNotFound() {
        Assertions.assertThrows(DistrictNotFoundException.class,
                () -> districtRepository.getDistrictByNameAndPrice("Jardin", 1000.0),
                "The district with name: Jardin and price: 1000.0 doesn't belong to the database.");
    }

    /*
     * Unit test for validating DistrictNotFoundException in districtsRepository's
     * 'getDistrictByNameAndPrice' method when the district's price doesn't
     * belong to the database.
     * Inputs: valid district's name and invalid price.
     */
    @Test
    void testGetDistrictByNameAndPriceDistrictPriceNotFound() {
        Assertions.assertThrows(DistrictNotFoundException.class,
                () -> districtRepository.getDistrictByNameAndPrice("Belgrano", 4000.0),
                "The district with name: Jardin and price: 1000.0 doesn't belong to the database.");
    }

    /*
     * Unit test for validating that 'getDistrictByNameAndPrice' method in
     * districtsRepository returns the correct district.
     * Inputs: valid district's name and price.
     */
    @Test
    void testGetDistrictByNameAndPriceValidDistrict() throws NoSuchFieldException {
        // Arrange
        District expectedDistrict = new District();
        expectedDistrict.setDistrictName("Belgrano");
        expectedDistrict.setDistrictPrice(1000.0);

        // Act
        District responseDistrict = districtRepository.getDistrictByNameAndPrice("Belgrano", 1000.0);

        // Assert
        Assertions.assertEquals(expectedDistrict, responseDistrict);
    }
}