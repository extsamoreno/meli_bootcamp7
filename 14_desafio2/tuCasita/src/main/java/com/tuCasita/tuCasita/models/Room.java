package com.tuCasita.tuCasita.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @NotNull(message = "El nombre del ambiente no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacio")
    @Max(value = 25 - 0, message = "El ancho maximo permitido por propiedad es de 25mts")
    private double width;

    @NotNull(message = "El largo del ambiente no puede estar vacio")
    @Max(value = 25 - 0, message = "El largo maximo permitido por propiedad es de 33mts")
    private double length;
}
