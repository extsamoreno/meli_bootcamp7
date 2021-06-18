package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.dto.PropertyDTO;
import com.didney.junit.tucasitatasaciones.dto.response.*;
import com.didney.junit.tucasitatasaciones.mapper.PropertyMapper;
import com.didney.junit.tucasitatasaciones.model.District;
import com.didney.junit.tucasitatasaciones.model.Environment;
import com.didney.junit.tucasitatasaciones.model.Property;
import com.didney.junit.tucasitatasaciones.repository.IPropertyRepository;
import com.didney.junit.tucasitatasaciones.util.PropertyUtil;
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
class PropertyServiceTest {

    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    PropertyUtil propertyUtil;

    @Mock
    PropertyMapper propertyMapper;

    @InjectMocks
    PropertyService propertyService;

    @Test
    void getTotalSquareMeterProperty() {
        //arrange
        int id = 0;
        TotalSquareMeterPropertyDTOResponse expected = new TotalSquareMeterPropertyDTOResponse("Property 1", 118);
        when(iPropertyRepository.getPropertyById(id)).thenReturn(getProperty());
        when(propertyUtil.getTotalMeterSquare(getProperty())).thenReturn(expected);
        //act
        TotalSquareMeterPropertyDTOResponse received = propertyService.getTotalSquareMeterProperty(id);
        //assert
        verify(iPropertyRepository, atLeast(1)).getPropertyById(id);
        verify(propertyUtil, atLeast(1)).getTotalMeterSquare(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void getTotalValuePropertyByEnvironment() {
        //arrange
        int id = 0;
        TotalValuePropertyByEnvironmentDTOResponse expected = new TotalValuePropertyByEnvironmentDTOResponse("Property 1", 20150);
        when(iPropertyRepository.getPropertyById(id)).thenReturn(getProperty());
        when(propertyUtil.getTotalValueProperty(getProperty())).thenReturn(expected);
        //act
        TotalValuePropertyByEnvironmentDTOResponse received = propertyService.getTotalValuePropertyByEnvironment(id);
        //assert
        verify(iPropertyRepository, atLeast(1)).getPropertyById(id);
        verify(propertyUtil, atLeast(1)).getTotalValueProperty(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void getBiggerEnvironment() {
        //arrange
        int id = 0;
        EnvironmentDTOResponse expected = new EnvironmentDTOResponse("Property 1", getPropertyDTOList());
        when(iPropertyRepository.getPropertyById(id)).thenReturn(getProperty());
        when(propertyUtil.getBiggerEnvironment(getProperty())).thenReturn(expected);
        //act
        EnvironmentDTOResponse received = propertyService.getBiggerEnvironment(id);
        //assert
        verify(iPropertyRepository, atLeast(1)).getPropertyById(id);
        verify(propertyUtil, atLeast(1)).getBiggerEnvironment(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void getTotalSquareMeterByEnvironment() {
        //arrange
        int id = 0;
        TotalSquareMeterByEnvironmentDTOResponse expected = new TotalSquareMeterByEnvironmentDTOResponse("Property 1", getEnvironmentSquareMeterDTOResponse());
        when(iPropertyRepository.getPropertyById(id)).thenReturn(getProperty());
        when(propertyUtil.getEnvironmentSquareMeter(getProperty())).thenReturn(expected);
        //act
        TotalSquareMeterByEnvironmentDTOResponse received = propertyService.getTotalSquareMeterByEnvironment(id);
        //assert
        verify(iPropertyRepository, atLeast(1)).getPropertyById(id);
        verify(propertyUtil, atLeast(1)).getEnvironmentSquareMeter(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void addProperty() {
        //arrange
        PropertyDTO expected = getPropertyDTO();
        PropertyDTO property = getPropertyDTO();
        when(propertyMapper.propertyDTOToProperty(getPropertyDTO())).thenReturn(getProperty());
        when(iPropertyRepository.addProperty(getProperty())).thenReturn(getProperty());
        when(propertyMapper.propertyToPropertyDTO(getProperty())).thenReturn(property);
        //act
        PropertyDTO received = propertyService.addProperty(getPropertyDTO());
        //assert
        verify(propertyMapper, atLeast(1)).propertyDTOToProperty(getPropertyDTO());
        verify(iPropertyRepository, atLeast(1)).addProperty(getProperty());
        verify(propertyMapper, atLeast(1)).propertyToPropertyDTO(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void addProperties() {
        //arrange
        List<PropertyDTO> expected = new ArrayList<>();
        expected.add(getPropertyDTO());
        expected.add(getPropertyDTO());
        List<PropertyDTO> listSend = new ArrayList<>();
        listSend.add(getPropertyDTO());
        listSend.add(getPropertyDTO());
        PropertyDTO property = getPropertyDTO();
        when(propertyMapper.propertyDTOToProperty(getPropertyDTO())).thenReturn(getProperty());
        when(iPropertyRepository.addProperty(getProperty())).thenReturn(getProperty());
        when(propertyMapper.propertyToPropertyDTO(getProperty())).thenReturn(property);
        //act
        List<PropertyDTO> received = propertyService.addProperties(listSend);
        //assert
        verify(propertyMapper, atLeast(listSend.size())).propertyDTOToProperty(getPropertyDTO());
        verify(iPropertyRepository, atLeast(listSend.size())).addProperty(getProperty());
        verify(propertyMapper, atLeast(listSend.size())).propertyToPropertyDTO(getProperty());
        assertEquals(expected, received);
    }

    @Test
    void getPropertiesList() {
        //arrange
        List<Property> propertyList = new ArrayList<>();
        propertyList.add(getProperty());
        propertyList.add(getProperty());
        List<PropertyDTO> expected = new ArrayList<>();
        expected.add(getPropertyDTO());
        expected.add(getPropertyDTO());
        when(iPropertyRepository.getProperties()).thenReturn(propertyList);
        when(propertyMapper.propertyToPropertyDTO(propertyList)).thenReturn(expected);
        //act
        List<PropertyDTO> received = propertyService.getPropertiesList();
        //assert
        verify(iPropertyRepository, atLeast(1)).getProperties();
        assertEquals(expected, received);
    }

    private PropertyDTO getPropertyDTO() {
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistrictName("Distrito 1");
        districtDTO.setDistrictPrice(4000.0);
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();
        EnvironmentDTO environmentDTO = new EnvironmentDTO();
        environmentDTO.setEnvironmentName("Habitación 1");
        environmentDTO.setEnvironmentLength(12);
        environmentDTO.setEnvironmentWidth(18);
        environmentDTOList.add(environmentDTO);
        environmentDTO.setEnvironmentName("Habitación 2");
        environmentDTO.setEnvironmentLength(14);
        environmentDTO.setEnvironmentWidth(25);
        environmentDTOList.add(environmentDTO);
        return new PropertyDTO("Propiedad 1", districtDTO, environmentDTOList);

    }

    private List<EnvironmentDTO> getPropertyDTOList() {
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistrictName("Distrito 1");
        districtDTO.setDistrictPrice(4000.0);
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();
        EnvironmentDTO environmentDTO = new EnvironmentDTO();
        environmentDTO.setEnvironmentName("Habitación 1");
        environmentDTO.setEnvironmentLength(12);
        environmentDTO.setEnvironmentWidth(18);
        environmentDTOList.add(environmentDTO);
        environmentDTO.setEnvironmentName("Habitación 2");
        environmentDTO.setEnvironmentLength(14);
        environmentDTO.setEnvironmentWidth(25);
        environmentDTOList.add(environmentDTO);
        return environmentDTOList;

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

    private List<EnvironmentSquareMeterDTOResponse> getEnvironmentSquareMeterDTOResponse() {
        List<EnvironmentSquareMeterDTOResponse> environmentSquareMeterDTOResponses = new ArrayList<>();
        environmentSquareMeterDTOResponses.add(new EnvironmentSquareMeterDTOResponse("Habitacion 1", 65));
        environmentSquareMeterDTOResponses.add(new EnvironmentSquareMeterDTOResponse("Habitacion 2", 1500));
        return environmentSquareMeterDTOResponses;

    }
}