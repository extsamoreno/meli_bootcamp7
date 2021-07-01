package com.example.demo.exceptions;

import com.example.demo.services.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MuelitasException extends Exception {

    private final ErrorDTO error;
    private final HttpStatus status;

    public MuelitasException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}
