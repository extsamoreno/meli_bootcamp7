package com.example.desafio2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    @NotBlank(message="El barrio no puede estar vacio")
    @Size(max=45, message="La longitud del barrio no puede superar los 45 caracteres.")
    private String name;
    @NotEmpty
    @DecimalMax(value="4000.0",message="El precio maximo permitido por metro cuadrado no puede superar los 4000U$S.")
    private double price;
}
