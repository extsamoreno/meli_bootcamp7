package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío")
    @Pattern(regexp = "^[A-Z]{1}.[^A-Z]*$", message = "El nombre del ambiente debe comenzar con mayúscula y el resto en minúscula")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String environment_name;
    @NotNull(message = "El ancho del ambiente no puede estar vacío")
    @Max(value = 25,message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @Min(value = 1,message = "El mínimo ancho permitido por propiedad es de 1 mt.")
    private double environment_width;
    @NotNull(message = "El largo del ambiente no puede estar vacío")
    @Max(value = 33,message = "El máximo largo permitido por propiedad es de 33 mts.")
    @Min(value = 1,message = "El mínimo largo permitido por propiedad es de 1 mt.")
    private double environment_length;


}
