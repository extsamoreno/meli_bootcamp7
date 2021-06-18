package com.didney.junit.tucasitatasaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {
    @NotNull(message = "El nombre del ambiente no puede ser nulo.")
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String environmentName;
    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMin(value = "0", message = "El ancho del ambiente no puede ser cero o inferior.")
    @DecimalMax(value = "25", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private double environmentWidth;
    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @DecimalMin(value = "0", message = "El largo del ambiente no puede ser cero o inferior.")
    @DecimalMax(value = "33", message = "El máximo largo permitido por propiedad es de 33 mts.")
    private double environmentLength;
}
