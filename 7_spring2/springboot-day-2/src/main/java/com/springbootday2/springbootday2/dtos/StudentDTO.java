package com.springbootday2.springbootday2.dtos;

import com.springbootday2.springbootday2.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int id;
    @NotNull(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "^[A-Z](\\w)+$",
            message="El nombre del alumno comenzar con mayúscula.")
    private String name;
    @NotNull(message = "La lista no puede ser vacía.")

    private @Valid Course[] courses;
}
