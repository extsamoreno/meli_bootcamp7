package com.tucasitatasaciones.tucasitatasaciones.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    @NotNull(message = "El nombre del ambiente no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    private String name;

    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
    @DecimalMin(value = "0.0", message = "El mínimo largo permitido por propiedad es de 0 mts.")
    private double high;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @DecimalMin(value = "0.0", message = "El minimo ancho permitido por propiedad es de 0 mts.")
    private double width;
}

