package com.meli.TuCasitaTasaciones.controllerTest;

import com.meli.TuCasitaTasaciones.controller.PropertyController;
import com.meli.TuCasitaTasaciones.model.*;
import com.meli.TuCasitaTasaciones.service.IPropertyService;
import com.meli.TuCasitaTasaciones.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTests {

    @Mock
    IPropertyService service;

    @InjectMocks
    PropertyController controller;

    @Test
    public void addPropertyHappyPath() {
        // arrange
         PropertyDTO pro = TestUtilsGenerator.getPropertyDTO();

        // act
        int httpStatusReceived = controller.addProperty(pro).getStatusCodeValue();

        // assert
        verify(service, atLeastOnce()).addProperty(pro);
        Assertions.assertEquals(201, httpStatusReceived);
    }

    @Test
    public void calculateAreaHappyPath() {
        // arrange
        EnvironmentListDTO env = TestUtilsGenerator.getEnvironments();
        when(service.calculateArea(env)).thenReturn(44.0);

        // act
        double received = controller.calculateArea(env).getBody();
        int httpStatusReceived = controller.calculateArea(env).getStatusCodeValue();

        // assert
        verify(service, atLeastOnce()).calculateArea(env);
        Assertions.assertEquals(received, 44);
        Assertions.assertEquals(httpStatusReceived, 200);
    }

    @Test
    public void calculatePriceHappyPath() {
        // arrange
        HouseDTO h = TestUtilsGenerator.getHouseDTO();
        when(service.calculatePrice(h)).thenReturn(44.0);

        // act
        double received = controller.calculatePrice(h).getBody();
        int httpStatusReceived = controller.calculatePrice(h).getStatusCodeValue();

        // assert
        verify(service, atLeastOnce()).calculatePrice(h);
        Assertions.assertEquals(received, 44);
        Assertions.assertEquals(httpStatusReceived, 200);
    }

    @Test
    public void environmentsBiggestHappyPath() {
        // arrange
        EnvironmentListDTO env = TestUtilsGenerator.getEnvironments();

        EnvironmentAreaResponseDTO e = TestUtilsGenerator.getEnvironmentAreaResponseDTO();
        when(service.environmentsBiggest(env)).thenReturn(e);

        // act
        EnvironmentAreaResponseDTO received = controller.environmentsBiggest(env).getBody();
        int httpStatusReceived = controller.environmentsBiggest(env).getStatusCodeValue();

        // assert
        verify(service, atLeastOnce()).environmentsBiggest(env);
        Assertions.assertEquals(received, e);
        Assertions.assertEquals(httpStatusReceived, 200);
    }

    @Test
    public void environmentAreaHappyPath() {
        // arrange
        EnvironmentListDTO env = TestUtilsGenerator.getEnvironments();

        List<EnvironmentAreaResponseDTO> e = TestUtilsGenerator.getListEnvironmentAreaResponseDTO();
        when(service.environmentArea(env)).thenReturn(e);

        // act
        List<EnvironmentAreaResponseDTO> received = controller.environmentArea(env).getBody();
        int httpStatusReceived = controller.environmentArea(env).getStatusCodeValue();

        // assert
        verify(service, atLeastOnce()).environmentArea(env);
        Assertions.assertEquals(received, e);
        Assertions.assertEquals(httpStatusReceived, 200);
    }

//    @Test
//    public void addPropertyWithErrors() {
//        // arrange
//        PropertyDTO pro = TestUtilsGenerator.getPropertyDTOWithErrors();
//
//        //when(service.environmentArea(env)).thenReturn(e);
//
//        // act
//         //received = controller.addProperty(pro).getBody();
//        int httpStatusReceived = controller.addProperty(pro).getStatusCodeValue();
//
//        // assert
//        //verify(service, atLeastOnce()).environmentArea(env);
//        //Assertions.assertEquals(received, e);
//        Assertions.assertEquals(201, httpStatusReceived);
//    }


}

//Mockito.when(mapper.map(property,PropertyDTO.class)).thenReturn(propertyDTO);

//    HouseListResponseDTO expected = new HouseListResponseDTO(houses);
//        Mockito.when(modelMapper.map(iHouseDAO.getHouses(), HouseListResponseDTO.class))
//        .thenReturn(expected);

