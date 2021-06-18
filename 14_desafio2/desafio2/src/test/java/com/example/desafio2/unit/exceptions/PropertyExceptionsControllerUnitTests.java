package com.example.desafio2.unit.exceptions;

import com.example.desafio2.project.controllers.PropertyExceptionController;
import com.example.desafio2.project.exceptions.PropertyNameNotFoundException;
import com.example.desafio2.project.services.Dto.ErrorDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyExceptionsControllerUnitTests {

   /* @Mock
    PropertyExceptionController propertyExceptionController;

    @Test
    public void PropertyNameNotFoundExceptionHandler() throws PropertyNameNotFoundException {
        //Arrange
        String propertyName = "Casa1";
        PropertyNameNotFoundException propertyNameNotFoundException = new PropertyNameNotFoundException(propertyName);
        ErrorDto errorDto = new ErrorDto("message","name");
        ResponseEntity<ErrorDto> errorDtoResponseEntity = new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);

        when(this.propertyExceptionController.handleGlobalException(propertyNameNotFoundException)).thenReturn(errorDtoResponseEntity);
        //Act
        throw new PropertyNameNotFoundException(propertyName);

        //Asserts
        verify(this.propertyExceptionController,atLeastOnce()).handleGlobalException(propertyNameNotFoundException);

    }*/

}
