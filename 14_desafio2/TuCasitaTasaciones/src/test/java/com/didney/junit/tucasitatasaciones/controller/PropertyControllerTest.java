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
        ResponseEntity<TotalSquareMeterPropertyDTOResponse> expected =
                new ResponseEntity<>(new TotalSquareMeterPropertyDTOResponse("Property 1", 556), HttpStatus.OK);
        Mockito.when(iPropertyService.getTotalSquareMeterProperty(0)).thenReturn(expected.getBody());
        //act
        ResponseEntity<TotalSquareMeterPropertyDTOResponse> received = propertyController.getTotalSquareMeterProperty(0);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getTotalSquareMeterProperty(0);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void getTotalValuePropertyByEnvironment() {
        //arrange
        ResponseEntity<TotalValuePropertyByEnvironmentDTOResponse> expected =
                new ResponseEntity<>(new TotalValuePropertyByEnvironmentDTOResponse("Property 1", 5000), HttpStatus.OK);
        Mockito.when(iPropertyService.getTotalValuePropertyByEnvironment(0)).thenReturn(expected.getBody());
        //act
        ResponseEntity<TotalValuePropertyByEnvironmentDTOResponse> received = propertyController.getTotalValuePropertyByEnvironment(0);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getTotalValuePropertyByEnvironment(0);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void getBiggerEnvironment() {
        //arrange
        ResponseEntity<EnvironmentDTOResponse> expected = new ResponseEntity<>(new EnvironmentDTOResponse("Property 1", getListEnvironmentDTO()), HttpStatus.OK);
        Mockito.when(iPropertyService.getBiggerEnvironment(0)).thenReturn(expected.getBody());
        //act
        ResponseEntity<EnvironmentDTOResponse> received = propertyController.getBiggerEnvironment(0);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getBiggerEnvironment(0);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void getTotalSquareMeterByEnvironment() {
        //arrange
        ResponseEntity<TotalSquareMeterByEnvironmentDTOResponse> expected = new ResponseEntity<>(new TotalSquareMeterByEnvironmentDTOResponse("Property 1", getListEnvironmentSquareMeterResponse()), HttpStatus.OK);
        Mockito.when(iPropertyService.getTotalSquareMeterByEnvironment(0)).thenReturn(expected.getBody());
        //act
        ResponseEntity<TotalSquareMeterByEnvironmentDTOResponse> received = propertyController.getTotalSquareMeterByEnvironment(0);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getTotalSquareMeterByEnvironment(0);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void addProperty() {
        //arrange
        PropertyDTO propertyDTO = getPropertyDTO();
        PropertyDTO expected = getPropertyDTO();
        ResponseEntity<PropertyDTO> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iPropertyService.addProperty(propertyDTO)).thenReturn(expected);
        //act
        ResponseEntity<PropertyDTO> received = propertyController.addProperty(propertyDTO);
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
        ResponseEntity<List<PropertyDTO>> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iPropertyService.addProperties(propertyDTOList)).thenReturn(expected);
        //act
        ResponseEntity<List<PropertyDTO>> received = propertyController.addProperties(propertyDTOList);
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).addProperties(propertyDTOList);
        assertEquals(objExpected, received);
    }

    @Test
    void getProperties() {
        //arrange
        List<PropertyDTO> list = new ArrayList<>();
        list.add(getPropertyDTO());
        ResponseEntity<List<PropertyDTO>> expected = new ResponseEntity<>(list, HttpStatus.OK);
        Mockito.when(iPropertyService.getPropertiesList()).thenReturn(expected.getBody());
        //act
        ResponseEntity<List<PropertyDTO>> received = propertyController.getProperties();
        //assert
        Mockito.verify(iPropertyService, Mockito.atLeastOnce()).getPropertiesList();
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

    private List<EnvironmentSquareMeterDTOResponse> getListEnvironmentSquareMeterResponse() {
        List<EnvironmentSquareMeterDTOResponse> environmentDTOList = new ArrayList<>();
        EnvironmentSquareMeterDTOResponse environmentDTO = new EnvironmentSquareMeterDTOResponse();
        environmentDTO.setEnvironmentName("Habitación 1");
        environmentDTO.setTotalSquareMeter(12);
        environmentDTOList.add(environmentDTO);
        environmentDTO.setEnvironmentName("Habitación 2");
        environmentDTO.setTotalSquareMeter(25);
        environmentDTOList.add(environmentDTO);
        return environmentDTOList;
    }
}