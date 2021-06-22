package com.example.challenge_2.unit.controllers;

import com.example.challenge_2.controller.PropertyControllerException;
import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.service.dto.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerExceptionTest {

    @InjectMocks
    PropertyControllerException propertyControllerException;

    @Test
    public void handlePostExceptionTest() {
        //arrange
        PropertyNotFoundException propertyNotFoundException = new PropertyNotFoundException(1);
        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(propertyNotFoundException.getError(), propertyNotFoundException.getStatus());

        //act
        ResponseEntity<ErrorDTO> result = propertyControllerException.handlePostException(propertyNotFoundException);

        //assert
        assertEquals(responseEntity.getStatusCode(), result.getStatusCode());
    }

    @Test
    public void handlePostExceptionDistrictNotFoundTest() {
        //arrange
        DistrictNotFoundException districtNotFoundException = new DistrictNotFoundException("Centro no");
        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(districtNotFoundException.getError(), districtNotFoundException.getStatus());

        //act
        ResponseEntity<ErrorDTO> result = propertyControllerException.handlePostExceptionDistrictNotFound(districtNotFoundException);

        //assert
        assertEquals(responseEntity.getStatusCode(), result.getStatusCode());
    }

}
