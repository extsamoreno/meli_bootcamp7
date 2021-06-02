package com.ejercitacion.ejercitacion.diploma.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Diploma {

    private String mensaje;
    @JsonProperty("average_grade")
    private Double averageGrade;
    private Alumn alumn;

    public Diploma(String mensaje, Double averageGrade, Alumn alumn) {
        this.mensaje = mensaje;
        this.averageGrade = averageGrade;
        this.alumn = alumn;
    }

    public Diploma() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Alumn getAlumn() {
        return alumn;
    }

    public void setAlumn(Alumn alumn) {
        this.alumn = alumn;
    }
}
