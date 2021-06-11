package com.example.ApiSpring2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class AlumnoDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50,message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno comenzar con mayúscula.")
    private String studentName;

    @NotEmpty(message = "La lista no puede ser vacía.")
    @Valid
    private ArrayList<AsignaturaDTO> subjects;
}
