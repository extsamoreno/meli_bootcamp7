package com.ejercitacion.ejercitacion.diploma.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Size(min = 1, max = 50, message = "La longitud del nombre del alumno no puede superar los 50 caracteres.")
    @Pattern(regexp = "([A-Z]([a-z]*))", message = "El nombre del alumno debe comenzar con mayúscula")
    private String name;

    @NotEmpty(message = "La lista no puede estar vacía.")
    @Valid
    private List<Subject> subjects;

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
