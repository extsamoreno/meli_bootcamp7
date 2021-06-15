package com.ejercitacion.ejercitacion.diploma.exception;

import com.ejercitacion.ejercitacion.diploma.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public class DiplomaException extends Exception {

    private ErrorResponse error;
    private HttpStatus status;

    public DiplomaException(String message, HttpStatus status) {
        this.error = new ErrorResponse();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
    }

    public ErrorResponse getError() {
        return error;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
