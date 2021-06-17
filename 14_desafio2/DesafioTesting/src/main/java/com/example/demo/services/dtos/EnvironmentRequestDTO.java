package com.example.demo.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentRequestDTO {

    @NotNull(message = "El nombre del ambiente no puede estar vacio.")
    @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*", message = "El nombre del ambiente debe empezar con mayuscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String environment_name;

    @NotNull(message = "El ancho del ambiente no puede estar vacio.")
    @Positive(message = "El ancho del ambiente debe ser mayor a 0")
    @Max(value = 25, message = "El máximo ancho permitido por ambiente es de 25 mts.")
    private double environment_width;

    @NotNull(message = "El largo del ambiente no puede estar vacio.")
    @Positive(message = "El largo del ambiente debe ser mayor a 0")
    @Max(value = 25, message = "El máximo largo permitido por ambiente es de 33 mts.")
    private double environment_length;
}
