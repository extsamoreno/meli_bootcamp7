package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Services.DTOs.ErrorDTO;
import com.example.Challenge2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DistrictExceptionControllerTest {

    @InjectMocks
    DistrictExceptionController districtExceptionController;


    @Test
    public void handleDistrictNotFoundExceptionTest() {

        // arrange,
        Long id = 1L;
        DistrictNotFoundException exception = TestUtilsGenerator.getDistrictNotFoundException(id);
        ErrorDTO expectedError = TestUtilsGenerator.getDistrictNotFoundError(id);
        // act
        ResponseEntity<ErrorDTO> response = districtExceptionController.handleDistrictNotFoundException(exception);

        // assert
        assertEquals(response.getBody(), expectedError);
    }

}
