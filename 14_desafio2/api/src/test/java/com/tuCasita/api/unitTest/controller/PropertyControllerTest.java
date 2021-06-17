package com.tuCasita.api.unitTest.controller;

import com.tuCasita.api.controller.PropertyController;
import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;
import com.tuCasita.api.service.contract.IPropertyService;
import com.tuCasita.api.testUtil.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {
    @Mock
    IPropertyService service;

    @InjectMocks
    PropertyController controller;

    @Test
    public void getTotalSquareMetersWithValidDTOShouldCallServiceOnce() throws DistrictNameNotFoundException {
        //Arrange
        var dto = TestUtil.getPropertyDTOWith3Environments();
        var propertyWithTotalSquareMeters = TestUtil.getPropertyWithTotalSquareMeters();
        when(service.getTotalSquareMeters(dto)).thenReturn(propertyWithTotalSquareMeters);

        //Act
        var result = controller.getTotalSquareMeters(dto);

        //Assert
        verify(service, atLeastOnce()).getTotalSquareMeters(dto);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(propertyWithTotalSquareMeters, result.getBody());
    }

    @Test
    public void getTotalValueWithValidDTOShouldCallServiceOnce() throws DistrictNameNotFoundException {
        //Arrange
        var dto = TestUtil.getPropertyDTOWith3Environments();
        var propertyWithTotalValue = TestUtil.getPropertyWithTotalValue();
        when(service.getTotalValue(dto)).thenReturn(propertyWithTotalValue);

        //Act
        var result = controller.getTotalValue(dto);

        //Assert
        verify(service, atLeastOnce()).getTotalValue(dto);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(propertyWithTotalValue, result.getBody());
    }

    @Test
    public void getBiggestEnvironmentWithValidDTOShouldCallServiceOnce() throws DistrictNameNotFoundException {
        //Arrange
        var dto = TestUtil.getPropertyDTOWith3Environments();
        var propertyWithBiggestEnvironment = TestUtil.getPropertyWithBiggestEnvironment();
        when(service.calculateBiggestEnvironment(dto)).thenReturn(propertyWithBiggestEnvironment);

        //Act
        var result = controller.getBiggestEnvironment(dto);

        //Assert
        verify(service, atLeastOnce()).calculateBiggestEnvironment(dto);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(propertyWithBiggestEnvironment, result.getBody());
    }

    @Test
    public void getTotalSquareMetersByEnvironmentValidDTOShouldCallServiceOnce() throws DistrictNameNotFoundException {
        //Arrange
        var dto = TestUtil.getPropertyDTOWith3Environments();
        var propertyWithTotalSquareMetersByEnvironment = TestUtil.getPropertyWithTotalSquareMetersByEnvironment();
        when(service.getTotalSquareMetersByEnvironment(dto)).thenReturn(propertyWithTotalSquareMetersByEnvironment);

        //Act
        var result = controller.getTotalSquareMetersByEnvironment(dto);

        //Assert
        verify(service, atLeastOnce()).getTotalSquareMetersByEnvironment(dto);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(propertyWithTotalSquareMetersByEnvironment, result.getBody());
    }
}
