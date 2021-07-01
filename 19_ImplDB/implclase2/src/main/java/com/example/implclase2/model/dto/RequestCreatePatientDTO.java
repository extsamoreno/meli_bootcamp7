package com.example.implclase2.model.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreatePatientDTO {

    @NotEmpty(message = "Empty name not allowed.")
    @Pattern(regexp = "[A-Z\\u00d1][\\ A-Za-zà-ÿ\\u00f1]+", message = "Requires capitalized name")
    private String name;

    @NotEmpty(message = "Empty surname not allowed.")
    @Pattern(regexp = "[A-Z\\u00d1][\\ A-Za-zà-ÿ\\u00f1]+")
    private String surname;

    @NotEmpty(message = "Empty dni not allowed.")
    private String dni;
}
