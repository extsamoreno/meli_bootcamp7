package com.example.tucasita.unit.controller;

import com.example.tucasita.controller.DistrictController;
import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.service.DistrictService;
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
public class DistrictControllerTests {

    @Mock
    DistrictService districtService;

    @InjectMocks
    DistrictController districtController;

    @Test
    public void testAddOneDistrict() {
        //ARRANGE
        DistrictDTO district = new DistrictDTO("Almagro", 300.00);

        //ACT
        ResponseEntity<?> receivedResponse = districtController.addOneDistrict(district);

        //ASSERT
        Mockito.verify(districtService,Mockito.atLeastOnce()).addOneDistrict(district);
        Assertions.assertEquals(HttpStatus.CREATED,receivedResponse.getStatusCode());
    }

}
