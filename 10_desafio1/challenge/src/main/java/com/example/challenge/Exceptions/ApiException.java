package com.example.challenge.Exceptions;


import com.example.challenge.Services.DTOs.ErrorDTO;
import lombok.*;
import org.springframework.http.HttpStatus;

@Data
public class ApiException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public ApiException(String message, HttpStatus status){

        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}