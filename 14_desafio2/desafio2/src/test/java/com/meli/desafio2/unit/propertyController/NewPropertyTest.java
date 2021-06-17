package com.meli.desafio2.unit.propertyController;

import com.meli.desafio2.Util;
import com.meli.desafio2.controller.PropertyController;
import com.meli.desafio2.dto.PropertyInputDTO;
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
public class NewPropertyTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void happyPath(){
        //Arr
        PropertyInputDTO property = Util.PropertyInputHappy("Departamento1");
        Mockito.when(propertyService.newProperty(property)).thenReturn(1);
        String expected = "La propiedad ha sido registrada existosamente con el ID: 1";

        //Act
        ResponseEntity<?> received = propertyController.newProperty(property);

        //Assert
        Assertions.assertEquals(expected,received.getBody());
    }

    //Arr
    //Act
    //Assert
}
