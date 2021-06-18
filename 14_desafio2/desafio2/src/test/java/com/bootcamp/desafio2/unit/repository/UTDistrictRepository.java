package com.bootcamp.desafio2.unit.repository;

import com.bootcamp.desafio2.UtilsGenerator;
import com.bootcamp.desafio2.entity.House;
import com.bootcamp.desafio2.repository.district.DistrictRepositoryImpl;
import com.bootcamp.desafio2.repository.house.HouseRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class UTDistrictRepository {

    DistrictRepositoryImpl repo = new DistrictRepositoryImpl();
    HashMap<String, Double> districtsDB = repo.loadDateBase();

    @Test
    public void existsDistrictInDBTrue() {
        // Arrange
        String district_name = "Carmen";

        // Act & Assert
        Assertions.assertTrue(repo.existsDistrictInDB(district_name));
    }

    @Test
    public void existsPropertyNameFalse() {
        // Arrange
        String district_name = "Kennedy";

        // Act & Assert
        Assertions.assertFalse(repo.existsDistrictInDB(district_name));
    }

    @Test
    public void getDistrictPriceSuccessfully() {
        // Arrange
        String district_name = "Carmen";
        double expectedPrice = 800.0;

        // Act
        double response = repo.getDistrictPrice(district_name);

        // Assert
        Assertions.assertEquals(expectedPrice, response);
    }

    @Test
    public void findHouseByPropNameNull() {
        // Arrange
        String district_name = "Kennedy";

        // Act & Assert
        Assertions.assertEquals(null, repo.getDistrictPrice(district_name));
    }

}
