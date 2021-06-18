package com.meli.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvironmentSquareDTO {
    @NotEmpty(message = "El nombre del hambiente no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del hambiente debe comenzar con mayúscula.")
    @Size(max = 30,message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String environment_name;
    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Max(value = 25,message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private double environment_width;
    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @Max(value = 25,message = "El máximo largo permitido por propiedad es de 25 mts.")
    private double environment_length;
    @NotNull(message = "Los metros cuadrados del ambiente no pueden estar vacíos.")
    private double square_meters;
}