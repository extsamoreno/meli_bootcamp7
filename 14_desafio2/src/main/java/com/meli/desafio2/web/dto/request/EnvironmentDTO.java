package com.meli.desafio2.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {
    @Valid
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío." )
    @NotNull(message = "El nombre del ambiente no puede ser nulo")
    @Pattern(regexp = "^[A-Z].*$", message ="El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String environment_name;
    @Valid
    @NotNull(message = "El ancho del ambiente no puede ser nulo")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts")
    private double environment_width;
    @NotNull(message = "El largo del ambiente no puede ser nulo")
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts")
    private double environment_length;
}
