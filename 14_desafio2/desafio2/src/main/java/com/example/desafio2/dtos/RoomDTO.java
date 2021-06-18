package com.example.desafio2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    @NotBlank(message = "El nombre del ambiente no puede estar vacio.")
    @Pattern(regexp = "([A-Z].*)", message = "El nombre del ambiente debe comenzar con mayuscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacio.")
    @PositiveOrZero
    @DecimalMax(value = "25.0", message = "El maximo ancho permitido por propiedad es de 25 mts.")
    private Double width;

    @NotNull(message = "El largo del ambiente no puede estar vacio.")
    @PositiveOrZero
    @DecimalMax(value = "33.0", message = "El maximo largo permitido por propiedad es de 33 mts.")
    private Double length;
}
