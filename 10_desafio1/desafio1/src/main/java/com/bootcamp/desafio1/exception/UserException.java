package com.bootcamp.desafio1.exception;

import com.bootcamp.desafio1.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setName(this.getClass().getSimpleName());
        this.error.setMessage(message);
        this.status = status;
    }
}
