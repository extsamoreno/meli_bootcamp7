package com.meli.tucasitatasaciones.unit.controller;

import com.meli.tucasitatasaciones.controller.AppraisalController;
import com.meli.tucasitatasaciones.dto.EnvironmentDTO;
import com.meli.tucasitatasaciones.dto.ResponseDTO;
import com.meli.tucasitatasaciones.service.appraisal.IAppraisalService;
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

@ExtendWith(MockitoExtension.class)
public class AppraisalControllerTest {

    @Mock
    IAppraisalService iAppraisalService;

    @InjectMocks
    AppraisalController appraisalController;

    @Test
    public void getTotalSquareMeters() {
        //Arrange
        Integer propertyId = 1;
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setTotalSquareMeters(40.0);
        Mockito.when(iAppraisalService.getPropertyTotalSquareMeters(propertyId)).thenReturn(responseDTO);

        //Act
        ResponseEntity<ResponseDTO> received = appraisalController.getTotalSquareMeters(propertyId);

        //Asset
        Mockito.verify(iAppraisalService,Mockito.atLeastOnce()).getPropertyTotalSquareMeters(propertyId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(responseDTO.getTotalSquareMeters(),received.getBody().getTotalSquareMeters());
    }

    @Test
    public void getPropertyValue() {
        //Arrange
        Integer propertyId = 1;
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setPropertyValue(1000.0);
        Mockito.when(iAppraisalService.getPropertyValue(propertyId)).thenReturn(responseDTO);

        //Act
        ResponseEntity<ResponseDTO> received = appraisalController.getPropertyValue(propertyId);

        //Asset
        Mockito.verify(iAppraisalService,Mockito.atLeastOnce()).getPropertyValue(propertyId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(responseDTO.getPropertyValue(),received.getBody().getPropertyValue());
    }

    @Test
    public void getBiggestEnvironment() {
        //Arrange
        Integer propertyId = 1;
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setBiggestEnvironment(new EnvironmentDTO());
        Mockito.when(iAppraisalService.getBiggestEnvironment(propertyId)).thenReturn(responseDTO);

        //Act
        ResponseEntity<ResponseDTO> received = appraisalController.getBiggestEnvironment(propertyId);

        //Asset
        Mockito.verify(iAppraisalService,Mockito.atLeastOnce()).getBiggestEnvironment(propertyId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(responseDTO.getBiggestEnvironment(),received.getBody().getBiggestEnvironment());
    }

    @Test
    public void getEnvironmentsSquareMeters() {
        //Arrange
        Integer propertyId = 1;
        ResponseDTO responseDTO = new ResponseDTO();
        List<EnvironmentDTO> environments = new ArrayList<>();
        environments.add(new EnvironmentDTO());
        environments.add(new EnvironmentDTO());
        responseDTO.setEnvironmentsSquareMeters(environments);
        Mockito.when(iAppraisalService.getEnvironmentsSquareMeters(propertyId)).thenReturn(responseDTO);

        //Act
        ResponseEntity<ResponseDTO> received = appraisalController.getEnvironmentsSquareMeters(propertyId);

        //Asset
        Mockito.verify(iAppraisalService,Mockito.atLeastOnce()).getEnvironmentsSquareMeters(propertyId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(responseDTO.getEnvironmentsSquareMeters(),received.getBody().getEnvironmentsSquareMeters());
    }
}
