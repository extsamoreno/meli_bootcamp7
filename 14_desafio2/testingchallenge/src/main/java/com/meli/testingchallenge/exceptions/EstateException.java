package com.meli.testingchallenge.exceptions;

import lombok.Data;

import com.meli.testingchallenge.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

@Data
public class EstateException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public EstateException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }

}
