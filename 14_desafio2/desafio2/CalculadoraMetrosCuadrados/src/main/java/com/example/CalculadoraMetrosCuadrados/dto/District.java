package com.example.CalculadoraMetrosCuadrados.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @NotBlank(message = "El barrio no puede estar vacio.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String districtName;

    @NotNull(message = "El precio de un barrio no puede estar vacio.")
    @Max(value = 1, message = "El precio maximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    private Double districtPrice;
}
