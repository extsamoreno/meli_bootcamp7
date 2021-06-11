package com.digitalhouse.obtenerdiploma.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;


@Data
//@Valid
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacio")
    @Size(min = 1, max = 50, message = "El nombre del alumno debe tener 50 caracteres maximo")
    @Pattern(message = "El nombre del alumno debe comenzar con mayuscula", regexp = "^[A-Z].*[a-z]$")
    private String name;

    @NotEmpty(message = "La lista de materias no puede estar vacio")
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
