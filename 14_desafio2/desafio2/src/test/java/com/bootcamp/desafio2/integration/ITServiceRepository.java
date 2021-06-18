package com.bootcamp.desafio2.integration;

import com.bootcamp.desafio2.UtilsGenerator;
import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.entity.House;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseAlreadyExistsException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.service.IHouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.atLeastOnce;

@SpringBootTest
public class ITServiceRepository {

    @Autowired
    IHouseService houseService;

    @Test
    public void calculateFeaturesSuccessfullyComplete() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        HouseFeaturesDTO expected = UtilsGenerator.generateHouseFeaturesCasa101();

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);

        // Assert
        Assertions.assertEquals(expected, response);
    }

    @Test
    public void calculateFeaturesTotalAreaSuccessfully() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";

        Double expectedTotalArea = 24.0;

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);
        Double actualTotalArea = response.getTotal_area();

        // Assert
        Assertions.assertEquals(expectedTotalArea, actualTotalArea);
    }

    @Test
    public void calculateFeaturesBiggestEnvironmentSuccessfully() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";

        EnvironmentShortDTO expected_biggest_environment = new EnvironmentShortDTO("Room1", 15.0);

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);
        EnvironmentShortDTO actual_biggest_environment = response.getBiggest_environment();

        // Assert
        Assertions.assertEquals(expected_biggest_environment, actual_biggest_environment);
    }

    @Test
    public void calculateFeaturesPriceSuccessfully() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";

        Double expectedPrice = 12000.0;

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);
        Double actualPrice = response.getPrice();

        // Assert
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void calculateFeaturesProp_NameSuccessfully() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);
        String actual_prop_name = response.getProp_name();

        // Assert
        Assertions.assertEquals(prop_name, actual_prop_name);
    }

    @Test
    public void calculateFeaturesTrowHouseNotFoundException() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa000";

        // Act & Assert
        Assertions.assertThrows(HouseNotFoundException.class,() -> houseService.calculateFeatures(prop_name));
    }

    @Test
    public void calculateFeaturesTroDistrictNotFoundException() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa103";  // This property is in propertiesDB, but the district_name "Restrepo" is not in districtDB

        // Act & Assert
        Assertions.assertThrows(DistrictNotFoundException.class,() -> houseService.calculateFeatures(prop_name));
    }

    @Test
    public void addNewPropertySuccessfully() throws HouseAlreadyExistsException, DistrictNotFoundException {
        // arrange
        HouseDTO newHouseDTO = UtilsGenerator.generateNewHouseDTO();

        // act
        houseService.addNewProperty(newHouseDTO);
    }

    @Test
    public void addNewPropertyTrowDistrictNotFoundException() throws HouseAlreadyExistsException, DistrictNotFoundException {
        // arrange
        String prop_name = "Apto101";
        HouseDTO newHouseDTO = UtilsGenerator.generateNewHouseDTO();
        newHouseDTO.setDistrict_name("Molinos");


        // Act & Assert
        Assertions.assertThrows(DistrictNotFoundException.class,() -> houseService.addNewProperty(newHouseDTO));
    }

    @Test
    public void addNewPropertyTrowHouseAlreadyExistsException() throws HouseAlreadyExistsException, DistrictNotFoundException {
        // arrange
        String prop_name = "Casa101";
        HouseDTO newHouseDTO = UtilsGenerator.generateNewHouseDTO();
        newHouseDTO.setProp_name(prop_name);

        // Act & Assert
        Assertions.assertThrows(HouseAlreadyExistsException.class, () -> houseService.addNewProperty(newHouseDTO));
    }
}
