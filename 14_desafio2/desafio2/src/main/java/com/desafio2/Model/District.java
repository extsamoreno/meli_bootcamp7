package com.desafio2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    @NotBlank(message = "El nombre del barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del nombre del barrio no puede superar los 45 caracteres")
    private String district_name;

    @NotBlank(message = "El precio de un barrio no puede estar vacío.")
    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    private double district_price;
}
