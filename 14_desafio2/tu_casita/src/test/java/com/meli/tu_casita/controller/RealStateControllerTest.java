package com.meli.tu_casita.controller;


import com.meli.tu_casita.model.dto.RealStateOutDTO;
import com.meli.tu_casita.service.IRealStateService;
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
public class RealStateControllerTest {

    @Mock
    IRealStateService realStateService;

    @InjectMocks
    RealStateController realStateController;

    @Test
    public void getRealStateListTest() {
        //Arrange
        List<RealStateOutDTO> realStateOutDTOList = TestUtilGenerator.getRealStateOutDTOList();
        ResponseEntity<List<RealStateOutDTO>> expected = new ResponseEntity<>(realStateOutDTOList, HttpStatus.OK);
        Mockito.when(realStateService.getRealStateList()).thenReturn(realStateOutDTOList);
        //Act
        ResponseEntity<List<RealStateOutDTO>> received = realStateController.getRealStateList();
        //Assert
        Mockito.verify(realStateService, Mockito.atLeastOnce()).getRealStateList();
        Assertions.assertEquals(expected.getStatusCode(), received.getStatusCode());
        Assertions.assertEquals(expected.getBody(), received.getBody());
    }

}
