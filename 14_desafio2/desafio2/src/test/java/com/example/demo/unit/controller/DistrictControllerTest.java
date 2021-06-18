package com.example.demo.unit.controller;

import com.example.demo.controller.DistrictController;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.models.District;
import com.example.demo.service.IHouseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class DistrictControllerTest {
    @Mock
    IHouseService iHouseService;
    @InjectMocks
    DistrictController districtController;
    @Test
    public void addNewDistrictHappyPath () throws DistrictNotFoundException {
        //arrange
        District expect = new District("Compartir",300);
        //act
        ResponseEntity<Void> response = districtController.addNewDistrict(expect);
        //assert
        Mockito.verify(iHouseService,Mockito.atLeast(1)).addDistrict(expect);
        assert (response.getStatusCode()== HttpStatus.OK);
    }
}
