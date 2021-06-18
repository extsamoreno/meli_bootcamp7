package com.example.demo.unit.controllers;

import com.example.demo.Utils;
import com.example.demo.controllers.DistrictController;
import com.example.demo.dtos.DistrictDTO;
import com.example.demo.dtos.DistrictRequestDTO;
import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.services.DistrictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class DistrictControllerTest {

    @Mock
    DistrictService districtService;

    @InjectMocks
    DistrictController districtController;

    @Test
    public void createDistrictHappyPath() {

        //arrange
        DistrictRequestDTO expected = Utils.getDistrictRequestDTO();

        Mockito.when(districtService.createDistrict(expected)).thenReturn(expected);

        //act
        ResponseEntity receivedR = districtController.createDistrict(expected);
        DistrictRequestDTO received = (DistrictRequestDTO) receivedR.getBody();

        //assert
        Mockito.verify(districtService, Mockito.atLeastOnce()).createDistrict(expected);
        Assertions.assertEquals(expected,received);

    }


    @Test
    public void findDistrictByIdHappyPath() throws DistrictDontFoundException {
        //arrange
        DistrictDTO expected = Utils.getDistrictDTO();
        int id = 1;
        Mockito.when(districtService.findDistrictById(id)).thenReturn(expected);

        //act
        ResponseEntity receivedR = districtController.findDistrictById(id);
        DistrictDTO received = (DistrictDTO) receivedR.getBody();

        //assert
        Mockito.verify(districtService, Mockito.atLeastOnce()).findDistrictById(id);
        Assertions.assertEquals(expected,received);
    }

}
