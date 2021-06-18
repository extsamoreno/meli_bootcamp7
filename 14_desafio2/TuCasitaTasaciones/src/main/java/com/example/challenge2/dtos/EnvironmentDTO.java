package com.example.challenge2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvironmentDTO {

    @NotEmpty(message = "El nombre del ambiente no puede estar vacío .")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con una mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMax(value = "25", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @DecimalMin(value = "0", message = "No puede ser negativo.")
    private Double width;

    @NotNull(message = "El largo del ambiente no puede estar vacío..")
    @DecimalMax(value = "33", message = "El largo máximo permitido por propiedad es de 33 mts ")
    @DecimalMin(value = "0", message = "El largo de la propiedad no puede ser negativo")
    private Double length;

    public EnvironmentDTO(String environment2, double v) {
    }
}

