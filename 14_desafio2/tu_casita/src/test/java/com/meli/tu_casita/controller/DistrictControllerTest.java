package com.meli.tu_casita.controller;

import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.service.IDistrictService;
import com.meli.tu_casita.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DistrictControllerTest {

    @Mock
    IDistrictService districtService;

    @InjectMocks
    DistrictController districtController;

    @Test
    public void getDistrictListTest(){
        //Arrange
        List<DistrictDTO> districtDTOList = TestUtilGenerator.getDistrictDTOListTest();
        ResponseEntity<List<DistrictDTO>> responseEntity = new ResponseEntity<>(districtDTOList, HttpStatus.OK);
        Mockito.when(districtService.getDistrictList()).thenReturn(districtDTOList);
        //Act
        ResponseEntity<List<DistrictDTO>> received = districtController.getDistrictList();
        //Assert
        Mockito.verify(districtService, Mockito.atLeastOnce()).getDistrictList();
        Assertions.assertEquals(responseEntity.getStatusCode(), received.getStatusCode());
        Assertions.assertEquals(responseEntity.getBody(), received.getBody());
    }

    @Test
    public void newDistrictTestOK(){
        //Arrange
        DistrictDTO districtDTO = TestUtilGenerator.getDistrictDTO();
        //Act
        ResponseEntity<Void> received = districtController.newDistrict(districtDTO);
        //Assert
        Mockito.verify(districtService, Mockito.atLeastOnce()).saveDistrict(districtDTO);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

}
