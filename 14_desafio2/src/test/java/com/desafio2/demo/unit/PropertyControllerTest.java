package com.desafio2.demo.unit;

import com.desafio2.demo.controller.PropertyController;
import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.DistrictAlreadyExistException;
import com.desafio2.demo.model.District;
import com.desafio2.demo.service.IPropertyService;
import com.desafio2.demo.service.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @BeforeEach
    @AfterEach
    private void setUp() {
        Util.emptyFiles();
    }


    @Test
    public void createDistrictOk() throws DistrictAlreadyExistException {
        // arrange
        District district = Util.getDistrictPriceTest("Alberdi");
        District expected = Util.getDistrictPriceTest("Alberdi");
        HttpStatus expectedStatus = HttpStatus.CREATED;
        when(iPropertyService.createDistrict(district)).thenReturn(district);

        // act
        ResponseEntity<District> received = propertyController.createDistrict(district);

        // assert
        verify(iPropertyService, atLeastOnce()).createDistrict(district);
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }

}
