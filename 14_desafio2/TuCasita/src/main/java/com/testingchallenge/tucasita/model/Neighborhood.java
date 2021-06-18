package com.testingchallenge.tucasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Neighborhood {
    @NotEmpty(message = "El barrio no puede estar vacío")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres")
    private String name;

    @NotEmpty(message = "El precio de un barrio no puede estar vacío")
    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no puede superar los US$4.000")
    @Positive(message = "El valor del metro cuadrado debe ser mayor a cero")
    private Double price;
}
