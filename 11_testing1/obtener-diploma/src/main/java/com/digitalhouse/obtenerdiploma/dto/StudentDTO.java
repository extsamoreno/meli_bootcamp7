package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe empezar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    private String studentName;

    @NotEmpty(message = "La lista no puede estar vacia")
    @Valid
    private List<SubjectDTO> subjects;

    public StudentDTO() {
        this.subjects = new ArrayList<>();
    }
}
