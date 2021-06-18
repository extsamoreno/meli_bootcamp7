package com.example.demo.services;

import com.example.demo.DTO.*;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.Utils.UtilTest;
import com.example.demo.entities.Property;
import com.example.demo.repositories.IDistrictRepository;
import com.example.demo.repositories.IPropertyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    IDistrictRepository iDistrictRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void calculateTotalMetersOkTest() throws Exception {
        Property property = UtilTest.getPropertyWithEnvironments();
        ResponseCalculateTotalMetersDTO aux = new ResponseCalculateTotalMetersDTO();
        aux.setName(property.getName());
        aux.setTotalMeters(25);

        when(iPropertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(aux, propertyService.getResponseCalculateTotalMetersDTO(1));
    }
    @Test
    public void calculateTotalMetersErrorNotFoundTest() throws Exception {
        when(iPropertyRepository.getPropertyById(1)).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getResponseCalculateTotalMetersDTO(1));
    }

    @Test
    public void biggerEnvironmentOkTest() throws Exception {
        Property property = UtilTest.getPropertyWithEnvironments();
        ResponseBiggerEnvironmentDTO aux = new ResponseBiggerEnvironmentDTO();
        aux.setName(property.getName());
        aux.setEnvironmentName("Room");
        aux.setBiggerEnvironmentMeters(16);

        when(iPropertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(aux, propertyService.getBiggerEnvironment(1));
    }

    @Test
    public void biggerEnvironmentErrorNotFoundPropertyTest() throws Exception {
        when(iPropertyRepository.getPropertyById(1)).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getBiggerEnvironment(1));
    }
    @Test
    public void biggerEnvironmentErrorNotFoundEnvironmentsTest() throws Exception {
        Property property = UtilTest.getPropertyWithoutEnvironments();

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getBiggerEnvironment(property.getId()));
    }


    @Test
    public void totalMetersByEnvironmentOkTest() throws Exception {
        Property property = UtilTest.getPropertyWithEnvironments();

        ResponseTotalMetersByEnvironmentDTO aux = new ResponseTotalMetersByEnvironmentDTO();
        aux.setNameProperty(property.getName());
        aux.setEnvironments(UtilTest.toEnvironmentsDTO(property.getEnvironments()));

        when(iPropertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(aux, propertyService.getTotalMetersByEnvironment(1));
    }

    @Test
    public void totalMetersByEnvironmentErrorNotFoundPropertyTest() throws Exception {
        when(iPropertyRepository.getPropertyById(1)).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getTotalMetersByEnvironment(1));
    }
    @Test
    public void totalMetersByEnvironmentErrorNotFoundEnvironmentsTest() throws Exception {
        Property property = UtilTest.getPropertyWithoutEnvironments();

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getTotalMetersByEnvironment(property.getId()));
    }

    @Test
    public void PriceOkTest() throws Exception {
        Property property = UtilTest.getPropertyWithEnvironments();
        ResponsePriceDTO aux = new ResponsePriceDTO();

        aux.setPropertyId(property.getId());
        aux.setPropertyName(property.getName());
        aux.setPrice(175);

        when(iPropertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(aux, propertyService.getPrice(1));
    }
    @Test
    public void priceErrorNotFoundPropertyTest() throws Exception {
        when(iPropertyRepository.getPropertyById(1)).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getPrice(1));
    }
    @Test
    public void priceErrorNotFoundEnvironmentsTest() throws Exception {
        Property property = UtilTest.getPropertyWithoutEnvironments();

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getPrice(property.getId()));
    }

    @Test
    public void addPropertyOkTest() throws Exception {
        PropertyDTO propertyDTO = UtilTest.getPropertyDTOWithEnvironments();
        Property property = UtilTest.toProperty(propertyDTO);

        when(iDistrictRepository.findDistrictByName(property.getDistrict().getName())).thenReturn(property.getDistrict());
        propertyService.addProperty(propertyDTO);
        verify(iPropertyRepository, times(1)).addProperty(property);
    }

    @Test
    public void addPropertyNotFoundDistrictTest() throws Exception {
        PropertyDTO propertyDTO = UtilTest.getPropertyWithoutDistrict();

        when(iDistrictRepository.findDistrictByName(propertyDTO.getDistrictName())).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.addProperty(propertyDTO));
    }

    @Test
    public void addPropertyBadRequestPropertyAlreadyExistsTest() throws Exception {

        Property property = UtilTest.getPropertyWithEnvironments();
        iPropertyRepository.addProperty(property);

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);

        Assertions.assertThrows(BadRequestException.class, () -> propertyService.addProperty(UtilTest.toPropertyDTO(property)));

    }
}
