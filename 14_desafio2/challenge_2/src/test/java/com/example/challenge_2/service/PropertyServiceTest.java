package com.example.challenge_2.service;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.repository.IDistrictRepository;
import com.example.challenge_2.repository.IPropertyRepository;
import com.example.challenge_2.service.dto.*;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository propertyRepository;

    @Mock
    IDistrictRepository districtRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void getSquareMetersTest() throws PropertyNotFoundException {
        //Arrange
        Property propertyTest = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();

        when(propertyRepository.getById(1)).thenReturn(propertyTest);

        //Act
        SquareMetersDTO result = propertyService.getSquareMeters(1);

        //assert
        assertEquals(285d, result.getSquareMeters());
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
        Property propertyTest = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();
        EnvironmentDTO biggestEnvironmentMock = new EnvironmentDTO("Kitchen", 25,5);
        when(propertyRepository.getById(1)).thenReturn(propertyTest);

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
        Property propertyTest = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();
        List<EnvironmentSquareMetersDTO> enviromentsMock = new ArrayList<>();

        enviromentsMock.add(new EnvironmentSquareMetersDTO("Room", 35));
        enviromentsMock.add(new EnvironmentSquareMetersDTO("Kitchen", 125));
        enviromentsMock.add(new EnvironmentSquareMetersDTO("Living", 25));
        enviromentsMock.add(new EnvironmentSquareMetersDTO("Bathroom", 100));

        when(propertyRepository.getById(1)).thenReturn(propertyTest);

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
        Property propertyTest = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();

        when(propertyRepository.getById(1)).thenReturn(propertyTest);

        //Act
        PropertyPriceDTO result = propertyService.getPropertyPrice(1);

        //assert
        assertEquals(result.getFinalPrice(), 2850d);
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
        PropertyDTO propertyTest = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();
        Property property = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();
        property.setId(0); //because the new property dont have id, is autogenerated

        when(districtRepository.getByName(property.getDistrict().getName())).thenReturn(property.getDistrict());

        when(propertyRepository.add(property)).thenAnswer((Answer<Boolean>) invocation -> {
            ((Property) invocation.getArgument(0)).setId(1);
            return true;
        });

        //Act

        NewIdDTO result = propertyService.createProperty(propertyTest);
        //Assert

        assertTrue(result.getId() > 0);
    }

    @Test
    public void createPropertyTestNoDistrict() throws DistrictNotFoundException {
        //Arrange
        PropertyDTO propertyTest = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();
        Property property = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();

        when(districtRepository.getByName(property.getDistrict().getName())).thenThrow(DistrictNotFoundException.class);

        //Assert

        assertThrows(DistrictNotFoundException.class, () -> propertyService.createProperty(propertyTest));
    }
}
