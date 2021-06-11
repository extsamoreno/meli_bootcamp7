package com.digitalhouse.obtenerdiploma.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter @Setter
public class ErrorDTO {
    private String error;
    private HashMap<String, String> messageErrors;

    public ErrorDTO(List<ObjectError> errors, String errorClass){
        this.messageErrors = new HashMap<>();
        errors.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            messageErrors.put(fieldName, errorMessage);
        });
        this.error = errorClass;
    }
}
