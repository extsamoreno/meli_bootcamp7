package com.bootcamp.tucasitatasaciones.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ErrorValidationDTO {
    private String name;
    private Map<String, String> description;

    public ErrorValidationDTO(String name, List<ObjectError> errors) {
        this.name = name;
        description = new HashMap<>();

        errors.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            description.put(fieldName, errorMessage);
        });
    }
}