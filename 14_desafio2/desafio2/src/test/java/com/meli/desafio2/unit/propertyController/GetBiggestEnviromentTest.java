package com.meli.desafio2.unit.propertyController;

import com.meli.desafio2.Util;
import com.meli.desafio2.controller.PropertyController;
import com.meli.desafio2.dto.PropertyBiggestEnviromentDTO;
import com.meli.desafio2.service.IPropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class GetBiggestEnviromentTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void happyPath(){
        //Arr
        PropertyBiggestEnviromentDTO expected = Util.propertyBiggestEnviromentHappy("Amber");
        Mockito.when(propertyService.getBiggestEnviroment(1)).thenReturn(expected);

        //Act
        ResponseEntity<?> received = propertyController.getBiggestEnviroment(1);
        PropertyBiggestEnviromentDTO actual = (PropertyBiggestEnviromentDTO) received.getBody();
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    //Arr
    //Act
    //Assert
}
