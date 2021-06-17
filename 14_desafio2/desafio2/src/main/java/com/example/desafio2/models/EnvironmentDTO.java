package com.example.desafio2.models;

import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {

    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp="([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)(([A-Z]|Á|Ó|É|Í|Ú)?(([a-z]|[á-ú]|é|ñ)*(\\s)?)+)*[0-9]?",
            message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre del ambiente no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Positive(message = "El ancho debe ser mayor a 0.00.")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25.0 mts.")
    private Double width;

    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @Positive(message = "El largo debe ser mayor a 0.00.")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33.0 mts.")
    private Double length;
}
