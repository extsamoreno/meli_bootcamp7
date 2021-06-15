package com.ejercitacion.ejercitacion.diploma.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Diploma {

    private String message;
    @JsonProperty("average_grade")
    private Double averageGrade;
    private Student student;

    public Diploma(String message, Double averageGrade, Student student) {
        this.message = message;
        this.averageGrade = averageGrade;
        this.student = student;
    }

    public Diploma() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Student getAlumn() {
        return student;
    }

    public void setAlumn(Student student) {
        this.student = student;
    }
}
