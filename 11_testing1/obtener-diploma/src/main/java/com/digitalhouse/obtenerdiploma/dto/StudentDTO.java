package com.digitalhouse.obtenerdiploma.dto;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede ir vacio" )
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe comenzar con mayuscula")
    @Size(max = 50,message = "la longitud del nombre debe ser menor a 50" )
    private String name;

    @Valid
    @NotNull(message = "La lista de materias no puede estar vacia")
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
