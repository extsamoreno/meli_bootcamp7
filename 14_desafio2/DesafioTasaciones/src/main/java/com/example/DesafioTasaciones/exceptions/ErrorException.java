package com.example.DesafioTasaciones.exceptions;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
@Getter
public class ErrorException extends RuntimeException{
    private final Error error;
    private final HttpStatus status;

    public ErrorException(String message, HttpStatus status) {
        this.error = new Error(this.getClass().getSimpleName(),message);
        this.status = status;
    }
}
