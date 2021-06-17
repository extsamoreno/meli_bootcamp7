package com.desafio2.testing.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarrioModel {

    @NotBlank(message = "El nombre del barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barriono puede superar los 45 caracteres.")
    private String district_name;

    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S")
    private double district_price;

}
