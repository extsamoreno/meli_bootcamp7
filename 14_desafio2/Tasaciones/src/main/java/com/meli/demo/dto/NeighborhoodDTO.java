package com.meli.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeighborhoodDTO {

    @NotNull(message = "El barrio no puede estar vacío.")
    @NotEmpty(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El precio de un barrio no puede estar vacio")
    @DecimalMax(value = "4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @DecimalMin(value = "0.0", message = "El precio minimo permitido por metro cuadrado no puede ser menor que 0 U$S.")
    private Double price;
}
