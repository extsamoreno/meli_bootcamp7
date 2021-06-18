package com.desafio2.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    private int id;
    @NotBlank(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String name;

    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @DecimalMax(value="4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @Positive(message = "El precio de un barrio no puede ser negativo ni cero.")
    private Double price;
}
