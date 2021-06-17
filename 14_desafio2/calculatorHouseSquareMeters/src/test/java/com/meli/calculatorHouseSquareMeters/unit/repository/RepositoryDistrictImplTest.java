package com.meli.calculatorHouseSquareMeters.unit.repository;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryDistrictImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepositoryDistrictImplTest {

    private RepositoryDistrictImpl repositoryDistrict = new RepositoryDistrictImpl();

    @BeforeEach
    public void resetDataBase() {
        repositoryDistrict.resetDataBase();
    }

    @Test
    public void getDistrictByNameCorrectly() {
        // Arrage
        District expected = new District("Barrio Bajo", 800);

        // Act
        District received = repositoryDistrict.getDistrictByName("Barrio Bajo");

        // Assert
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getDistrictByNameError() {
        // Act
        District received = repositoryDistrict.getDistrictByName("Barrio Bajo No Encontrado");

        // Assert
        assertNull(received);
    }

    @Test
    public void putDistrictByNameCorrectly() {
        // Arrage
        District district = new District("Barrio Nuevo", 1000);

        // Act
        boolean received = repositoryDistrict.putDistrict(district);

        // Assert
        assertTrue(received);
    }

    @Test
    public void putDistrictByNameError() {
        // Arrage
        District district = new District("Barrio Bajo", 1000);

        // Act
        boolean received = repositoryDistrict.putDistrict(district);

        // Assert
        assertFalse(received);
    }
}
