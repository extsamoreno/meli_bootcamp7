package com.meli.desafio2.unit.propertyService;

import com.meli.desafio2.UtilGenerator;
import com.meli.desafio2.dto.PropertyFullDTO;
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
public class GetPropertyTest {
    @Mock
    IPropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void returnsCorrectFullProperty(){
        //Arr
        PropertyFullDTO expected = UtilGenerator.propertyFullHappy("Departamento1");
        Mockito.when(propertyRepository.getFullById(1)).thenReturn(expected);

        //Act
        PropertyFullDTO actual = propertyService.getProperty(1);
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
        Assertions.assertThrows(PropertyNotFoundException.class, ()-> propertyService.getProperty(1));
    }

    //Arr
    //Act
    //Assert
}
