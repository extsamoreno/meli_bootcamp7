package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Services.DTOs.ErrorDTO;
import com.example.Challenge2.Services.DTOs.RoomDTO;
import com.example.Challenge2.Services.DTOs.StructureDTO;
import com.example.Challenge2.Services.DTOs.ValueDTO;
import com.example.Challenge2.Services.IPropertyService;
import com.example.Challenge2.Services.Mapper.RoomMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyExceptionControllerTest {

    @InjectMocks
    PropertyExceptionController propertyExceptionController;


    @Test
    public void handlePropertyNotFoundExceptiontest() {

        // arrange,
        Long id = 1L;
        PropertyNotFoundException exception = TestUtilsGenerator.getPropertyNotFoundException(id);
        ErrorDTO expectedError = TestUtilsGenerator.getPropertyNotFoundError(id);
        // act
        ResponseEntity<ErrorDTO> response = propertyExceptionController.handlePropertyNotFoundException(exception);

        // assert
        assertEquals(response.getBody(), expectedError);
    }


}
