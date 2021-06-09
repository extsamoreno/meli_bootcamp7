package com.desafio1.meli.exceptions;

import com.desafio1.meli.service.DTO.*;
import org.springframework.http.HttpStatus;

public class UserException extends Exception{
    private ErrorDTO error;
    private HttpStatus httpStatus;

    public UserException(String message, HttpStatus httpStatus) {
        this.error = new ErrorDTO();
        this.error.setMensaje(message);
        this.error.setNombre(this.getClass().getSimpleName());
        this.httpStatus = httpStatus;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
