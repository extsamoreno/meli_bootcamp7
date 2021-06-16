package com.example.demo.DTO;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Alumno {


    @NotNull(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String nombre;

    @NotEmpty(message = "La lista no puede ser vacía.")
    @Valid
    private List<Asignaturas> listaAsignaturas;

}
