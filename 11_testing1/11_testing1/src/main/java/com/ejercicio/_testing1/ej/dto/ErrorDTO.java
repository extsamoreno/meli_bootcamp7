package com.ejercicio._spring2.ej3.dto;

import lombok.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
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