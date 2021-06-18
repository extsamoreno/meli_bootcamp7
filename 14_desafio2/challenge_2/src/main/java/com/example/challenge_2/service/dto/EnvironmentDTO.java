package com.example.challenge_2.service.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnvironmentDTO {
    @NotBlank(message = "El nombre del  no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El ancho no puede estar vacío")
    @Positive(message = "El ancho debe ser mayor a 0")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private double width;

    @NotNull(message = "El largo no puede estar vacío")
    @Positive(message = "El largo debe ser mayor a 0")
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.")
    private double length;
}
