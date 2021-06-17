package com.desafiotesting.api.unit;

import com.desafiotesting.api.controller.TasacionesRestController;
import com.desafiotesting.api.dto.*;
import com.desafiotesting.api.exception.NotFoundDistrictException;

import com.desafiotesting.api.service.TasacionesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TasacionesRestControllerTest {
    @Mock
    TasacionesService service;
    @InjectMocks
    TasacionesRestController controller;

    PropertyDTO house = new PropertyDTO("Casa1", "Centro", new ArrayList<>(){
        {
            add(new EnvironmentDTO("Cocina", 3.0, 2.0));
            add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
        }
    });

    @Test
    public void totalAreaHappyPath() throws Exception {
        //arrange
        TotalAreaDTO dto= new TotalAreaDTO("Casa1",18.0);
        ResponseEntity<?> expected = new ResponseEntity<>(dto,HttpStatus.OK);
        Mockito.when(service.totalArea(house)).thenReturn(new TotalAreaDTO("Casa1",18.0));

        //act
        ResponseEntity<?> received = controller.totalArea(house);

        //assert
        Mockito.verify(service,Mockito.atLeast(1)).totalArea(house);
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void priceHappyPath() throws Exception {
        //arrange
        PriceDTO dto = new PriceDTO("Casa1", 18.0*100.0);
        ResponseEntity<PriceDTO> expected= new ResponseEntity<>(dto,HttpStatus.OK);

        Mockito.when(service.price(house)).thenReturn(new PriceDTO("Casa1", 18.0*100.0));

        //act
        ResponseEntity<PriceDTO> received = controller.price(house);

        //assert
        Mockito.verify(service, Mockito.atLeast(1)).price(house);
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void priceThrowsNotFoundDistrictException() throws NotFoundDistrictException {
        //arrange
        Mockito.when(service.price(house)).thenThrow(new NotFoundDistrictException());

        //act

        //assert
        Assertions.assertThrows(NotFoundDistrictException.class,  () -> controller.price(house));
        Mockito.verify(service, Mockito.atLeast(1)).price(house);
    }

    @Test
    public void biggerEnvironmentHappyPath() throws Exception {
        //arrange
        BiggerEnvironmentDTO dto = new BiggerEnvironmentDTO("Habitacion");
        ResponseEntity<BiggerEnvironmentDTO> expected = new ResponseEntity<>(dto,HttpStatus.OK);
        Mockito.when(service.biggerEnvironment(house)).thenReturn(new BiggerEnvironmentDTO("Habitacion"));

        //act
        ResponseEntity<BiggerEnvironmentDTO> received = controller.biggerEnvironment(house);

        //assert
        Mockito.verify(service,Mockito.atLeast(1)).biggerEnvironment(house);
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void environmentsAreaHappyPath() throws Exception {
        //arrange
        ArrayList<EnvironmentAreaDTO> dto = new ArrayList<>(){
            {   add(new EnvironmentAreaDTO("Cocina",6.0));
                add(new EnvironmentAreaDTO("Habitacion",12.0));
            }
        };
        Mockito.when(service.environmentsArea(house)).thenReturn(new ArrayList<>(){
            {   add(new EnvironmentAreaDTO("Cocina",6.0));
                add(new EnvironmentAreaDTO("Habitacion",12.0));
            }
        });

        ResponseEntity<List> expected = new ResponseEntity<>(dto,HttpStatus.OK);

        //act
        ResponseEntity<ArrayList<EnvironmentAreaDTO>> received = controller.environmentsArea(house);

        //assert
        Mockito.verify(service,Mockito.atLeast(1)).environmentsArea(house);
        Assertions.assertEquals(expected,received);
    }
}
