package com.meli.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {
    @NotNull(message = "El ambiente debe tener un id.")
    private Integer environmentId;

    @NotNull(message = "El nombre del ambiente no puede estar vacío.")
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @DecimalMin(value = "0.0", message = "El minimo ancho permitido por propiedad es de 0 mts.")
    private Double width;

    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
    @DecimalMin(value = "0.0", message = "El minimo largo permitido por propiedad es de 0 mts.")
    private Double leng;



}
