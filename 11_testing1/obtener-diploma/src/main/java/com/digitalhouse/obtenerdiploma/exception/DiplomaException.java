package com.digitalhouse.obtenerdiploma.exception;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public  class DiplomaException extends Exception{
    private final ErrorDTO error;
    private final HttpStatus status;

    public DiplomaException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
