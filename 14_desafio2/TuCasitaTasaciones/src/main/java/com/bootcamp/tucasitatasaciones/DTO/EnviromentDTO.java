package com.bootcamp.tucasitatasaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnviromentDTO {

    @NotEmpty(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "[A-ZÀ-Ú][A-Za-zÀ-ú0-9 ]*", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por ambiente es de 25 mts.")
    @DecimalMin(value = "0.0", message = "El ancho de un ambiente debe ser mayor a 0 mts.")
    private Double width;

    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por ambiente es de 33 mts.")
    @DecimalMin(value = "0.0", message = "El largo de un ambiente debe ser mayor a 0 mts.")
    private Double length;
}
