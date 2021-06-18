package com.tucasitaTasaciones.unit.controller;

import com.tucasitaTasaciones.controller.CalculateRestController;
import com.tucasitaTasaciones.dto.CalculateResponseDTO;
import com.tucasitaTasaciones.dto.EnvironmentDTO;
import com.tucasitaTasaciones.service.ICalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    ICalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    public void calculateSquareMeters() {
        Integer propertyId = 1;
        CalculateResponseDTO expected = new CalculateResponseDTO();
        expected.setTotalSquareFeet(90);
        Mockito.when(service.calculateSquareMeters(propertyId)).thenReturn(expected);

        ResponseEntity<CalculateResponseDTO> found = controller.calculateSquareMeters(propertyId);

        Mockito.verify(service,Mockito.atLeastOnce()).calculateSquareMeters(propertyId);
        Assertions.assertEquals(expected, found.getBody());
        Assertions.assertEquals(200, found.getStatusCodeValue());

    }

    @Test
    public void calculateValue() {

        Integer propertyId = 1;
        CalculateResponseDTO expected = new CalculateResponseDTO();
        expected.setPropertyPrice(500.00);
        Mockito.when(service.calculateValue(propertyId)).thenReturn(expected);

        ResponseEntity<CalculateResponseDTO> found = controller.calculateValue(propertyId);

        Mockito.verify(service,Mockito.atLeastOnce()).calculateValue(propertyId);
        Assertions.assertEquals(expected, found.getBody());
        Assertions.assertEquals(200, found.getStatusCodeValue());

    }

    @Test
    public void calculateLargestRoom() {

        Integer propertyId = 1;
        CalculateResponseDTO expected = new CalculateResponseDTO();
        expected.setLargestRoom("Living");
        Mockito.when(service.calculateLargestRoom(propertyId)).thenReturn(expected);

        ResponseEntity<CalculateResponseDTO> found = controller.calculateLargestRoom(propertyId);

        Mockito.verify(service,Mockito.atLeastOnce()).calculateLargestRoom(propertyId);
        Assertions.assertEquals(expected, found.getBody());
        Assertions.assertEquals(200, found.getStatusCodeValue());

    }

    @Test
    public void calculateRoomsSquareMeters() {

        Integer propertyId = 1;
        CalculateResponseDTO expected = new CalculateResponseDTO();
        Map<String, Integer> environmentDTOList = new HashMap<>();

        environmentDTOList.put("Living", 80);
        environmentDTOList.put("Kitchen", 60);
        expected.setEnvironmentsSquareFeet(environmentDTOList);
        Mockito.when(service.calculateEnvironments(propertyId)).thenReturn(expected);

        ResponseEntity<CalculateResponseDTO> received = controller.calculateRoomsSquareMeters(propertyId);

        Mockito.verify(service,Mockito.atLeastOnce()).calculateEnvironments(propertyId);
        Assertions.assertEquals(200,received.getStatusCodeValue());
        Assertions.assertEquals(expected.getEnvironmentsSquareFeet(),received.getBody().getEnvironmentsSquareFeet());

    }


}
