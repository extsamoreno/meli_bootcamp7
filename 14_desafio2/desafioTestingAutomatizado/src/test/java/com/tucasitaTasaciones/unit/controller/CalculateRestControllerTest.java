package com.tucasitaTasaciones.unit.controller;

import com.tucasitaTasaciones.controller.CalculateRestController;
import com.tucasitaTasaciones.dto.ResponseDTO.CalculateResponseDTO;
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
    public void calculateSquareMetersTest() {
        Integer propertyId = 1;
        CalculateResponseDTO expected = new CalculateResponseDTO();
        expected.setTotalSquareMeters(90);
        Mockito.when(service.calculateSquareMeters(propertyId)).thenReturn(expected);

        ResponseEntity<CalculateResponseDTO> found = controller.calculateSquareMeters(propertyId);

        Mockito.verify(service, Mockito.atLeastOnce()).calculateSquareMeters(propertyId);
        Assertions.assertEquals(expected.getTotalSquareMeters(), found.getBody().getTotalSquareMeters());
        Assertions.assertEquals(200, found.getStatusCodeValue());

    }

    @Test
    public void calculateValueTest() {

        Integer propertyId = 1;
        CalculateResponseDTO expected = new CalculateResponseDTO();
        expected.setPropertyPrice(500.00);
        Mockito.when(service.calculateValue(propertyId)).thenReturn(expected);

        ResponseEntity<CalculateResponseDTO> found = controller.calculatePropertyValue(propertyId);

        Mockito.verify(service, Mockito.atLeastOnce()).calculateValue(propertyId);
        Assertions.assertEquals(expected.getPropertyPrice(), found.getBody().getPropertyPrice());
        Assertions.assertEquals(200, found.getStatusCodeValue());

    }

    @Test
    public void calculateLargestRoomTest() {

        Integer propertyId = 1;
        CalculateResponseDTO expected = new CalculateResponseDTO();
        expected.setLargestRoom("Living");
        Mockito.when(service.calculateLargestRoom(propertyId)).thenReturn(expected);

        ResponseEntity<CalculateResponseDTO> found = controller.calculatePropertyLargestRoom(propertyId);

        Mockito.verify(service, Mockito.atLeastOnce()).calculateLargestRoom(propertyId);
        Assertions.assertEquals(expected.getLargestRoom(), found.getBody().getLargestRoom());
        Assertions.assertEquals(200, found.getStatusCodeValue());

    }

    @Test
    public void calculateEnvironmentsSquareMetersTest() {

        Integer propertyId = 1;
        CalculateResponseDTO expected = new CalculateResponseDTO();
        Map<String, Integer> environmentDTOList = new HashMap<>();

        environmentDTOList.put("Living", 80);
        environmentDTOList.put("Kitchen", 60);
        expected.setEnvironmentsSquareMeters(environmentDTOList);
        Mockito.when(service.calculateEnvironmentsSquareMeters(propertyId)).thenReturn(expected);

        ResponseEntity<CalculateResponseDTO> received = controller.calculateEnvironmentsSquareMeters(propertyId);

        Mockito.verify(service, Mockito.atLeastOnce()).calculateEnvironmentsSquareMeters(propertyId);
        Assertions.assertEquals(200, received.getStatusCodeValue());
        Assertions.assertEquals(expected.getEnvironmentsSquareMeters(), received.getBody().getEnvironmentsSquareMeters());

    }


}
