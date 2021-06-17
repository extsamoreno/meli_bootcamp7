package com.example.desafio2.models;

import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NeighborhoodDTO {
    private int id;

    @NotBlank(message = "El barrio no puede estar vacío.")
    @Pattern(regexp="([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)(([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)+)*[0-9]?",
            message = "El nombre del barrio debe comenzar con mayúscula.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String name;

    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @Positive(message = "El precio debe ser mayor a 0.00.")
    @DecimalMax(value = "4000.0",
            message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    private Double price;
}
