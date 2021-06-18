package com.example.challenge2.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {

    @NotBlank(message = "The name can not be empty")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The environment name should start with capital letter")
    @Size(max = 30, message = "Can not be longer than 30 characters ")
    private String name;

    @DecimalMax(value="25.0", message = "Width can not be longer than 25")
    @Positive(message = "The width should be positive.")
    private Double width;

    @DecimalMax(value="33.0", message = "Length can not be longer than 33")
    @Positive(message = "The length should be positive.")
    private Double length;
}
