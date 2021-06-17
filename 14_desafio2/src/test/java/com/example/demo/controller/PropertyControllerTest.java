package com.example.demo.controller;


import com.example.demo.DTO.*;
import com.example.demo.Utils.UtilTest;
import com.example.demo.controllers.PropertyController;
import com.example.demo.services.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    PropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void getSquareMetersTest() throws Exception {

        ResponseCalculateTotalMetersDTO aux = new ResponseCalculateTotalMetersDTO("House",40);
        when(propertyService.getResponseCalculateTotalMetersDTO(1)).thenReturn(aux);
        Assertions.assertEquals(new ResponseEntity<>(aux, HttpStatus.OK), propertyController.calculateTotalMeters(1));

    }

    @Test
    public void getPriceTest() throws Exception {
        ResponsePriceDTO aux = UtilTest.getResponsePriceDTO(1);
        when(propertyService.getPrice(1)).thenReturn(aux);
        Assertions.assertEquals(new ResponseEntity<>(aux, HttpStatus.OK), propertyController.price(1));
    }

    @Test
    public void biggerEnvironmentTest() throws Exception {
        ResponseBiggerEnvironmentDTO aux = new ResponseBiggerEnvironmentDTO();
        PropertyDTO property = UtilTest.getPropertyDTOWithEnvironments();

        aux.setName(property.getName());
        aux.setEnvironmentName(property.getEnvironments().get(1).getName());
        aux.setBiggerEnvironmentMeters(property.getEnvironments().get(1).getTotalMeters());

        when(propertyService.getBiggerEnvironment(1)).thenReturn(aux);

        Assertions.assertEquals(new ResponseEntity<>(aux, HttpStatus.OK), propertyController.biggerEnvironment(1));
    }

    @Test
    public void totalMetersByEnvironmentTest() throws Exception {
        PropertyDTO property = UtilTest.getPropertyDTOWithEnvironments();

        ResponseTotalMetersByEnvironmentDTO aux = new ResponseTotalMetersByEnvironmentDTO();
        aux.setNameProperty(property.getName());
        aux.setEnvironments(property.getEnvironments());

        when(propertyService.getTotalMetersByEnvironment(1)).thenReturn(aux);
        Assertions.assertEquals(new ResponseEntity<>(aux, HttpStatus.OK), propertyController.totalMetersByEnvironment(1));

    }

    @Test
    public void savePropertyTest() throws Exception {
        PropertyDTO property = UtilTest.getPropertyDTOWithEnvironments();
        Assertions.assertEquals(ResponseEntity.ok().build(), propertyController.addProperty(property));

    }


}
