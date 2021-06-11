package com.digitalhouse.obtenerdiploma.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
public class SubjectDTO {

    @NotNull(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre de la materia comenzar con mayúscula.")
    private String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value = 0, message = "La nota no puede ser menor que 0")
    @Max(value=10, message = "La nota no puede ser mayor que 10")
    private int score;

}
