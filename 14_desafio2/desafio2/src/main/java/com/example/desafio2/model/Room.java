package com.example.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room
{
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;
    @DecimalMax(value = "30.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @DecimalMin(value = "0.0", message = "El ancho minimo permitido no puede ser inferior a los 0 mts.")
    @NotEmpty(message = "El ancho del ambiente no puede estar vacío.")
    private double width;
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
    @DecimalMin(value = "0.0", message = "El width minimo permitido no puede ser inferior a los 0 mts.")
    @NotEmpty(message = "El largo del ambiente no puede estar vacío.")
    private double length;
}