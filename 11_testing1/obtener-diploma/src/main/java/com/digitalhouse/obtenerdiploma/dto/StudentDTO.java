package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "([A-Z][a-z]*\\s)+[A-Z][a-z]*",
            message = "Cada nombre o apellido del alumno debe comenzar con mayúscula y luego minúsculas.")
    private String name;

    @NotEmpty(message = "La lista no puede ser vacía.")
    private List<@Valid SubjectDTO> subjects;

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
