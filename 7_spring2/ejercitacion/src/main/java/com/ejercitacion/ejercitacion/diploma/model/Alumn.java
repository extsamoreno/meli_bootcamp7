package com.ejercitacion.ejercitacion.diploma.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alumn {

    private String name;
    private List<Subject> subjects;

    public Alumn(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Alumn() {
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
