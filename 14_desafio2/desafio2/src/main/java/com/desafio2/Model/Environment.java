package com.desafio2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Environment {

    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String environment_name;

    @NotBlank(message = "El ancho del ambiente no puede estar vacío.")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private double environment_width;

    @NotBlank(message = "El largo del ambiente no puede estar vacío.")
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.")
    private double environment_length;
}
