package com.meli.desafio2.unit;

import com.meli.desafio2.web.dto.PropertyDTO;
import com.meli.desafio2.web.exception.PropertyNameNotFoundException;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.repository.IPropertyRepository;
import com.meli.desafio2.web.responses.BiggestEnvironmentResponse;
import com.meli.desafio2.web.responses.SquareMetersEnvironmentResponse;
import com.meli.desafio2.web.responses.SquareMetersResponse;
import com.meli.desafio2.web.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {
    @Mock
    IPropertyRepository iPropertyRepository;
    @InjectMocks
    PropertyService propertyService;
    @Test
    public void SquareMetersTest() throws PropertyNameNotFoundException {
        //arrange
        Property property = Utils.initValidProperty();
        String name = property.getProp_name();
        SquareMetersResponse expected = Utils.getSquareMetersResponse();
        Mockito.when(iPropertyRepository.getPropertyByName(name)).thenReturn(property);
        //act
        SquareMetersResponse response = propertyService.getSquareMeters(name);

        //assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(name);
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void getBiggestEnvironmentTest() throws PropertyNameNotFoundException {
        //arrange
        Property property = Utils.initValidProperty();
        String name = property.getProp_name();
        BiggestEnvironmentResponse expected = Utils.getBiggestEnvironment();
        Mockito.when(iPropertyRepository.getPropertyByName(name)).thenReturn(property);

        //act
        BiggestEnvironmentResponse response = propertyService.getBiggestEnvironment(name);
        //Assert

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(name);
        Assertions.assertEquals(expected,response);
    }

    @Test
    public void getEnvironmentSquareMetersTest() throws PropertyNameNotFoundException {
        //arrange
        Property property = Utils.initValidProperty();
        String name = property.getProp_name();
        SquareMetersEnvironmentResponse expected = Utils.getEnvironmentSquareMeters();
        Mockito.when(iPropertyRepository.getPropertyByName(name)).thenReturn(property);

        //act
        SquareMetersEnvironmentResponse response = propertyService.getEnvironmentSquareMeters(name);

        //assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(name);
        Assertions.assertEquals(expected,response);
    }






}
