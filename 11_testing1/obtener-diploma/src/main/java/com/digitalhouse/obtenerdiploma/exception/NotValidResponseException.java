package com.digitalhouse.obtenerdiploma.exception;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;


public class NotValidResponseException extends Exception {
    private ErrorDTO errorDTO;
    private HttpStatus status;


    public NotValidResponseException(String message, HttpStatus status){
        this.errorDTO = new ErrorDTO();
        List<String> errors = new ArrayList<>();
        errors.add(message);
        this.errorDTO.setErrors(errors);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.status = status;
    }
    public ErrorDTO getErrorDTO() {
        return errorDTO;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
