package com.meli.desafio2.unit;

import com.meli.desafio2.exception.DistrictNotFoundException;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.dto.EnvironmentDTO;
import com.meli.desafio2.model.dto.PropertyDTO;
import com.meli.desafio2.repository.PropertyRepository;
import com.meli.desafio2.service.PropertyServiceImpl;
import com.meli.desafio2.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @Mock
    PropertyRepository propertyRepository;

    @InjectMocks
    PropertyServiceImpl propertyService;

    @Test
    void saveProperty_Success() throws DistrictNotFoundException {
        //Arrange
        Property prop = TestUtilGenerator.getProperty();

        //Act
        propertyService.saveProperty(prop);

        //Assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).save(prop);
        Assertions.assertEquals(propertyRepository.getProperty(),prop);
    }


    @Test
    void calculateMts2_Success() {
        //Arrange
        Property prop = TestUtilGenerator.getProperty();
        PropertyDTO expected = new PropertyDTO("Casa del Barba",131,0,null,null);
        Mockito.when(propertyRepository.getProperty()).thenReturn(prop);

        //Act
        PropertyDTO response = propertyService.calculateMts2();

        //Assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).getProperty();
        Assertions.assertEquals(expected,response);
    }

    @Test
    void calculatePrice_Success() {
        //Arrange
        Property prop = TestUtilGenerator.getProperty();
        PropertyDTO expected = new PropertyDTO("Casa del Barba", 131, 39365.5, null ,null);
        Mockito.when(propertyRepository.getProperty()).thenReturn(prop);

        //Act
        PropertyDTO response = propertyService.calculatePrice();

        //Assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).getProperty();
        Assertions.assertEquals(expected,response);
    }

    @Test
    void obtainMostGreaterEnvironment_Sucesss(){
        //Arrange
        Property prop = TestUtilGenerator.getProperty();
        EnvironmentDTO environment = new EnvironmentDTO("Cocina",56);
        PropertyDTO expected = new PropertyDTO("Casa del Barba", 131, 0, environment, null);
        Mockito.when(propertyRepository.getProperty()).thenReturn(prop);

        //Act
        PropertyDTO received = propertyService.obtainMostGreaterEnvironment();

        //Assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).getProperty();
        Assertions.assertEquals(expected,received);
    }

    @Test
    void calculateEnvironmentMts2_Success(){
        //Arrange
        Property prop = TestUtilGenerator.getProperty();
        PropertyDTO expected = new PropertyDTO("Casa del Barba", 131, 0, null, TestUtilGenerator.environmentDTOList());
        Mockito.when(propertyRepository.getProperty()).thenReturn(prop);

        //Act
        PropertyDTO received = propertyService.calculateEnvironmentMts2();

        //Assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).getProperty();
        Assertions.assertEquals(expected,received);
    }
}