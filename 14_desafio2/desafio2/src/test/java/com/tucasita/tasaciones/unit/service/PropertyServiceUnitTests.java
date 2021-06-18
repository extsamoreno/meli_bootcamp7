package com.tucasita.tasaciones.unit.service;

import com.tucasita.tasaciones.TestUtils.TestUtils;
import com.tucasita.tasaciones.project.exceptions.PropertyDistrictNameNotFoundException;
import com.tucasita.tasaciones.project.exceptions.PropertyNameNotFoundException;
import com.tucasita.tasaciones.project.models.District;
import com.tucasita.tasaciones.project.models.Property;
import com.tucasita.tasaciones.project.repository.IPropertyRepository;
import com.tucasita.tasaciones.project.services.Dto.PropertyEnvironmentDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyTotalSquareMetersDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyValueDto;
import com.tucasita.tasaciones.project.services.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceUnitTests {

    @Mock
    IPropertyRepository iPropertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void getTotalSquareMetersHappyPath() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        Property property = TestUtils.getNewProperty(propertyName);
        double totalSquareMetersExpected = 300;
        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);

        //Act
        PropertyTotalSquareMetersDto response = propertyService.getTotalSquareMeters(propertyName);


        //Asserts
        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        Assertions.assertEquals(response.getTotalMeters(),totalSquareMetersExpected);
    }

    @Test
    public void getBiggestEnvironmentHappyPath() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        Property property = TestUtils.getNewProperty(propertyName);
        PropertyEnvironmentDto expected = new PropertyEnvironmentDto("Cocina",150);

        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);
        //Act
        PropertyEnvironmentDto response = this.propertyService.getBiggestEnvironment(property.getProp_name());

        //Assert
        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        Assertions.assertEquals(response,expected);
    }

    @Test
    public void getEnvironmentSizesListHappyPath() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        Property property = TestUtils.getNewProperty(propertyName);
        PropertyEnvironmentDto expected1 = new PropertyEnvironmentDto("Banio", 50);
        PropertyEnvironmentDto expected2 = new PropertyEnvironmentDto("Cocina", 150);
        PropertyEnvironmentDto expected3 = new PropertyEnvironmentDto("Living", 100);
        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);

        //Act
        ArrayList<PropertyEnvironmentDto> response = this.propertyService.getEnvironmentSizesList(propertyName);

        //Assert
        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        Assertions.assertEquals(response.get(0),expected1);
        Assertions.assertEquals(response.get(1),expected2);
        Assertions.assertEquals(response.get(2),expected3);
    }

    @Test
    public void getPropertyValue() throws PropertyNameNotFoundException, PropertyDistrictNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        Double expected = 300000.00;

        Property property = TestUtils.getNewProperty(propertyName);
        District district = new District("Villa Herrero",1000.0);

        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);
        when(iPropertyRepository.findDistrictByName(property.getProp_district_name())).thenReturn(district);

        //Act
        PropertyValueDto response = this.propertyService.getPropertyValue(propertyName);

        //Asserts
        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        verify(iPropertyRepository,atLeastOnce()).findDistrictByName(property.getProp_district_name());
        Assertions.assertEquals(response.getProperty_value(), expected);
    }

}
