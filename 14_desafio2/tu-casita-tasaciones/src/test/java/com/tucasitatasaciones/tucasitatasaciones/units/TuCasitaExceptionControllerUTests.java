package com.tucasitatasaciones.tucasitatasaciones.units;

import com.tucasitatasaciones.tucasitatasaciones.controllers.TuCasitaExceptionController;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.DistrictNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.TuCasitaException;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.ErrorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.invoke.MethodType;

@ExtendWith(MockitoExtension.class)
public class TuCasitaExceptionControllerUTests {

    private TuCasitaExceptionController exceptionController;

    public TuCasitaExceptionControllerUTests() {
        this.exceptionController = new TuCasitaExceptionController();
    }

    @Test
    public void handleGlobalExceptions() {
        var errorDummy = new TuCasitaException("Error dummy in handleGlobalExceptions", HttpStatus.BAD_REQUEST);

        ResponseEntity<ErrorDTO> received = exceptionController.handleGlobalExceptions(errorDummy);

        Assertions.assertEquals(received.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void handleDistrictNotFoundException() {
        var errorDummy = new DistrictNotFoundException(1);
        ResponseEntity<ErrorDTO> received = exceptionController.handleDistrictNotFoundException(errorDummy);

        Assertions.assertEquals(received.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void handleOwnershipNotFoundException() {
        var errorDummy = new OwnershipNotFoundException(1);
        ResponseEntity<ErrorDTO> received = exceptionController.handleOwnershipNotFoundException(errorDummy);

        Assertions.assertEquals(received.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    public void handleMethodArgumentNotValidException() {
        ResponseEntity<ErrorDTO> received = exceptionController.handleMethodArgumentNotValidException(null);

        Assertions.assertEquals(received.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    public void handleHttpMessageNotReadableException() {
        ResponseEntity<ErrorDTO> received = exceptionController.handleHttpMessageNotReadableException(null);

        Assertions.assertEquals(received.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

}
