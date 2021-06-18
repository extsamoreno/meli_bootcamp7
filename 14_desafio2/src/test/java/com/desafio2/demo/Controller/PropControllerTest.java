package com.desafio2.demo.Controller;

import com.desafio2.demo.Exception.DistrictNotExist;
import com.desafio2.demo.Model.DTO.*;
import com.desafio2.demo.Service.IPropService;
import com.desafio2.demo.Util.Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PropControllerTest {

    @Mock
    IPropService propService;

    @InjectMocks
    PropController propController;

    @Test
    void totalMeters()  {
        //arrange
        PropRequest propRequest = Util.getPropRequest();
        PropDTOTMeters propDTOTMeters = new PropDTOTMeters(propRequest.getName(), 30.0);
        when(propService.totalSquareMeters(any())).thenReturn(propDTOTMeters);
        //act
        ResponseEntity<PropDTOTMeters> response = propController.totalMeters(propRequest);
        //assert
        assertEquals(propDTOTMeters, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(propService, atLeastOnce()).totalSquareMeters(any());
    }

    @Test
    void totalPrice() throws DistrictNotExist {
        //arrange
        PropRequest propRequest = Util.getPropRequest();
        PropDTOTPrice propDTO = new PropDTOTPrice(propRequest.getName(), 12600.0);
        when(propService.priceProp(any())).thenReturn(propDTO);
        //act
        ResponseEntity<PropDTOTPrice> response = propController.totalPrice(propRequest);
        //assert
        assertEquals(propDTO, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(propService, atLeastOnce()).priceProp(any());
    }

    @Test
    void totalPriceDistrictNotExistException() throws DistrictNotExist {
        //arrange
        when(propService.priceProp(any())).thenThrow(DistrictNotExist.class);
        //assert
        assertThrows(DistrictNotExist.class, ()-> propController.totalPrice(null));
        verify(propService, atLeastOnce()).priceProp(any());
    }

    @Test
    void bigEnvironment() {
        //arrange
        PropRequest propRequest = Util.getPropRequest();
        List<EnvironmentDTOResponse> envDTO = List.of(new EnvironmentDTOResponse("Habitation", 30.0));
        when(propService.bigEnvironment(any())).thenReturn(envDTO);
        //act
        ResponseEntity<List<EnvironmentDTOResponse>> response = propController.bigEnvironment(propRequest);
        //assert
        assertEquals(envDTO, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(propService, atLeastOnce()).bigEnvironment(any());
    }

    @Test
    void totalMetersByEnvironments() {
        //arrange
        PropRequest propRequest = Util.getPropRequest();
        PropDTOTMeterByEnvironment propDTO = new PropDTOTMeterByEnvironment("Casa1",
                List.of(new EnvironmentDTOResponse("Kitchen", 12.0), new EnvironmentDTOResponse("Habitation", 30.0)));
        when(propService.meterByEnvironment(any())).thenReturn(propDTO);
        //act
        ResponseEntity<PropDTOTMeterByEnvironment> response = propController.totalMetersByEnvironments(propRequest);
        //assert
        assertEquals(propDTO, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(propService, atLeastOnce()).meterByEnvironment(any());
    }
}