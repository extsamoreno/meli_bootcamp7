package com.meli.testingchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    @NotNull(message = "El barrio no puede estar vacío.")
    @Size(min = 1, message = "El nombre del barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String name;
    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @DecimalMax(value="4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @DecimalMin(value="1.0", message = "El precio mínimo permitido por metro cuadrado no puede ser inferior a 1 U$S.")
    private Double price;
}
