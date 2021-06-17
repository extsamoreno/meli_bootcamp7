package com.TuCasitaTasacionesAPI.TuCasita.unit;

import com.TuCasitaTasacionesAPI.TuCasita.UtilsDataTests;
import com.TuCasitaTasacionesAPI.TuCasita.dtos.*;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.Environment;
import com.TuCasitaTasacionesAPI.TuCasita.models.Property;
import com.TuCasitaTasacionesAPI.TuCasita.repositories.IPropertyRepository;
import com.TuCasitaTasacionesAPI.TuCasita.services.IDistrictService;
import com.TuCasitaTasacionesAPI.TuCasita.services.PropertyService;
import com.jayway.jsonpath.internal.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceUnitTest {

    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    IDistrictService iDistrictService;

    @Mock
    ModelMapper mapper;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void calculateM2withIdValid() throws PropertyNotFoundException {
        int id = 1;
        TotalM2DTO expected = UtilsDataTests.generateTotalM2DTO();
        Property prop = UtilsDataTests.generateProperty();

        when(iPropertyRepository.getById(1)).thenReturn(prop);

        TotalM2DTO received = propertyService.calculateM2(id);

        assertEquals(expected, received);
    }

    @Test
    public void calculatePriceWithIdValid() throws PropertyNotFoundException, DistrictNotFoundException {
        int id = 1;
        PricePropertyDTO expected = UtilsDataTests.generatePricePropertyDTO();
        Property prop = UtilsDataTests.generateProperty();

        DistrictDTO districtDTO = new DistrictDTO("San Isidro", 200.0);

        when(iPropertyRepository.getById(1)).thenReturn(prop);
        when(iDistrictService.getById(prop.getDistrict_id())).thenReturn(districtDTO);

        PricePropertyDTO received = propertyService.calculatePrice(id);

        assertEquals(expected, received);
    }

    @Test
    public void environmentBiggestWithIdValid() throws PropertyNotFoundException {
        int id = 1;
        EnvironmentBiggestDTO expected = UtilsDataTests.generateEnvironmentBiggestDto();

        Property prop = UtilsDataTests.generateProperty();
        Environment envi = UtilsDataTests.generateEnvironment();
        EnvironmentDTO enviDTO = UtilsDataTests.generateEnvironmentDTO();

        when(iPropertyRepository.getById(1)).thenReturn(prop);
        when(mapper.map(envi, EnvironmentDTO.class)).thenReturn(enviDTO);

        EnvironmentBiggestDTO received = propertyService.environmentBiggest(id);

        assertEquals(expected, received);
    }

    @Test
    public void m2perEnvironmentsWithIdValid() throws PropertyNotFoundException {
        int id = 1;

        M2perEnvironmentsDTO expected = new M2perEnvironmentsDTO(UtilsDataTests.generateListEnviroments());
        Property prop = UtilsDataTests.generateProperty();

        when(iPropertyRepository.getById(1)).thenReturn(prop);

        M2perEnvironmentsDTO received = propertyService.m2perEnvironments(id);

        assertEquals(expected, received);
    }


}
