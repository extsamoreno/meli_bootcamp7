package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "^[A-Z]\\w*$", message = "El nombre del alumno comenzar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String name;

    @NotEmpty(message = "La lista no puede ser vacía.")
    @Valid
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}
// ^[A-Z]\w*$