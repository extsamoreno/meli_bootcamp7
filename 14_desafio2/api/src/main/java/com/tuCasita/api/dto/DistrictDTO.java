package com.tuCasita.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    @NotEmpty(message = "El barrio no puede estar vacio.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String name;

    @NotNull(message = "El precio de un barrio no puede estar vacio")
    @DecimalMin(value = "1", message = "El precio minimo del metro cuadrado es 1 U$S")
    @DecimalMax(value = "4000", message = "El precio maximo permitido por metro cuadrado no puede superar los 4000 U$S")
    private Double price;
}
