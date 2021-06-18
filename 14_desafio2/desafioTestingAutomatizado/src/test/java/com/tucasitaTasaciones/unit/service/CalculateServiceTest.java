package com.tucasitaTasaciones.unit.service;

import com.tucasitaTasaciones.dto.ResponseDTO.CalculateResponseDTO;
import com.tucasitaTasaciones.exceptions.PropertyNotFoundException;
import com.tucasitaTasaciones.model.Environment;
import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import com.tucasitaTasaciones.service.CalculateService;
import com.tucasitaTasaciones.unit.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @Mock
    IPropertyRepository propertyRepository;

    @InjectMocks
    CalculateService calculateService;


    @Test
    public void calculateSquareMeters() {
        Property property = TestUtilGenerator.getProperty();
        when(propertyRepository.findProperty(property.getPropId())).thenReturn(property);

        CalculateResponseDTO responseDTO = calculateService.calculateSquareMeters(property.getPropId());

        verify(propertyRepository, Mockito.atLeastOnce()).findProperty(property.getPropId());
        Assertions.assertEquals(8, responseDTO.getTotalSquareMeters());
    }

    @Test
    public void calculateSquareMetersException() {
        when(propertyRepository.findProperty(1)).thenReturn(null);
        assertThrows(PropertyNotFoundException.class, () -> calculateService.calculateSquareMeters(1));
    }

    @Test
    public void calculateValue() {
        Property property = TestUtilGenerator.getProperty();
        when(propertyRepository.findProperty(property.getPropId())).thenReturn(property);

        CalculateResponseDTO responseDTO = calculateService.calculateValue(property.getPropId());

        verify(propertyRepository, Mockito.atLeastOnce()).findProperty(property.getPropId());
        Assertions.assertEquals(18400.0, responseDTO.getPropertyPrice());
    }

    @Test
    public void calculateValueException() {
        when(propertyRepository.findProperty(1)).thenReturn(null);
        assertThrows(PropertyNotFoundException.class, () -> calculateService.calculateValue(1));
    }

    @Test
    public void getLargestEnvironment() {
        Property property = TestUtilGenerator.getProperty();
        when(propertyRepository.findProperty(property.getPropId())).thenReturn(property);

        CalculateResponseDTO responseDTO = calculateService.calculateLargestRoom(property.getPropId());

        verify(propertyRepository, Mockito.atLeastOnce()).findProperty(property.getPropId());
        Assertions.assertEquals("Living", responseDTO.getLargestRoom());

    }

    @Test
    public void getLargestEnvironmentException() {
        when(propertyRepository.findProperty(1)).thenReturn(null);
        assertThrows(PropertyNotFoundException.class, () -> calculateService.calculateLargestRoom(1));
    }

    @Test
    public void getEnvironmentSquareMetersWellCalculated() {
        Property property = TestUtilGenerator.getProperty();
        when(propertyRepository.findProperty(property.getPropId())).thenReturn(property);

        Map<String, Integer> environmentsSquareFeetExpected = new HashMap<>();
        for (Environment r : property.getEnvironmentList()) {
            environmentsSquareFeetExpected.put(r.getEnvironment_name(), r.getSquareFeet());
        }

        CalculateResponseDTO responseDTO = calculateService.calculateEnvironmentsSquareMeters(property.getPropId());

        verify(propertyRepository, Mockito.atLeastOnce()).findProperty(property.getPropId());
        Assertions.assertEquals(environmentsSquareFeetExpected, responseDTO.getEnvironmentsSquareMeters());

    }

    @Test
    public void getEnvironmentSquareMetersWellCalculatedException() {
        when(propertyRepository.findProperty(1)).thenReturn(null);
        assertThrows(PropertyNotFoundException.class, () -> calculateService.calculateEnvironmentsSquareMeters(1));
    }
}
