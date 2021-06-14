package com.digitalhouse.obtenerdiploma.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SubjectDTO {

    @NotNull(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value = 0, message = "La nota mínima es 0.0")
    @Max(value=10, message = "La nota máxima es 10.0")
    private int score;

}
