package com.meli.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    @Size(message = "The length of the name cannot exceed 30 characters", max = 30)
    //@Pattern(regexp = "/[A-Z]/", message = "The environment name must begin with a capital letter")
    @NotEmpty(message = "Environment name cannot be empty")
    private String environment_name;

    @Max(message = "The maximum width allowed by the property is 25 meters", value = 25)
    @NotNull(message = "Environment width cannot be empty")
    private double environment_width;

    @Max(message = "The maximum length allowed by the property is 25 meters", value = 33)
    @NotNull(message = "Environment length cannot be empty")
    private double environment_length;
}
