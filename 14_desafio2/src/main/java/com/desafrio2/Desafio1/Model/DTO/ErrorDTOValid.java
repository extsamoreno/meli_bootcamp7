package com.desafrio2.Desafio1.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorDTOValid{
    @JsonProperty("Errors")
    List<String> errors = new ArrayList<>();

    public ErrorDTOValid(List<ObjectError> allErrors) {
       loadErrors(allErrors);
    }

    private void loadErrors(List<ObjectError> allErrors) {
        allErrors.forEach(e -> errors.add(e.getDefaultMessage()));
    }
}
