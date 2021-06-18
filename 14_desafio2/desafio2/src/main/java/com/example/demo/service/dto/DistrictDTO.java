package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@Valid
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    @NotEmpty(message = "El barrio no puede estar vacío")
    @Size(min = 1, max = 45, message = "La longitud del barrio no puede superar los 45 caracteres")
    private String distric_name;
    @NotNull(message = "El barrio no puede estar vacío")
    @Max(value = 4000,message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @Min(value = 1,message = "El precio no puede ser 0, o menor que 0")
    private double distric_price;
}
