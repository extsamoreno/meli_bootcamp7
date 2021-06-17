package com.meli.desafio2.dto.environment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {

    @NotEmpty(message = "El nombre del ambiente no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre del ambiente no puede superar los 30 caracteres")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacio")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por ambiente es de 25 mts")
    @DecimalMin(value = "1.0", message = "El minimo ancho permitido por ambiente es de 1 mts")
    private Double width;

    @NotNull(message = "El largo del ambiente no puede estar vacio")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por ambiente es de 33 mts")
    @DecimalMin(value = "1.0", message = "El minimo largo permitido por ambiente es de 1 mts")
    private Double length;
}
