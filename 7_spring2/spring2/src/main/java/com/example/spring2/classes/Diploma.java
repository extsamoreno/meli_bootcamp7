package com.example.spring2.classes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Diploma {
    private String message;
    private double average;
    private String studentName;

    public Diploma(double average, String studentName) {
        this.average = average;
        this.studentName = studentName;
        if(this.average > 9.00) {
            this.message = "Felicidades!";
        } else {
            this.message = "";
        }
    }
}
