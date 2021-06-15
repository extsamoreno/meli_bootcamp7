package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @NotEmpty(message="El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "[A-Z]+[[a-z]\\p{Space}]+[a-z\\p{Punct}]+([0-9]{1,10})?", message = "El nombre del alumno debe comenzar con mayúscula y continuar con minusculas.")
    @Size(max=50, message="La longitud del nombre no puede superar los 50 caracteres.")
    private String name;

    @Valid
    @NotEmpty(message = "La lista no puede ser vacía.")
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
