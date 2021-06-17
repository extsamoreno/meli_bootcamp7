package com.bootcamp.desafio2.unit.Service;

import com.bootcamp.desafio2.UtilsGenerator;
import com.bootcamp.desafio2.controller.HouseController;
import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.entity.House;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseAlreadyExistsException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.repository.district.IDistrictRepository;
import com.bootcamp.desafio2.repository.house.IHouseRepository;
import com.bootcamp.desafio2.service.HouseServiceImpl;
import com.bootcamp.desafio2.service.IHouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class UTHouseServiceImpl {

    @Mock
    IHouseRepository houseRepository;

    @Mock
    IDistrictRepository districtRepository;

    @InjectMocks
    HouseServiceImpl houseService;

    @Test
    public void calculateFeaturesSuccessfullyComplete() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();
        HouseFeaturesDTO expected = UtilsGenerator.generateHouseFeaturesCasa101();

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);

        // Assert
        Mockito.verify(houseRepository, Mockito.atLeastOnce()).findHouseByPropName(prop_name);
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).existsDistrictInDB(district_name);
        Assertions.assertEquals(expected, response);
    }

    @Test
    public void calculateFeaturesTotalAreaSuccessfully() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        Double expectedTotalArea = 24.0;

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);
        Double actualTotalArea = response.getTotal_area();

        // Assert
        Mockito.verify(houseRepository, Mockito.atLeastOnce()).findHouseByPropName(prop_name);
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).existsDistrictInDB(district_name);
        Assertions.assertEquals(expectedTotalArea, actualTotalArea);
    }

    @Test
    public void calculateFeaturesBiggestEnvironmentSuccessfully() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        EnvironmentShortDTO expected_biggest_environment = new EnvironmentShortDTO("Room1", 15.0);

        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);
        EnvironmentShortDTO actual_biggest_environment = response.getBiggest_environment();

        // Assert
        Mockito.verify(houseRepository, Mockito.atLeastOnce()).findHouseByPropName(prop_name);
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).existsDistrictInDB(district_name);
        Assertions.assertEquals(expected_biggest_environment, actual_biggest_environment);
    }

    @Test
    public void calculateFeaturesPriceSuccessfully() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        Double expectedPrice = 12000.0;

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);
        Double actualPrice = response.getPrice();

        // Assert
        Mockito.verify(houseRepository, Mockito.atLeastOnce()).findHouseByPropName(prop_name);
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).existsDistrictInDB(district_name);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void calculateFeaturesProp_NameSuccessfully() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);
        String actual_prop_name = response.getProp_name();

        // Assert
        Mockito.verify(houseRepository, Mockito.atLeastOnce()).findHouseByPropName(prop_name);
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).existsDistrictInDB(district_name);
        Assertions.assertEquals(prop_name, actual_prop_name);
    }

    @Test
    public void calculateFeaturesTrowHouseNotFoundException() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa000";
        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(false);

        // Act & Assert
        Assertions.assertFalse(houseRepository.existsPropertyName(prop_name));
        Assertions.assertThrows(HouseNotFoundException.class,() -> houseService.calculateFeatures(prop_name));
    }

    @Test
    public void calculateFeaturesTroDistrictNotFoundException() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when(districtRepository.existsDistrictInDB(district_name)).thenReturn(false);

        // Act & Assert
        Assertions.assertFalse(districtRepository.existsDistrictInDB(district_name));
        Assertions.assertThrows(DistrictNotFoundException.class,() -> houseService.calculateFeatures(prop_name));
    }

    @Test
    public void generateEnvironmentListSuccessfully() throws HouseNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        House modelHouse = UtilsGenerator.genererateHouse();
        ArrayList<EnvironmentShortDTO> expected = UtilsGenerator.showEnvironmentListCasa101() ;

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);

        // Act
        ArrayList<EnvironmentShortDTO> response = houseService.generateEnvironmentList(prop_name);

        // Assert
        Mockito.verify(houseRepository, Mockito.atLeastOnce()).findHouseByPropName(prop_name);
        Mockito.verify(houseRepository, Mockito.atLeastOnce()).existsPropertyName(prop_name);
        Assertions.assertEquals(expected, response);
    }

    @Test
    public void generateEnvironmentListTrowHouseNotFoundException() throws HouseNotFoundException {
        // Arrange
        String prop_name = "Casa000";
        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(false);

        // Act & Assert
        Assertions.assertFalse(houseRepository.existsPropertyName(prop_name));
        Assertions.assertThrows(HouseNotFoundException.class,() -> houseService.generateEnvironmentList(prop_name));
    }

    /*
    @Test
    public void addNewPropertySuccessfully() throws HouseAlreadyExistsException, DistrictNotFoundException {
        // arrange
        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        double district_price = 500.0;
        HouseDTO newHouseDTO = UtilsGenerator.generateNewHouseDTO();
        House modelHouse = UtilsGenerator.genererateHouse();

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(false);
        Mockito.when(districtRepository.existsDistrictInDB(district_name)).thenReturn(true);

        Mockito.when(districtRepository.getDistrictPrice(district_name)).thenReturn(district_price);

        Mockito.doNothing().when(houseRepository).saveNewProperty(modelHouse);

        // act
        houseService.addNewProperty(newHouseDTO);

        // assert
        Mockito.verify(houseRepository, atLeastOnce()).existsPropertyName(prop_name);
        Mockito.verify(houseRepository, atLeastOnce()).saveNewProperty(modelHouse);
        Mockito.verify(districtRepository, atLeastOnce()).existsDistrictInDB(district_name);
    }

/*

    void addNewProperty(HouseDTO houseDTO) throws DistrictNotFoundException, HouseAlreadyExistsException;

 */

}
