package com.meli.desafio2.unit.propertyService;

import com.meli.desafio2.UtilGenerator;
import com.meli.desafio2.dto.DistrictDTO;
import com.meli.desafio2.dto.PropertyDTO;
import com.meli.desafio2.dto.PropertyInputDTO;
import com.meli.desafio2.exception.DistrictNotFoundException;
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
public class NewPropertyTest {
    @Mock
    IPropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void registeredSuccesfullyWithDistrictAlreadyInDB(){
        //Arr
        String expected = "La propiedad Departamento1 ha sido registrada correctamente con el ID: 1.";
        PropertyInputDTO input = UtilGenerator.propertyInputHappy("Departamento1");
        DistrictDTO district = UtilGenerator.districtHappy("Amber");
        Mockito.when(propertyRepository.getDistrictByName("Amber")).thenReturn(district);
        PropertyDTO propertyDTO = UtilGenerator.propertyHappy("Departamento1");
        propertyDTO.setProp_id(-1);
        Mockito.when(propertyRepository.newProperty(propertyDTO)).thenReturn(1);

        //Act
        String actual = propertyService.newProperty(input);
        //Assert
        verify(propertyRepository,atLeastOnce()).getDistrictByName("Amber");
        verify(propertyRepository,atLeastOnce()).newProperty(propertyDTO);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void throwsDistrictNotFoundException(){
        //Arr
        String expected = "La propiedad Departamento1 ha sido registrada correctamente con el ID: 1. Y el barrio Amber ha sido registrado con el ID: 1";
        PropertyInputDTO input = UtilGenerator.propertyInputHappy("Departamento1");
        Mockito.when(propertyRepository.getDistrictByName("Amber")).thenReturn(null);
        //Act
        //Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyService.newProperty(input));
    }

    //Arr
    //Act
    //Assert
}
