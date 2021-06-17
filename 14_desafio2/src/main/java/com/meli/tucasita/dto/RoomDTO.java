package com.meli.tucasita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class RoomDTO {

    @NotBlank(message = "El nombre del ambiente no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío")
    @Positive(message = "El ancho debe ser un número positivo")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts")
    private double width;

    @NotNull(message = "El largo del ambiente no puede estar vacío")
    @Positive(message = "El largo debe ser un número positivo")
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts")
    private double length;

}
