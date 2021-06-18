package com.meli.desafio2.unit;

import com.meli.desafio2.exception.DistrictNotFoundException;
import com.meli.desafio2.exception.PropertyException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.dto.EnvironmentDTO;
import com.meli.desafio2.model.dto.PropertyDTO;
import com.meli.desafio2.repository.DistrictRepository;
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

    @Mock
    DistrictRepository districtRepository;

    @InjectMocks
    PropertyServiceImpl propertyService;

    @Test
    void saveProperty_Success() throws PropertyException {
        //Arrange
        Property prop = TestUtilGenerator.getProperty();
        Mockito.when(districtRepository.findDistrictByID(1)).thenReturn(new District(1, "Jardin Aeropuerto", 300.5));

        //Act
        propertyService.saveProperty(prop);

        //Assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).save(prop);
    }

    @Test
    void saveProperty_WithoutDistrict(){
        //Arrange
        Property prop = TestUtilGenerator.getProperty();
        prop.setDistrict(new District());

        Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyService.saveProperty(prop));
    }

    @Test
    void calculateMts2_Success() throws PropertyException {
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
    void calculatePrice_Success() throws PropertyException {
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
    void obtainMostGreaterEnvironment_Sucesss() throws PropertyException {
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
    void calculateEnvironmentMts2_Success() throws PropertyException {
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