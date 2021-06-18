package com.example.validaciones.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class AsignaturaDTO {

    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30,message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
    private String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value = 0,message = "La mínima nota es 0.0.")
    @Max(value = 10,message = "La máxima nota es 10.0.")
    private double score;
}
