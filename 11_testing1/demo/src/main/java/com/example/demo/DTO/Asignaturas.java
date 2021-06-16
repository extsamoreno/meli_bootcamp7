package com.example.demo.DTO;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Asignaturas {

    @NotNull(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String nombre;

    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value = 0, message = "La mínima nota es 0.0.")
    @Max(value = 10, message = "La máxima nota es 10.0.")
    private double nota;

}
