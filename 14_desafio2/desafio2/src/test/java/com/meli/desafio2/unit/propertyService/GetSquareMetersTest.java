package com.meli.desafio2.unit.propertyService;

import com.meli.desafio2.Util;
import com.meli.desafio2.dto.DistrictDTO;
import com.meli.desafio2.dto.PropertyDTO;
import com.meli.desafio2.dto.PropertyInputDTO;
import com.meli.desafio2.dto.PropertySquareDTO;
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
public class GetSquareMetersTest {
    @Mock
    IPropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void returnsCorrectSquareMeters(){
        //Arr
        PropertySquareDTO expected = Util.propertySquareHappy("Departamento1");
        Mockito.when(propertyRepository.getFullById(1)).thenReturn(Util.PropertyFullHappy("Departamento1"));

        //Act
        PropertySquareDTO actual = propertyService.getSquareMeters(1);
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    //Arr
    //Act
    //Assert
}
