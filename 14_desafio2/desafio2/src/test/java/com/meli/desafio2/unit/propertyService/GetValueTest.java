package com.meli.desafio2.unit.propertyService;

import com.meli.desafio2.UtilGenerator;
import com.meli.desafio2.dto.PropertyValueDTO;
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
public class GetValueTest {
    @Mock
    IPropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void returnsCorrectSquareMeters(){
        //Arr
        PropertyValueDTO expected = UtilGenerator.propertyValueHappy("Departamento1");
        Mockito.when(propertyRepository.getFullById(1)).thenReturn(UtilGenerator.propertyFullHappy("Departamento1"));

        //Act
        PropertyValueDTO actual = propertyService.getValue(1);
        //Assert
        verify(propertyRepository,atLeastOnce()).getFullById(1);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void throwsPRopertyNotFoundException(){
        //Arr
        Mockito.when(propertyRepository.getFullById(1)).thenReturn(null);
        //Act
        //Assert
        Assertions.assertThrows(PropertyNotFoundException.class, ()-> propertyService.getValue(1));
    }

    //Arr
    //Act
    //Assert
}
