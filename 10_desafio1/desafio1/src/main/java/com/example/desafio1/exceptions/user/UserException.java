package com.example.desafio1.exceptions.user;

import com.example.desafio1.dtos.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UserException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setName(this.getClass().getSimpleName());
        this.error.setMessage(message);
        this.status = status;
    }
}
