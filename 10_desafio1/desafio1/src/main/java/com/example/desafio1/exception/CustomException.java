package com.example.desafio1.exception;

import com.example.desafio1.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public CustomException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }

}
