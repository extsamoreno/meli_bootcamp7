package com.didney.junit.tucasitatasaciones.controller;

import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.service.IEnvironmentService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EnvironmentControllerTest {
    @Mock
    IEnvironmentService iEnvironmentService;
    @InjectMocks
    EnvironmentController environmentController;

    @Test
    void addEnvironment() {

        //arrange
        EnvironmentDTO districtDTO = getEnvironmentDTO();
        EnvironmentDTO expected = getEnvironmentDTO();
        ResponseEntity<EnvironmentDTO> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iEnvironmentService.addEnvironment(districtDTO)).thenReturn(objExpected.getBody());
        //act
        ResponseEntity<EnvironmentDTO> received = environmentController.addEnvironment(districtDTO);
        //assert
        Mockito.verify(iEnvironmentService, Mockito.atLeastOnce()).addEnvironment(districtDTO);
        Assertions.assertEquals(objExpected, received);

    }

    @Test
    void addEnvironments() {
        //arrange
        List<EnvironmentDTO> districtDTOList = new ArrayList<>();
        districtDTOList.add(getEnvironmentDTO());
        districtDTOList.add(getEnvironmentDTO2());
        List<EnvironmentDTO> expected = new ArrayList<>();
        expected.add(getEnvironmentDTO());
        expected.add(getEnvironmentDTO2());
        ResponseEntity<List<EnvironmentDTO>> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iEnvironmentService.addEnvironments(districtDTOList)).thenReturn(expected);
        //act
        ResponseEntity<List<EnvironmentDTO>> received = environmentController.addEnvironments(districtDTOList);
        //assert
        Mockito.verify(iEnvironmentService, Mockito.atLeastOnce()).addEnvironments(districtDTOList);
        assertEquals(objExpected, received);
    }

    @Test
    void getEnvironment() {
        //arrange
        List<EnvironmentDTO> districtDTOList = new ArrayList<>();
        districtDTOList.add(getEnvironmentDTO());
        ResponseEntity<List<EnvironmentDTO>> expected = new ResponseEntity<>(districtDTOList, HttpStatus.OK);

        Mockito.when(iEnvironmentService.getEnvironment()).thenReturn(expected.getBody());
        //act
        ResponseEntity<List<EnvironmentDTO>> received = environmentController.getEnvironment();
        //assert
        Mockito.verify(iEnvironmentService, Mockito.atLeastOnce()).getEnvironment();
        assertEquals(expected, received);
    }

    private EnvironmentDTO getEnvironmentDTO() {
        return new EnvironmentDTO("Environment 1", 25, 12);
    }

    private EnvironmentDTO getEnvironmentDTO2() {
        return new EnvironmentDTO("Environment 2", 18, 25);
    }
}