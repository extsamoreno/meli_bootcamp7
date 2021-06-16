package com.example.challenge_2.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class EnvironmentDTO {
    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "^[A-Z]\\w*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull
    @Positive
    @Max(25)
    private double width;

    @NotNull
    @Positive
    @Max(33)
    private double height;
}
