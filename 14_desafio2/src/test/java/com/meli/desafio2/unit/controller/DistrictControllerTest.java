package com.meli.desafio2.unit.controller;

import com.meli.desafio2.unit.Utils;
import com.meli.desafio2.web.controller.DistrictController;
import com.meli.desafio2.web.dto.request.DistrictDTO;
import com.meli.desafio2.web.exception.DistrictAlreadyExistException;
import com.meli.desafio2.web.repository.IDistrictRepository;
import com.meli.desafio2.web.service.IDistrictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class DistrictControllerTest {
    @Mock
    IDistrictService iDistrictService;
    @InjectMocks
    DistrictController districtController;

    DistrictDTO districtDTO = Utils.initValidDistrictDTO();
    String name = districtDTO.getDistrict_name();
    @Test
    public void saveDistrictHappyPath() throws DistrictAlreadyExistException {
        //arrange
        Mockito.doNothing().when(iDistrictService).save(districtDTO);
        //act
        ResponseEntity<?> response = districtController.saveDistrict(districtDTO);

        //assert
        Mockito.verify(iDistrictService,Mockito.atLeastOnce()).save(districtDTO);
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void getDistrictHappyPath(){
        //arrange
        Mockito.when(iDistrictService.getDistrictByName(name)).thenReturn(districtDTO);

        //act
        ResponseEntity<DistrictDTO> response = districtController.getDistrict(name);

        //assert
        Mockito.verify(iDistrictService,Mockito.atLeastOnce()).getDistrictByName(name);
        Assertions.assertEquals(districtDTO,response.getBody());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
    }
}
