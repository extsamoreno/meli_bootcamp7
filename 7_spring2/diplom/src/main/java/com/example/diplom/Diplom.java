package com.example.diplom;
import lombok.*;
@Getter @Setter
public class Diplom {

    private double grade;
    private String student;
    private String message;

    public Diplom(String name, double grade, String message){
        this.grade = grade;
        this.student = name;
        this.message = message;

    }
}
