package com.meli.desafio2.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {
    @NotBlank(message = "The environment name cannot be empty.")
    @Pattern(regexp="^([A-Z].*)$|^$", message = "The environment name must begin with a capital letter.")
    @Size(max = 30, message = "The length of the environment name cannot exceed 30 characters")
    private String nameEnvironment;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private Integer width;

    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.")
    private Integer length;
}
