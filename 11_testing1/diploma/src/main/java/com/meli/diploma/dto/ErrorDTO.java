package com.meli.diploma.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String error;
    private HashMap<String, String> messageErrors;

    public ErrorDTO(List<ObjectError> errors, String errorClass) {
        this.messageErrors = new HashMap<>();
        errors.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            messageErrors.put(fieldName, errorMessage);
        });
        this.error = errorClass;
    }
}
