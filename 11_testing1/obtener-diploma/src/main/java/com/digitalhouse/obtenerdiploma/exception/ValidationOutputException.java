package com.digitalhouse.obtenerdiploma.exception;

import com.digitalhouse.obtenerdiploma.dto.ErrorValidationsDTO;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ValidationOutputException extends ObjectValidationException{
    public ValidationOutputException(Map<String, String> errors) {
        super(errors, HttpStatus.CONFLICT);
    }
}
