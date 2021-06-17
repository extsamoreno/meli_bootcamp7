package com.example.challenge2.exceptions;

import com.example.challenge2.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException  extends RuntimeException{

    private final ErrorDTO error;
    private final HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
