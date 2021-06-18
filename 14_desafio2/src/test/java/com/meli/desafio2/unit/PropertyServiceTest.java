package com.meli.desafio2.unit;

import com.meli.desafio2.web.exception.DistrictNotFoundException;
import com.meli.desafio2.web.exception.PropertyAlreadyExistException;
import com.meli.desafio2.web.exception.PropertyException;
import com.meli.desafio2.web.exception.PropertyNameNotFoundException;
import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.repository.IDistrictRepository;
import com.meli.desafio2.web.repository.IPropertyRepository;
import com.meli.desafio2.web.response.BiggestEnvironmentResponse;
import com.meli.desafio2.web.response.PropertyValueResponse;
import com.meli.desafio2.web.response.SquareMetersEnvironmentResponse;
import com.meli.desafio2.web.response.SquareMetersResponse;
import com.meli.desafio2.web.service.PropertyMapper;
import com.meli.desafio2.web.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {
    @Mock
    IPropertyRepository iPropertyRepository;
    @Mock
    IDistrictRepository iDistrictRepository;
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



    @Test
    public void addPropertyTest() throws PropertyException, DistrictNotFoundException {
        //arrange
        Property property = Utils.initValidProperty();
        District district = Utils.initValidDistrict();
        String name = property.getProp_name();
        String district_name = property.getDistrict();
        Mockito.when(iPropertyRepository.getPropertyByName(name)).thenReturn(null);
        Mockito.when(iDistrictRepository.getDistrictByName(district_name)).thenReturn(district);
        Mockito.doNothing().when(iPropertyRepository).saveProperty(property);

        //act
        propertyService.addProperty(PropertyMapper.toDTO(property));
        //assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(name);
        Mockito.verify(iDistrictRepository,Mockito.atLeastOnce()).getDistrictByName(district_name);
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).saveProperty(property);
    }

    @Test
    public void addPropertyAlreadyExist() throws PropertyAlreadyExistException, DistrictNotFoundException {
        //arrange
        Property property = Utils.initValidProperty();
        String name = property.getProp_name();
        Mockito.when(iPropertyRepository.getPropertyByName(name)).thenReturn(property);

        //act

        //assert
        Assertions.assertThrows(PropertyAlreadyExistException.class, ()-> propertyService.addProperty(PropertyMapper.toDTO(property)));
    }

    @Test
    public void addDistrictNotFoundException() throws PropertyAlreadyExistException, DistrictNotFoundException {
        //arrange
        Property property = Utils.initValidProperty();
        String name = property.getProp_name();
        String district_name = property.getDistrict();
        Mockito.when(iPropertyRepository.getPropertyByName(name)).thenReturn(null);
        Mockito.when(iDistrictRepository.getDistrictByName(district_name)).thenReturn(null);

        //act

        //assert

        Assertions.assertThrows(DistrictNotFoundException.class, ()-> propertyService.addProperty(PropertyMapper.toDTO(property)));
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(name);
    }

    @Test
    public void getValue() throws PropertyNameNotFoundException {
        //arrange
        Property property = Utils.initValidProperty();
        String name = property.getProp_name();
        String district_name = property.getDistrict();
        District district = Utils.initValidDistrict();
        PropertyValueResponse expected = Utils.getPropertyValue();
        Mockito.when(iPropertyRepository.getPropertyByName(name)).thenReturn(property);
        Mockito.when(iDistrictRepository.getDistrictByName(district_name)).thenReturn(district);

        //act
        PropertyValueResponse response = propertyService.getValue(name);

        //assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(name);
        Mockito.verify(iDistrictRepository,Mockito.atLeastOnce()).getDistrictByName(district_name);
        Assertions.assertEquals(expected, response);
    }



}
