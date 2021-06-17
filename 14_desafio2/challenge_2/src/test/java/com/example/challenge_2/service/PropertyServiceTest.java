package com.example.challenge_2.service;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.repository.IDistrictRepository;
import com.example.challenge_2.repository.IPropertyRepository;
import com.example.challenge_2.service.dto.*;
import com.example.challenge_2.service.mapper.PropertyMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository propertyRepository;

    @Mock
    IEnvironmentService environmentService;

    @Mock
    PropertyMapper propertyMapper;

    @Mock
    IDistrictRepository districtRepository;

    @Mock
    IDistrictService districtService;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void getSquareMetersTest() throws PropertyNotFoundException {
        //Arrange
        Property propertyTest = TestUtilsGenerator.getPropertyWithFourEnvironment();

        when(propertyRepository.getById(1)).thenReturn(propertyTest);

        propertyTest.getEnvironments().forEach(x -> {
            when(environmentService.calculateSquareMeters(x)).thenReturn(x.getHeight() * x.getWidth());
        });

        //Act
        SquareMetersDTO result = propertyService.getSquareMeters(1);

        //assert
        assertEquals(result.getSquareMeters(), 310d);
    }

    @Test
    public void getSquareMetersPropertyNotFound() throws PropertyNotFoundException {
        //Arrange
        when(propertyRepository.getById(1)).thenThrow(PropertyNotFoundException.class);

        //Act

        //Assert
        assertThrows(PropertyNotFoundException.class, () -> propertyService.getSquareMeters(1));
    }

    @Test
    public void getBiggestEnvironmentTest() throws PropertyNotFoundException {
        //Arrange
        Property propertyTest = TestUtilsGenerator.getPropertyWithFourEnvironment();
        EnvironmentDTO biggestEnvironmentMock = new EnvironmentDTO("Kitchen", 30,5);
        when(propertyRepository.getById(1)).thenReturn(propertyTest);
        when(environmentService.getBiggestEnviroment(propertyTest.getEnvironments())).thenReturn(biggestEnvironmentMock);

        //Act

        EnvironmentDTO biggestEnvironmentFromService = propertyService.getBiggestEnvironment(1);

        //Assert
        assertEquals(biggestEnvironmentMock, biggestEnvironmentFromService);
    }

    @Test
    public void getBiggestEnvironmentTestPropertyNotFound() throws PropertyNotFoundException {
        //Arrange
        when(propertyRepository.getById(1)).thenThrow(PropertyNotFoundException.class);

        //Act

        //Assert
        assertThrows(PropertyNotFoundException.class, () -> propertyService.getBiggestEnvironment(1));
    }


    @Test
    public void getSquareMetersEachEnvironmentTest() throws PropertyNotFoundException {
        //Arrange
        Property propertyTest = TestUtilsGenerator.getPropertyWithFourEnvironment();
        List<EnvironmentSquareMetersDTO> enviromentsMock = new ArrayList<>();

        enviromentsMock.add(new EnvironmentSquareMetersDTO("Room", 35));
        enviromentsMock.add(new EnvironmentSquareMetersDTO("Kitchen", 150));
        enviromentsMock.add(new EnvironmentSquareMetersDTO("Living", 25));
        enviromentsMock.add(new EnvironmentSquareMetersDTO("Bathroom", 100));

        when(propertyRepository.getById(1)).thenReturn(propertyTest);
        when(environmentService.getSquareMetersEachEnvironment(propertyTest.getEnvironments())).thenReturn(enviromentsMock);

        //Act
        List<EnvironmentSquareMetersDTO> enviromentsResult = propertyService.getSquareMetersEachEnvironment(1);

        //Assert
        assertTrue(CollectionUtils.isEqualCollection(enviromentsMock, enviromentsResult));

    }

    @Test
    public void getSquareMetersEachEnvironmentTestPropertyNotFound() throws PropertyNotFoundException {
        //Arrange
        when(propertyRepository.getById(1)).thenThrow(PropertyNotFoundException.class);

        //Act

        //Assert
        assertThrows(PropertyNotFoundException.class, () -> propertyService.getSquareMetersEachEnvironment(1));
    }

    @Test
    public void getPropertyPriceTest() throws PropertyNotFoundException {
        //Arrange
        Property propertyTest = TestUtilsGenerator.getPropertyWithFourEnvironment();

        when(propertyRepository.getById(1)).thenReturn(propertyTest);

        propertyTest.getEnvironments().forEach(x -> {
            when(environmentService.calculateSquareMeters(x)).thenReturn(x.getHeight() * x.getWidth());
        });

        //Act
        PropertyPriceDTO result = propertyService.getPropertyPrice(1);

        //assert
        assertEquals(result.getFinalPrice(), 3100d);
    }

    @Test
    public void getPropertyPriceTestPropertyNotFound() throws PropertyNotFoundException {
        //Arrange
        when(propertyRepository.getById(1)).thenThrow(PropertyNotFoundException.class);

        //Act

        //Assert
        assertThrows(PropertyNotFoundException.class, () -> propertyService.getPropertyPrice(1));
    }

    @Test
    public void createPropertyTest() throws DistrictNotFoundException {
        //Arrange
        PropertyDTO propertyTest = TestUtilsGenerator.getPropertyDTOWithFourEnvironment();
        Property property = TestUtilsGenerator.getPropertyWithFourEnvironment();

        when(propertyMapper.toModel(propertyTest)).thenReturn(property);
        when(propertyRepository.add(property)).thenReturn(true);
        when(districtService.getDistrictByName(property.getDistrict().getName())).thenReturn(property.getDistrict());
        //Act

        NewIdDTO result = propertyService.createProperty(propertyTest);
        //Assert

        assertTrue(result.getId() > 0);
    }

    @Test
    public void createPropertyTestNoDistrict() throws DistrictNotFoundException {
        //Arrange
        PropertyDTO propertyTest = TestUtilsGenerator.getPropertyDTOWithFourEnvironment();
        Property property = TestUtilsGenerator.getPropertyWithFourEnvironment();

        when(propertyMapper.toModel(propertyTest)).thenReturn(property);
        when(districtService.getDistrictByName(property.getDistrict().getName())).thenThrow(DistrictNotFoundException.class);

        //Assert

        assertThrows(DistrictNotFoundException.class, () -> propertyService.createProperty(propertyTest));
    }
}
