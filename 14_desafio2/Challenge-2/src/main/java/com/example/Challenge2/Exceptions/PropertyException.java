package com.example.Challenge2.Exceptions;

import com.example.Challenge2.Services.DTOs.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public PropertyException(String message, HttpStatus status){

        this.error = new ErrorDTO(message,this.getClass().getSimpleName());

        this.status = status;
    }
}
