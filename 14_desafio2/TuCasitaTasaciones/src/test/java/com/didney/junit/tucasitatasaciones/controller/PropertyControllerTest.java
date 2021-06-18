package com.didney.junit.tucasitatasaciones.controller;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.dto.PropertyDTO;
import com.didney.junit.tucasitatasaciones.dto.response.*;
import com.didney.junit.tucasitatasaciones.service.IPropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyControllerTest {
    @Mock
    IPropertyService iPropertyService;
    @InjectMocks
    PropertyController propertyController;

    @Test
    void getTotalSquareMeterProperty() {
        //arrange
        TotalSquareMeterPropertyDTOResponse expected = new TotalSquareMeterPropertyDTOResponse(HttpStatus.OK, 566);
        Mockito.when(iPropertyService.getTotalSquareMeterProperty(0)).thenReturn(expected);
        //act
        TotalSquareMeterPropertyDTOResponse received = propertyController.getTotalSquareMeterProperty(0);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getTotalSquareMeterProperty(0);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void getTotalValuePropertyByEnvironment() {
        //arrange
        TotalValuePropertyByEnvironmentDTOResponse expected = new TotalValuePropertyByEnvironmentDTOResponse(HttpStatus.OK, 15);
        Mockito.when(iPropertyService.getTotalValuePropertyByEnvironment(0)).thenReturn(expected);
        //act
        TotalValuePropertyByEnvironmentDTOResponse received = propertyController.getTotalValuePropertyByEnvironment(0);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getTotalValuePropertyByEnvironment(0);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void getBiggerEnvironment() {
        //arrange
        List<EnvironmentDTO> environmentDTOList = getListEnvironmentDTO();
        EnvironmentDTOResponse expected = new EnvironmentDTOResponse(HttpStatus.OK, environmentDTOList);
        Mockito.when(iPropertyService.getBiggerEnvironment(0)).thenReturn(expected);
        //act
        EnvironmentDTOResponse received = propertyController.getBiggerEnvironment(0);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getBiggerEnvironment(0);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void getTotalSquareMeterByEnvironment() {
        //arrange
        List<EnvironmentSquareMeterResponse> environmentDTOList = getListEnvironmentSquareMeterResponse();
        TotalSquareMeterByEnvironmentResponse expected = new TotalSquareMeterByEnvironmentResponse(HttpStatus.OK, environmentDTOList);
        Mockito.when(iPropertyService.getTotalSquareMeterByEnvironment(0)).thenReturn(expected);
        //act
        TotalSquareMeterByEnvironmentResponse received = propertyController.getTotalSquareMeterByEnvironment(0);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getTotalSquareMeterByEnvironment(0);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void addProperty() {
        //arrange
        PropertyDTO propertyDTO = getPropertyDTO();
        PropertyDTO expected = getPropertyDTO();
        ResponseEntity<?> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iPropertyService.addProperty(propertyDTO)).thenReturn(expected);
        //act
        ResponseEntity<?> received = propertyController.addProperty(propertyDTO);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).addProperty(propertyDTO);
        Assertions.assertEquals(objExpected, received);
    }

    @Test
    void addProperties() {
        //arrange
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        propertyDTOList.add(getPropertyDTO());
        propertyDTOList.add(getPropertyDTO2());
        List<PropertyDTO> expected = new ArrayList<>();
        expected.add(getPropertyDTO());
        expected.add(getPropertyDTO2());
        ResponseEntity<?> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iPropertyService.addProperties(propertyDTOList)).thenReturn(expected);
        //act
        ResponseEntity<?> received = propertyController.addProperties(propertyDTOList);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).addProperties(propertyDTOList);
        assertEquals(objExpected, received);
    }

    @Test
    void getProperties() {
        //arrange
        List<PropertyDTO> expected = new ArrayList<>();
        List<PropertyDTO> propertyDTOS = new ArrayList<>();
        propertyDTOS.add(getPropertyDTO());
        expected.add(getPropertyDTO());
        ResponseEntity<?> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iPropertyService.getPropertiesList()).thenReturn(propertyDTOS);
        //act
        ResponseEntity<List<PropertyDTO>> received = propertyController.getProperties();
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getPropertiesList();
        assertEquals(objExpected, received);
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

    private PropertyDTO getPropertyDTO2() {
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistrictName("Distrito 2");
        districtDTO.setDistrictPrice(2000.0);
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
        return new PropertyDTO("Propiedad 2", districtDTO, environmentDTOList);
    }

    private List<EnvironmentDTO> getListEnvironmentDTO() {
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

    private List<EnvironmentSquareMeterResponse> getListEnvironmentSquareMeterResponse() {
        List<EnvironmentSquareMeterResponse> environmentDTOList = new ArrayList<>();
        EnvironmentSquareMeterResponse environmentDTO = new EnvironmentSquareMeterResponse();
        environmentDTO.setEnvironmentName("Habitación 1");
        environmentDTO.setTotalSquareMeter(12);
        environmentDTOList.add(environmentDTO);
        environmentDTO.setEnvironmentName("Habitación 2");
        environmentDTO.setTotalSquareMeter(25);
        environmentDTOList.add(environmentDTO);
        return environmentDTOList;
    }
}