package com.ejercicio._spring2.ej3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    @NotNull(message = "El nombre de la materia no puede estar vacío")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*",
            message = "El nombre de la materia debe comenzar con mayúscula" )
    private String name;

    @NotNull(message = "La nota no puede estar vacío")
    @DecimalMin(value = "0.0", message = "La nota mínima es 0.0")
    @DecimalMax(value= "10.0", message = "La nota máxima es 10.0")
    private double score;
}
