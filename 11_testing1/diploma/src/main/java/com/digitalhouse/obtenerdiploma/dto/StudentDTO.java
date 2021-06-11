package com.digitalhouse.obtenerdiploma.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede estar vacío")
    @Length(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(message = "El nombre del alumno comenzar con mayúscula.",regexp = "^[A-Z].*")
    private String name;

    @Valid
    @NotNull(message = "notnull")
    @NotEmpty(message = "La lista no puede ser vacía")
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
