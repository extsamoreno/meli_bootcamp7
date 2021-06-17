package com.example.DesafioTasaciones.unit.controller;

import com.example.DesafioTasaciones.controllers.PropertyController;
import com.example.DesafioTasaciones.dtos.HouseDTO;
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
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {
    @Mock
    IHouseService iHouseService;

    @InjectMocks
    PropertyController propertyController;

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
}
