package com.desafiotesting.desafiotesting.unittests.controllers;
import com.desafiotesting.desafiotesting.controllers.PropertyController;
import com.desafiotesting.desafiotesting.services.IPropertyService;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentDTO;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentWithSquareMetersDTO;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;
import com.desafiotesting.desafiotesting.utils.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void registerPropertyTest(){
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("District1");

        ResponseEntity<?> response = propertyController.registerProperty(propertyDTO);

        Mockito.verify(propertyService,Mockito.atLeast(1)).create(propertyDTO);

        Assertions.assertEquals(ResponseEntity.ok(null),response);
    }

    @Test
    public void totalSquareMetersTest() {
        int id = 1;

        Mockito.when(propertyService.totalSquareMeters(id)).thenReturn(20.5);

        double response = propertyController.totalSquareMeters(id);

        Mockito.verify(propertyService,Mockito.atLeast(1)).totalSquareMeters(id);
        Assertions.assertEquals(20.5 , response);
    }

    @Test
    public void getPricePropertyTest(){
        int id = 1;

        Mockito.when(propertyService.getPriceProperty(id)).thenReturn(202.5);

        double response = propertyController.getPriceProperty(id);

        Mockito.verify(propertyService,Mockito.atLeast(1)).getPriceProperty(id);
        Assertions.assertEquals(202.5 , response);
    }

    @Test
    public void getBiggerEnviromentTest(){
        int id = 1;
        EnviromentDTO enviromentDTO = TestUtilGenerator.getEnviromentDTO();

        Mockito.when(propertyService.getBiggerEnviroment(id)).thenReturn(enviromentDTO);

        EnviromentDTO response = propertyController.getBiggerEnviroment(id);

        Mockito.verify(propertyService,Mockito.atLeast(1)).getBiggerEnviroment(id);
        Assertions.assertEquals(enviromentDTO , response);
    }

    @Test
    public void getEnviromentsInfoTest(){
        int id = 1;
        List<EnviromentWithSquareMetersDTO> enviromentsWithSquareMetersDTO = TestUtilGenerator.getEnviromentsWithSquareMetersDTO();

        Mockito.when(propertyService.getEnviromentsInfo(id)).thenReturn(enviromentsWithSquareMetersDTO);

        List<EnviromentWithSquareMetersDTO> response = propertyController.getEnviromentsInfo(id);

        Mockito.verify(propertyService,Mockito.atLeast(1)).getEnviromentsInfo(id);
        Assertions.assertEquals(enviromentsWithSquareMetersDTO , response);
    }



}
