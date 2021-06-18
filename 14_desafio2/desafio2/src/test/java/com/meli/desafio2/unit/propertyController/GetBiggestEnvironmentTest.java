package com.meli.desafio2.unit.propertyController;

import com.meli.desafio2.UtilGenerator;
import com.meli.desafio2.controller.PropertyController;
import com.meli.desafio2.dto.PropertyBiggestEnvironmentDTO;
import com.meli.desafio2.service.IPropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GetBiggestEnvironmentTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void happyPath(){
        //Arr
        PropertyBiggestEnvironmentDTO expected = UtilGenerator.propertyBiggestEnvironmentHappy("Amber");
        Mockito.when(propertyService.getBiggestEnvironment(1)).thenReturn(expected);

        //Act
        ResponseEntity<?> received = propertyController.getBiggestEnvironment(1);
        PropertyBiggestEnvironmentDTO actual = (PropertyBiggestEnvironmentDTO) received.getBody();
        //Assert
        verify(propertyService,atLeastOnce()).getBiggestEnvironment(1);
        Assertions.assertEquals(expected,actual);
    }

    //Arr
    //Act
    //Assert
}
