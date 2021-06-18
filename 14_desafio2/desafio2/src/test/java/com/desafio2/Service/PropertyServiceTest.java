package com.desafio2.Service;

import com.desafio2.DTO.EnvironmentDTO;
import com.desafio2.Model.District;
import com.desafio2.Model.Environment;
import com.desafio2.Model.Property;
import com.desafio2.Repository.IDistrctRepository;
import com.desafio2.Repository.IPropertyRepository;
import com.desafio2.Utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {
    @Mock
    IPropertyRepository iPropertyRepository;
    @Mock
    IDistrctRepository iDistrctRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void createPropertySuccessfullyTest() {
        //arrange
        Property property = TestUtils.createProperty("Avenue123");
        Mockito.doNothing().when(iPropertyRepository).save(property);

        //act
        propertyService.create(property);

        //assert
        Mockito.verify(iPropertyRepository, Mockito.atLeast(1)).save(property);
    }

    @Test
    public void getTotalSquareMetersTest() {
        //arrange
        Property property = TestUtils.createProperty("Avenue123");
        Mockito.when(iPropertyRepository.findByName(property.getProp_name())).thenReturn(property);
        double expectedMeters = 188D;

        //act
        double receivedMeters = propertyService.getTotalSquareMeters(property.getProp_name());

        //assert
        Mockito.verify(iPropertyRepository, Mockito.atLeast(1)).findByName(property.getProp_name());
        Assertions.assertEquals(expectedMeters, receivedMeters);
    }


    @Test
    public void getRoomSquareMetersTest() {
        //arrange
        Environment environment = TestUtils.createEnvironment();
        double expectedMeters = 70.35000000000001;

        //act
        double receivedMeters = propertyService.getRoomSquareMeters(environment);

        //assert
        Assertions.assertEquals(expectedMeters, receivedMeters);
    }

    @Test
    public void getPropertyPriceTest() {
        //arrange
        Property property = TestUtils.createProperty("Avenue123");
        District district = TestUtils.createWestDistrict100USD();
        Mockito.when(iPropertyRepository.findByName(property.getProp_name())).thenReturn(property);
        Mockito.when(iDistrctRepository.findByName(property.getDistrict_name())).thenReturn(district);
        double expectedPrice = district.getDistrict_price() * 188;

        //act
        double receivedPrice = propertyService.getPropertyPrice(property.getProp_name());

        //assert
        Mockito.verify(iDistrctRepository, Mockito.atLeast(1)).findByName(property.getDistrict_name());
        Mockito.verify(iPropertyRepository, Mockito.atLeast(1)).findByName(property.getProp_name());
        Assertions.assertEquals(expectedPrice, receivedPrice);
    }

    @Test
    public void getBiggestEnvironmentTest() {
        //arrange
        Property property = TestUtils.createProperty("Avenue123");
        Mockito.when(iPropertyRepository.findByName(property.getProp_name())).thenReturn(property);
        Environment expectedEnvironment = new Environment("Room2", 8.0, 11.0);

        //act
        Environment receivedEnvironment = propertyService.getBiggestEnvironment(property.getProp_name());

        //assert
        Mockito.verify(iPropertyRepository, Mockito.atLeast(1)).findByName(property.getProp_name());
        Assertions.assertEquals(expectedEnvironment, receivedEnvironment);
    }

    @Test
    public void getEnvironmentListWithSquareMetersTest() {
        //arrange
        Property property = TestUtils.createProperty("Avenue123");
        Mockito.when(iPropertyRepository.findByName(property.getProp_name())).thenReturn(property);
        List<EnvironmentDTO> expectedEnvironments = TestUtils.getEnvironments();

        //act
        List<EnvironmentDTO> receivedEnvironments = propertyService.getEnvironmentListWithSquareMeters(property.getProp_name());

        //assert
        Mockito.verify(iPropertyRepository, Mockito.atLeast(1)).findByName(property.getProp_name());
        Assertions.assertEquals(expectedEnvironments, receivedEnvironments);
    }

}
