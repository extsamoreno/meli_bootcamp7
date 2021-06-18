package com.didney.junit.tucasitatasaciones.util;

import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.dto.response.*;
import com.didney.junit.tucasitatasaciones.model.District;
import com.didney.junit.tucasitatasaciones.model.Environment;
import com.didney.junit.tucasitatasaciones.model.Property;
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
class PropertyUtilTest {

    @Mock
    PropertyUtil propertyUtil;

    @Test
    void getTotalMeterSquare() {
        //arrange
        TotalSquareMeterPropertyDTOResponse expected = new TotalSquareMeterPropertyDTOResponse("Property 1", 20150);
        when(propertyUtil.getTotalMeterSquare(getProperty())).thenReturn(expected);
        //act
        TotalSquareMeterPropertyDTOResponse received = propertyUtil.getTotalMeterSquare(getProperty());
        //assert
        verify(propertyUtil, atLeast(1)).getTotalMeterSquare(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void getTotalValueProperty() {
        //arrange
        TotalValuePropertyByEnvironmentDTOResponse expected = new TotalValuePropertyByEnvironmentDTOResponse("Property 1", 20150);
        when(propertyUtil.getTotalValueProperty(getProperty())).thenReturn(expected);
        //act
        TotalValuePropertyByEnvironmentDTOResponse received = propertyUtil.getTotalValueProperty(getProperty());
        //assert
        verify(propertyUtil, atLeast(1)).getTotalValueProperty(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void getBiggerEnvironment() {
        //arrange
        List<EnvironmentDTO> environmentDTOS = new ArrayList<>();
        environmentDTOS.add(new EnvironmentDTO("Habitación 1", 15, 2));
        EnvironmentDTOResponse expected = new EnvironmentDTOResponse("Property 1", environmentDTOS);
        when(propertyUtil.getBiggerEnvironment(getProperty())).thenReturn(expected);
        //act
        EnvironmentDTOResponse received = propertyUtil.getBiggerEnvironment(getProperty());
        //assert
        verify(propertyUtil, atLeast(1)).getBiggerEnvironment(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void getEnvironmentSquareMeter() {
        //arrange
        List<EnvironmentSquareMeterDTOResponse> environments = new ArrayList<>();
        environments.add(new EnvironmentSquareMeterDTOResponse("Habitación 1", 30));
        TotalSquareMeterByEnvironmentDTOResponse expected = new TotalSquareMeterByEnvironmentDTOResponse("Property 1", environments);
        when(propertyUtil.getEnvironmentSquareMeter(getProperty())).thenReturn(expected);
        //act
        TotalSquareMeterByEnvironmentDTOResponse received = propertyUtil.getEnvironmentSquareMeter(getProperty());
        //assert
        verify(propertyUtil, atLeast(1)).getEnvironmentSquareMeter(getProperty());
        assertEquals(expected, received);
    }

    private Property getProperty() {
        District district = new District();
        district.setId(1);
        district.setDistrictName("Distrito 1");
        district.setDistrictPrice(4000.0);
        List<Environment> environmentList = new ArrayList<>();
        Environment environment = new Environment();
        environment.setId(1);
        environment.setEnvironmentName("Habitación 1");
        environment.setEnvironmentLength(12);
        environment.setEnvironmentWidth(18);
        environmentList.add(environment);
        environment.setId(2);
        environment.setEnvironmentName("Habitación 2");
        environment.setEnvironmentLength(14);
        environment.setEnvironmentWidth(25);
        environmentList.add(environment);
        return new Property(1, "Propiedad 1", district, environmentList);

    }
}