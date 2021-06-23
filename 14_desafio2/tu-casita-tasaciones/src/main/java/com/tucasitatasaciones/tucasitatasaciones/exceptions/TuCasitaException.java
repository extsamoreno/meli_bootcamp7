package com.tucasitatasaciones.tucasitatasaciones.exceptions;

import com.tucasitatasaciones.tucasitatasaciones.services.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TuCasitaException extends Exception {
    private final ErrorDTO error;
    private final HttpStatus status;

    public TuCasitaException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}