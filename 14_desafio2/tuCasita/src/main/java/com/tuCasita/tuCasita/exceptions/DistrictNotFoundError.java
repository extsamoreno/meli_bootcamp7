package com.tuCasita.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundError extends RuntimeException{

    private ErrorDTO error;
    private HttpStatus status;

    public DistrictNotFoundError(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}
