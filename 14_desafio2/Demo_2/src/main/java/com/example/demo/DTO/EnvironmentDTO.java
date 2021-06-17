package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvironmentDTO {

    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @Min(value = 1, message = "El minimo ancho permitido por propiedad es de 1 mts.")
    private double width;

    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.")
    @Min(value = 1, message = "El minimo largo permitido por propiedad es de 1 mts.")
    private double length;
    private double squareMeter;


}
