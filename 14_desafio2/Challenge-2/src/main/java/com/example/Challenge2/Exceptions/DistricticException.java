package com.example.Challenge2.Exceptions;

import com.example.Challenge2.Services.DTOs.ErrorDTO;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DistricticException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public DistricticException(String message, HttpStatus status){

        this.error = new ErrorDTO(message,this.getClass().getSimpleName());
        this.status = status;
    }
}
