package com.example.Challenge2.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class DistrictDTO {

    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    @NotEmpty(message = "El barrio no puede estar vacío.")
    private String name;

    @NotNull(message = "El barrio no puede estar vacío.")
    @DecimalMax(value = "4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.", inclusive = true)
    private double pricePerM2;
}
