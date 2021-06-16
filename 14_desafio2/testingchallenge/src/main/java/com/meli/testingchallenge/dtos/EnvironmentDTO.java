package com.meli.testingchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class EnvironmentDTO {

    @NotNull(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*",  message ="El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String environment_name;
    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Max(value=25, message = "El máximo ancho permitido por ambiente es de 25 mts.")
    @Min(value=0, message = "El mínimo ancho permitido por ambiente es de 0 mts.")
    private double environment_width;
    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Max(value=33, message = "El máximo largo permitido por ambiente es de 33 mts.")
    @Min(value=0, message = "El mínimo largo permitido por ambiente es de 0 mts.")
    private double environment_length;

}
