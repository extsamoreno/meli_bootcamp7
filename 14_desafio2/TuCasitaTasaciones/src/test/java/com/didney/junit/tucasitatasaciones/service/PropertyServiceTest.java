package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.dto.PropertyDTO;
import com.didney.junit.tucasitatasaciones.dto.response.TotalSquareMeterPropertyDTOResponse;
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
import org.springframework.http.HttpStatus;

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

    @InjectMocks
    PropertyService propertyService;

    @Test
    void getTotalSquareMeterProperty() {
        //arrange
        int id =0;
        TotalSquareMeterPropertyDTOResponse expected = new TotalSquareMeterPropertyDTOResponse(HttpStatus.OK,118);
        when(iPropertyRepository.getPropertyById(id)).thenReturn(getProperty());
        when(propertyUtil.getTotalMeterSquare(getProperty())).thenReturn(118.0);
        //act
        TotalSquareMeterPropertyDTOResponse received = propertyService.getTotalSquareMeterProperty(id);
        //assert
        verify(iPropertyRepository, atLeast(1)).getPropertyById(id);
        verify(propertyUtil,atLeast(1)).getTotalMeterSquare(getProperty());
        assertEquals(expected,received);
    }

    @Test
    void getTotalValuePropertyByEnvironment() {
        //arrange
        int id =0;
        TotalSquareMeterPropertyDTOResponse expected = new TotalSquareMeterPropertyDTOResponse(HttpStatus.OK,118);
        when(iPropertyRepository.getPropertyById(id)).thenReturn(getProperty());
        when(propertyUtil.getTotalMeterSquare(getProperty())).thenReturn(118.0);
        //act
        TotalSquareMeterPropertyDTOResponse received = propertyService.getTotalSquareMeterProperty(id);
        //assert
        verify(iPropertyRepository, atLeast(1)).getPropertyById(id);
        verify(propertyUtil,atLeast(1)).getTotalMeterSquare(getProperty());
        assertEquals(expected,received);
    }

    @Test
    void getBiggerEnvironment() {
        //arrange

        //act

        //assert

    }

    @Test
    void getTotalSquareMeterByEnvironment() {
        //arrange

        //act

        //assert

    }

    @Test
    void addProperty() {
        //arrange

        //act

        //assert

    }

    @Test
    void addProperties() {
        //arrange

        //act

        //assert

    }

    @Test
    void getPropertiesList() {
        //arrange

        //act

        //assert

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
        return new Property(1,"Propiedad 1", district, environmentList);

    }
}