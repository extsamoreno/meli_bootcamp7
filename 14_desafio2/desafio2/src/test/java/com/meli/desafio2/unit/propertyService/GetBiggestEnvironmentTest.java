package com.meli.desafio2.unit.propertyService;

import com.meli.desafio2.UtilGenerator;
import com.meli.desafio2.dto.PropertyBiggestEnvironmentDTO;
import com.meli.desafio2.exception.PropertyNotFoundException;
import com.meli.desafio2.repository.IPropertyRepository;
import com.meli.desafio2.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GetBiggestEnvironmentTest {
    @Mock
    IPropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void returnsCorrectEnvironmentAsBiggest(){
        //Arr
        PropertyBiggestEnvironmentDTO expected = UtilGenerator.propertyBiggestEnvironmentHappy("Departamento1");
        Mockito.when(propertyRepository.getById(1)).thenReturn(UtilGenerator.propertyHappy("Departamento1"));

        //Act
        PropertyBiggestEnvironmentDTO actual = propertyService.getBiggestEnvironment(1);
        //Assert
        verify(propertyRepository,atLeastOnce()).getById(1);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void throwsPRopertyNotFoundException(){
        //Arr
        Mockito.when(propertyRepository.getById(1)).thenReturn(null);
        //Act
        //Assert
        Assertions.assertThrows(PropertyNotFoundException.class, ()-> propertyService.getBiggestEnvironment(1));
    }

    //Arr
    //Act
    //Assert
}