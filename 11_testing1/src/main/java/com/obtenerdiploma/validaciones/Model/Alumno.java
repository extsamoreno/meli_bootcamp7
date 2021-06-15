package com.obtenerdiploma.validaciones.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @NotEmpty(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(max = 50,message = "El nombre del alumno no puede superer los 50 caracteres")
    private String nombre;

    @NotEmpty (message = "La lista no puede estar vacia")
    @Valid
    private ArrayList<Asignatura> asignaturas;


}
