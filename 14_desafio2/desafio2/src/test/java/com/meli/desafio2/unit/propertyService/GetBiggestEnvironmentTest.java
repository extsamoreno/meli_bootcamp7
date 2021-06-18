package com.meli.desafio2.unit.propertyService;

import com.meli.desafio2.Util;
import com.meli.desafio2.dto.PropertyBiggestEnvironmentDTO;
import com.meli.desafio2.repository.IPropertyRepository;
import com.meli.desafio2.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetBiggestEnvironmentTest {
    @Mock
    IPropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void returnsCorrectEnvironmentAsBiggest(){
        //Arr
        PropertyBiggestEnvironmentDTO expected = Util.propertyBiggestEnvironmentHappy("Departamento1");
        Mockito.when(propertyRepository.getById(1)).thenReturn(Util.PropertyHappy("Departamento1"));

        //Act
        PropertyBiggestEnvironmentDTO actual = propertyService.getBiggestEnvironment(1);
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    //Arr
    //Act
    //Assert
}