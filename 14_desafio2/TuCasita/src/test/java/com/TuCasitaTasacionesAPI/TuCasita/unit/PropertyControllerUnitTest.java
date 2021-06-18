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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

        ResponseEntity<TotalM2DTO> received = propertyController.calculateM2(id);

        verify(iPropertyService, atLeastOnce()).calculateM2(id);
        assertEquals(expected, received.getBody());
        assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void calculatePriceWithIdValid() throws PropertyNotFoundException, DistrictNotFoundException {
        int id = 1;
        PricePropertyDTO expected = UtilsDataTests.generatePricePropertyDTO();
        when(iPropertyService.calculatePrice(1)).thenReturn(expected);

        ResponseEntity<PricePropertyDTO> received = propertyController.calculatePrice(id);

        verify(iPropertyService, atLeastOnce()).calculatePrice(id);
        assertEquals(expected, received.getBody());
        assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void environmentBiggestWithIdValid() throws PropertyNotFoundException {
        int id = 1;
        EnvironmentBiggestDTO expected = UtilsDataTests.generateEnvironmentBiggestDto();

        when(iPropertyService.environmentBiggest(1)).thenReturn(expected);

        ResponseEntity<EnvironmentBiggestDTO> received = propertyController.environmentBiggest(id);

        verify(iPropertyService, atLeast(1)).environmentBiggest(id);
        assertEquals(expected, received.getBody());
        assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void m2perEnvironmentsWithIdValid() throws PropertyNotFoundException {
        int id = 1;

        M2perEnvironmentsDTO expected = new M2perEnvironmentsDTO(UtilsDataTests.generateListEnviroments());

        when(iPropertyService.m2perEnvironments(1)).thenReturn(expected);

        ResponseEntity<M2perEnvironmentsDTO> received = propertyController.m2perEnvironments(id);

        verify(iPropertyService, atLeastOnce()).m2perEnvironments(id);
        assertEquals(expected, received.getBody());
        assertEquals(HttpStatus.OK, received.getStatusCode());
    }





}
