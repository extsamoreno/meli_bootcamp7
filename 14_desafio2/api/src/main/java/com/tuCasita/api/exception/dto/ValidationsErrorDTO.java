package com.tuCasita.api.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationsErrorDTO {
    private String error;
    private HashMap<String, String> messageErrors;

    public ValidationsErrorDTO(List<ObjectError> errors, String errorClass){
        this.messageErrors = new HashMap<>();
        errors.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            messageErrors.put(fieldName, errorMessage);
        });
        this.error = errorClass;
    }
}
