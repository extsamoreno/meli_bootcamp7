package com.example.demo.services;

import com.example.demo.DTO.*;
import com.example.demo.Mapper;
import com.example.demo.Utils.UtilTest;
import com.example.demo.controllers.PropertyController;
import com.example.demo.entities.Property;
import com.example.demo.repositories.IDistrictRepository;
import com.example.demo.repositories.IPropertyRepository;
import com.example.demo.repositories.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void getResponseCalculateTotalMetersDTOTest() throws Exception {
        Property property = UtilTest.getPropertyWithEnvironments();
        ResponseCalculateTotalMetersDTO aux = new ResponseCalculateTotalMetersDTO();
        aux.setName(property.getName());
        aux.setTotalMeters(25);

        when(iPropertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(aux, propertyService.getResponseCalculateTotalMetersDTO(1));
    }

    @Test
    public void getBiggerEnvironmentTest() throws Exception {
        Property property = UtilTest.getPropertyWithEnvironments();
        ResponseBiggerEnvironmentDTO aux = new ResponseBiggerEnvironmentDTO();
        aux.setName(property.getName());
        aux.setEnvironmentName("Room");
        aux.setBiggerEnvironmentMeters(16);

        when(iPropertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(aux, propertyService.getBiggerEnvironment(1));
    }

    @Test
    public void getTotalMetersByEnvironmentTest() throws Exception {
        Property property = UtilTest.getPropertyWithEnvironments();

        ResponseTotalMetersByEnvironmentDTO aux = new ResponseTotalMetersByEnvironmentDTO();
        aux.setNameProperty(property.getName());
        aux.setEnvironments(UtilTest.toEnvironmentsDTO(property.getEnvironments()));

        when(iPropertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(aux, propertyService.getTotalMetersByEnvironment(1));
    }

    @Test
    public void getPriceTest() throws Exception {
        Property property = UtilTest.getPropertyWithEnvironments();
        ResponsePriceDTO aux = new ResponsePriceDTO();

        aux.setPropertyId(property.getId());
        aux.setPropertyName(property.getName());
        aux.setPrice(175);

        when(iPropertyRepository.getPropertyById(1)).thenReturn(property);
        assertEquals(aux, propertyService.getPrice(1));
    }

    @Test
    public void addPropertyTest() throws Exception {
        PropertyDTO propertyDTO = UtilTest.getPropertyDTOWithEnvironments();
        Property property = UtilTest.toProperty(propertyDTO);

        when(iDistrictRepository.findDistrictByName(property.getDistrict().getName())).thenReturn(property.getDistrict());
        propertyService.addProperty(propertyDTO);
        verify(iPropertyRepository, times(1)).addProperty(property);
    }
}
