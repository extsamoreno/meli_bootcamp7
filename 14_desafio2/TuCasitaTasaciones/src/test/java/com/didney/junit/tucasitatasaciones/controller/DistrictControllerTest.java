package com.didney.junit.tucasitatasaciones.controller;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.service.IDistrictService;
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
class DistrictControllerTest {
    @Mock
    IDistrictService iDistrictService;
    @InjectMocks
    DistrictController districtController;

    @Test
    void addDistrict() {
        //arrange
        DistrictDTO districtDTO = getDistrict();
        DistrictDTO expected = getDistrict();
        ResponseEntity<DistrictDTO> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iDistrictService.addDistrict(districtDTO)).thenReturn(objExpected.getBody());
        //act
        ResponseEntity<DistrictDTO> received = districtController.addDistrict(districtDTO);
        //assert
        Mockito.verify(iDistrictService, Mockito.atLeastOnce()).addDistrict(districtDTO);
        Assertions.assertEquals(objExpected, received);
    }

    @Test
    void addDistricts() {
        //arrange
        List<DistrictDTO> districtDTOList = new ArrayList<>();
        districtDTOList.add(getDistrict());
        districtDTOList.add(getDistrict2());
        List<DistrictDTO> expected = new ArrayList<>();
        expected.add(getDistrict());
        expected.add(getDistrict2());
        ResponseEntity<List<DistrictDTO>> objExpected = new ResponseEntity<>(expected, HttpStatus.OK);
        Mockito.when(iDistrictService.addDistricts(districtDTOList)).thenReturn(expected);
        //act
        ResponseEntity<List<DistrictDTO>> received = districtController.addDistricts(districtDTOList);
        //assert
        Mockito.verify(iDistrictService, Mockito.atLeastOnce()).addDistricts(districtDTOList);
        assertEquals(objExpected, received);
    }

    @Test
    void getDistricts() {
        //arrange
        List<DistrictDTO> districtDTOList = new ArrayList<>();
        districtDTOList.add(getDistrict());
        ResponseEntity<List<DistrictDTO>> expected = new ResponseEntity<>(districtDTOList, HttpStatus.OK);

        Mockito.when(iDistrictService.getDistricts()).thenReturn(expected.getBody());
        //act
        ResponseEntity<List<DistrictDTO>> received = districtController.getDistricts();
        //assert
        Mockito.verify(iDistrictService, Mockito.atLeastOnce()).getDistricts();
        assertEquals(expected, received);
    }

    private DistrictDTO getDistrict() {
        return new DistrictDTO("District 1", 4000);
    }

    private DistrictDTO getDistrict2() {
        return new DistrictDTO("District 2", 1500);
    }
}