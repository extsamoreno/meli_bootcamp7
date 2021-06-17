package com.example.tucasita.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TuCasitaException extends RuntimeException {

    private ErrorDTO error;
    private HttpStatus status;

    public TuCasitaException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
