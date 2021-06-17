package com.tuCasita.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {
    @NotEmpty(message = "El nombre del ambiente no puede estar vacio.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "[A-Z].*", message = "El nombre del ambiente debe comenzar con mayuscula.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacio")
    @DecimalMin(value = "1", message = "El ancho minimo permitido de un ambiente es 1")
    @DecimalMax(value = "4000", message = "El ancho maximo es 25")
    private Double width;

    @NotNull(message = "El largo del ambiente no puede estar vacio")
    @DecimalMin(value = "1", message = "El largo minimo permitido de un ambiente es 1")
    @DecimalMax(value = "4000", message = "El largo maximo es 25")
    private Double length;
}
