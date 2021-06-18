package com.testingchallenge.tucasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name; // "cocina", "comedor"...

    @NotEmpty(message = "El ancho del ambiente no puede estar vacío")
    @Max(value = 25, message = "El ancho máximo permitido por propiedad es de 25 mts.")
    @Positive(message = "El ancho del ambiente debe ser mayor a cero")
    private Double width;

    @NotEmpty(message = "El largo del ambiente no puede estar vacío")
    @Max(value = 33, message = "El largo máximo permitido por propiedad es de 33 mts.")
    @Positive(message = "El largo del ambiente debe ser mayor a cero")
    private Double length;
}
