package com.TuCasitaTasacionesAPI.TuCasita.unit;

import com.TuCasitaTasacionesAPI.TuCasita.UtilsDataTests;
import com.TuCasitaTasacionesAPI.TuCasita.controllers.PropertyController;
import com.TuCasitaTasacionesAPI.TuCasita.dtos.*;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.services.IPropertyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerUnitTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void calculateM2withIdValid() throws PropertyNotFoundException {
        int id = 1;
        TotalM2DTO expected = UtilsDataTests.generateTotalM2DTO();
        when(iPropertyService.calculateM2(1)).thenReturn(expected);

        TotalM2DTO received = propertyController.calculateM2(id).getBody();

        verify(iPropertyService, atLeastOnce()).calculateM2(id);
        assertEquals(expected, received);
    }

    @Test
    public void calculatePriceWithIdValid() throws PropertyNotFoundException, DistrictNotFoundException {
        int id = 1;
        PricePropertyDTO expected = UtilsDataTests.generatePricePropertyDTO();
        when(iPropertyService.calculatePrice(1)).thenReturn(expected);

        PricePropertyDTO received = propertyController.calculatePrice(id).getBody();

        verify(iPropertyService, atLeastOnce()).calculatePrice(id);
        assertEquals(expected, received);
    }

    @Test
    public void environmentBiggestWithIdValid() throws PropertyNotFoundException {
        int id = 1;
        EnvironmentBiggestDTO expected = UtilsDataTests.generateEnvironmentBiggestDto();

        when(iPropertyService.environmentBiggest(1)).thenReturn(expected);

        EnvironmentBiggestDTO received = propertyController.environmentBiggest(id).getBody();

        verify(iPropertyService, atLeast(1)).environmentBiggest(id);
        assertEquals(expected, received);
    }

    @Test
    public void m2perEnvironmentsWithIdValid() throws PropertyNotFoundException {
        int id = 1;

        M2perEnvironmentsDTO expected = new M2perEnvironmentsDTO(UtilsDataTests.generateListEnviroments());

        when(iPropertyService.m2perEnvironments(1)).thenReturn(expected);

        M2perEnvironmentsDTO received = propertyController.m2perEnvironments(id).getBody();

        verify(iPropertyService, atLeastOnce()).m2perEnvironments(id);
        assertEquals(expected, received);
    }





}
