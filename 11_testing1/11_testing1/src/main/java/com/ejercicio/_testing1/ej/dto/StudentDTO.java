package com.ejercicio._spring2.ej3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @NotNull(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*",
            message = "El nombre del alumno debe comenzar con mayúscula" )
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    private String name;

    @NotNull(message = "La lista no puede ser vacía")
    private List<SubjectDTO> subjects;

}
