package com.digitalhouse.obtenerdiploma.dto;


import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class ErrorDTO {
    private String name;
    private List<String> errors;

    public ErrorDTO(String name, List<String> errors) {
        this.name = name;
        this.errors = errors;
    }

    public ErrorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
