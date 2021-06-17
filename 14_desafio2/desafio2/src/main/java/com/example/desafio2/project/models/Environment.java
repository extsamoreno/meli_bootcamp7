package com.example.desafio2.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    @NotBlank(message = "The environment name cannot be empty\"")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z]*$", message = "The environment name must start with a capital letter")
    @Size(max = 30, message = "The environment name max length is 30 characters")
    private String environment_name;

    @Positive
    @Max(value = 25, message = "The environment width must be 25 meters or less")
    private double environment_width;

    @Positive
    @Max(value = 33, message = "The environment lenght must be 33 meters or less")
    private double environment_length;
}
