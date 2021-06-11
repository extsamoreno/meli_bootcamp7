package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacio" )
    @Pattern(regexp = "[A-Z]+[[a-z]\\p{Space}]+[a-z\\p{Punct}]?", message = "Nombre no puede comenzar minuscula")
    @Size(max = 50, message = "La longitud no puede superar los 50 caracteres")
    private String name;

    @NotEmpty(message ="La lista no puede ser vacía." )
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
