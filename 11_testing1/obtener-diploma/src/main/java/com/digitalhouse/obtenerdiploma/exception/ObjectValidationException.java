package com.digitalhouse.obtenerdiploma.exception;

import com.digitalhouse.obtenerdiploma.dto.ErrorValidationsDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class ObjectValidationException extends Exception{
    private ErrorValidationsDTO error;
    private HttpStatus status;

    public ObjectValidationException(Map<String, String> fields, HttpStatus status){
        this.error = new ErrorValidationsDTO();
        this.error.setMessage("Error validatiosn outputs fields");
        this.error.setType(this.getClass().getSimpleName());
        this.error.setFields(fields);
        this.status = status;
    }

}
