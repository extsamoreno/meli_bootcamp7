package com.bootcamp.desafio2.unit.repository;

import com.bootcamp.desafio2.UtilsGenerator;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.entity.House;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.repository.house.HouseRepositoryImpl;
import com.bootcamp.desafio2.repository.house.IHouseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class UTHouseRepository {

    HouseRepositoryImpl repo = new HouseRepositoryImpl();
    HashMap<String, House> propertiesDB = repo.loadDateBase();

    @Test
    public void existsPropertyNameTrue() {
        // Arrange
        String prop_name = "Casa101";

        // Act & Assert
        Assertions.assertTrue(repo.existsPropertyName(prop_name));
    }

    @Test
    public void existsPropertyNameFalse() {
        // Arrange
        String prop_name = "Casa000";

        // Act & Assert
        Assertions.assertFalse(repo.existsPropertyName(prop_name));
    }

    @Test
    public void findHouseByPropNameSuccessfully() {
        // Arrange
        String prop_name = "Casa101";
        House expectedHouse = UtilsGenerator.genererateHouse();

        // Act
        House response = repo.findHouseByPropName(prop_name);

        // Assert
        Assertions.assertEquals(expectedHouse, response);
    }

    @Test
    public void findHouseByPropNameNull() {
        // Arrange
        String prop_name = "Casa000";

        // Act
        House response = repo.findHouseByPropName(prop_name);

        // Assert
        Assertions.assertNull(response);
    }

}
