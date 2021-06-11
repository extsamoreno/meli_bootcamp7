package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "([A-Z][a-zäÄëËïÏöÖüÜáéíóúáéíóúÁÉÍÓÚÂÊÎÔÛâêîôûàèìòùÀÈÌÒÙ]+[\\p{Space}]*)*", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @DecimalMax(value = "10.0",message = "La máxima nota es 10.0.")
    @DecimalMin(value = "0.0",message = "La mínima nota es 0.0.")
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
