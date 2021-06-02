package com.example.SpringClase2;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Student {

    private String name;
    private ArrayList<Signature> grades;

    public double average(){
        return this.grades.stream().mapToDouble(grade -> grade.getGrade()).average().getAsDouble();
    }

    public Degreed degreed(){
        return new Degreed(this.name, this.average());
    }
}
