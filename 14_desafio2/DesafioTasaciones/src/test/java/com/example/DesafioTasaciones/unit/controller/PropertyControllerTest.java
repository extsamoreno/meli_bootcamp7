package com.example.DesafioTasaciones.unit.controller;

import com.example.DesafioTasaciones.controllers.HouseController;
import com.example.DesafioTasaciones.controllers.PropertyController;
import com.example.DesafioTasaciones.dtos.HouseDTO;
import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.services.IHouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.DesafioTasaciones.util.TestUtilGenerator;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {
    @Mock
    IHouseService iHouseService;

    @InjectMocks
    PropertyController propertyController;
    @InjectMocks
    HouseController houseController;

    @Test
    public void registerNewProperty() {
        //Arrange
        HouseDTO houseDTO = TestUtilGenerator.getPropertyDTO("Capital");

        //Act
        ResponseEntity<?> received = propertyController.registerNewProperty(houseDTO);

        //Asset
        Mockito.verify(iHouseService,Mockito.atLeastOnce()).createProperty(houseDTO);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    @Test
    public void getAllProperties() {
        //Arrange
        List<HouseDTO> propertyDTOS = TestUtilGenerator.getPropertiesDTO();
        Mockito.when(iHouseService.getAllProperties()).thenReturn(propertyDTOS);

        //Act
        ResponseEntity<?> received = propertyController.getAllProperties();

        //Asset
        Mockito.verify(iHouseService,Mockito.atLeastOnce()).getAllProperties();
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(propertyDTOS,received.getBody());
    }
    @Test
    public void totalSquareMeters() {
        //Arrange
        Integer propertyId = 1;
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setTotalSquareMeters(40.0);
        Mockito.when(iHouseService.totalSquareMeters(propertyId)).thenReturn(responseDTO);

        //Act
        ResponseEntity<ResponseDTO> received = houseController.totalSquareMeters(propertyId);

        //Asset
        Mockito.verify(iHouseService,Mockito.atLeastOnce()).totalSquareMeters(propertyId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(responseDTO.getTotalSquareMeters(),received.getBody().getTotalSquareMeters());
    }

    @Test
    public void propertyValue() {
        //Arrange
        Integer propertyId = 1;
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setPropertyValue(1000.0);
        Mockito.when(iHouseService.propertyValue(propertyId)).thenReturn(responseDTO);

        //Act
        ResponseEntity<ResponseDTO> received = houseController.propertyValue(propertyId);

        //Asset
        Mockito.verify(iHouseService,Mockito.atLeastOnce()).propertyValue(propertyId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(responseDTO.getPropertyValue(),received.getBody().getPropertyValue());
    }

    @Test
    public void largestEnvironment() {
        //Arrange
        Integer propertyId = 1;
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setLargestEnvironment(new RoomDTO());
        Mockito.when(iHouseService.largestEnvironment(propertyId)).thenReturn(responseDTO);

        //Act
        ResponseEntity<ResponseDTO> received = houseController.largestEnvironment(propertyId);

        //Asset
        Mockito.verify(iHouseService,Mockito.atLeastOnce()).largestEnvironment(propertyId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(responseDTO.getLargestEnvironment(),received.getBody().getLargestEnvironment());
    }

    @Test
    public void roomsSquareMeters() {
        //Arrange
        Integer propertyId = 1;
        ResponseDTO responseDTO = new ResponseDTO();
        List<RoomDTO> environments = new ArrayList<>();
        environments.add(new RoomDTO());
        environments.add(new RoomDTO());
        responseDTO.setRoomsSquareMeters(environments);
        Mockito.when(iHouseService.roomsSquareMeters(propertyId)).thenReturn(responseDTO);

        //Act
        ResponseEntity<ResponseDTO> received = houseController.roomsSquareMeters(propertyId);

        //Asset
        Mockito.verify(iHouseService,Mockito.atLeastOnce()).roomsSquareMeters(propertyId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(responseDTO.getRoomsSquareMeters(),received.getBody().getRoomsSquareMeters());
    }
}
