package com.ejercitacion.ejercitacion.diploma.model;

public class Subject {

    private String name;
    private double grade;

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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
