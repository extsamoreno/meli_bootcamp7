package com.ejercitacion.ejercitacion.diploma.model;

import javax.validation.constraints.*;

public class Subject {

    @NotEmpty(message = "El nombre de la materia no peude estar vacío")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "([A-Z]([a-z]*))", message = "El nombre debe comenzar con mayúscula")
    private String name;

    @NotNull(message = "La nota no puede estar vacía")
    @Min(value = 0, message = "La mínima nota es 0")
    @Max(value = 10, message = "La máxima nota es 10")
    private Double grade;


    public Subject(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
