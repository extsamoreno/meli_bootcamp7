package com.meli.desafio2.Repository;

import com.meli.desafio2.DTOS.DistrictDTO;
import com.meli.desafio2.Exception.DistrictNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
public class DistrictRepositoryTest {
    @Autowired
    private IDistrictRepository districtRepository;


    //Prueba unitaria para validar IllegalArgumentExceptions en el método privado 'loadFromDB' de districtRepository.

    @Test
    void testGetDistrictByNameAndPriceNonExistenFileName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    ReflectionTestUtils.setField(districtRepository, "FILE_NAME", "failTest");
                    ReflectionTestUtils.invokeMethod(districtRepository, "loadFromDB");
                });
    }

    //Prueba unitaria para validar DistrictNotFoundException en el método 'getDistrictByNameAndPrice' de districtRepository.
    //Entradas: nameDistrict incorrecto y priceDistrict correcto.

    @Test
    void testGetDistrictByNameAndPriceDistrictNameNotFound() {
        Assertions.assertThrows(DistrictNotFoundException.class,
                () -> districtRepository.getDistrictByNameAndPrice("Nueva Cordoba", 1000.0),
                "The district with name: Nueva Cordoba and price: 1000.0 doesn't belong to the database.");
    }

    //Prueba unitaria para validar DistrictNotFoundException en el método 'getDistrictByNameAndPrice' de districtsRepository.
    //Entradas: nameDistrict correcto y priceDistrict incorrecto.
    @Test
    void testGetDistrictByNameAndPriceDistrictPriceNotFound() {
        Assertions.assertThrows(DistrictNotFoundException.class,
                () -> districtRepository.getDistrictByNameAndPrice("Alberdi", 4000.0),
                "The district with name: Alberdi and price: 1000.0 doesn't belong to the database.");
    }

    //Prueba unitaria para validad que el metodo 'getDistrictByNameAndPrice' en districtsRepository devuelve el district correcto.
    //Entrada: Valores de district y price correctos.

    @Test
    void testGetDistrictByNameAndPriceValidDistrict() throws NoSuchFieldException {
        // Arrange
        DistrictDTO expectedDistrict = new DistrictDTO();
        expectedDistrict.setNameDistrict("Alberdi");
        expectedDistrict.setPriceDistrict(1000.0);

        // Act
        DistrictDTO responseDistrict = districtRepository.getDistrictByNameAndPrice("Alberdi", 1000.0);

        // Assert
        Assertions.assertEquals(expectedDistrict, responseDistrict);
    }
}
