package com.bootcamp.desafio2.unit.Controller;

import com.bootcamp.desafio2.UtilsGenerator;
import com.bootcamp.desafio2.controller.HouseController;
import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseAlreadyExistsException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.service.IHouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UTHouseController {

    @Mock
    IHouseService houseService;

    @InjectMocks
    HouseController houseController;


    @Test
    public void calculateFeaturesSuccessfullyBody() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        HouseFeaturesDTO expected = UtilsGenerator.generateHouseFeaturesCasa101();
        Mockito.when(houseService.calculateFeatures(prop_name)).thenReturn(expected);

        // Act
        ResponseEntity<?> response = houseController.calculateFeatures(prop_name);

        // Assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).calculateFeatures(prop_name);
        Assertions.assertEquals(expected, response.getBody());
    }

    @Test
    public void calculateFeaturesSuccessfullyStatus() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        HouseFeaturesDTO expected = UtilsGenerator.generateHouseFeaturesCasa101();
        Mockito.when(houseService.calculateFeatures(prop_name)).thenReturn(expected);

        // Act
        ResponseEntity<?> response = houseController.calculateFeatures(prop_name);

        // Assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).calculateFeatures(prop_name);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void calculateFeaturesTrowHouseNotFoundException() throws HouseNotFoundException, DistrictNotFoundException {
        // arrange
        String prop_name = "Casa000";
        Mockito.when(houseService.calculateFeatures(prop_name)).thenThrow(HouseNotFoundException.class);

        // act & assert
        Assertions.assertThrows(HouseNotFoundException.class,() -> houseService.calculateFeatures(prop_name));
    }

    @Test
    public void calculateFeaturesTrowDistrictNotFoundException() throws HouseNotFoundException, DistrictNotFoundException {
        // arrange
        String prop_name = "Casa000";
        Mockito.when(houseService.calculateFeatures(prop_name)).thenThrow(DistrictNotFoundException.class);

        // act & assert
        Assertions.assertThrows(DistrictNotFoundException.class,() -> houseService.calculateFeatures(prop_name));
    }

    @Test
    public void showEnvironmentListSuccessfullyBody() throws HouseNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        ArrayList<EnvironmentShortDTO> expected = UtilsGenerator.showEnvironmentListCasa101();
        Mockito.when(houseService.generateEnvironmentList(prop_name)).thenReturn(expected);

        // Act
        ResponseEntity<?> response = houseController.showEnvironmentList(prop_name);

        // Assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).generateEnvironmentList(prop_name);
        Assertions.assertEquals(expected, response.getBody());
    }

    @Test
    public void showEnvironmentListSuccessfullyStatus() throws HouseNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        ArrayList<EnvironmentShortDTO> expected = UtilsGenerator.showEnvironmentListCasa101();
        Mockito.when(houseService.generateEnvironmentList(prop_name)).thenReturn(expected);

        // Act
        ResponseEntity<?> response = houseController.showEnvironmentList(prop_name);

        // Assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).generateEnvironmentList(prop_name);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void showEnvironmentListTrowHouseNotFoundException() throws HouseNotFoundException {
        // arrange
        String prop_name = "Casa000";
        Mockito.when(houseService.generateEnvironmentList(prop_name)).thenThrow(HouseNotFoundException.class);

        // act & assert
        Assertions.assertThrows(HouseNotFoundException.class,() -> houseService.generateEnvironmentList(prop_name));
    }

    @Test
    public void registerStudentSuccessfully() throws HouseAlreadyExistsException, DistrictNotFoundException {
        // arrange
        HouseDTO newHouseDTO = UtilsGenerator.generateNewHouseDTO();
        Mockito.doNothing().when(houseService).addNewProperty(newHouseDTO);

        // act
        houseController.registerProperty(newHouseDTO);

        // assert
        Mockito.verify(houseService, atLeastOnce()).addNewProperty(newHouseDTO);
    }

    @Test
    public void registerStudentTrowHouseAlreadyExistsException() throws HouseAlreadyExistsException, DistrictNotFoundException {
        // arrange
        String prop_name = "Casa101";
        HouseDTO newHouseDTO = UtilsGenerator.generateNewHouseDTO();
        Mockito.doThrow(HouseAlreadyExistsException.class).doNothing().when(houseService).addNewProperty(newHouseDTO);

        // act & assert
        Assertions.assertThrows(HouseAlreadyExistsException.class,() -> houseService.addNewProperty(newHouseDTO));
    }

    @Test
    public void registerStudentTrowDistrictNotFoundException() throws HouseAlreadyExistsException, DistrictNotFoundException {
        // arrange
        String prop_name = "Casa101";
        HouseDTO newHouseDTO = UtilsGenerator.generateNewHouseDTO();
        Mockito.doThrow(DistrictNotFoundException.class).doNothing().when(houseService).addNewProperty(newHouseDTO);

        // act & assert
        Assertions.assertThrows(DistrictNotFoundException.class,() -> houseService.addNewProperty(newHouseDTO));
    }


}
