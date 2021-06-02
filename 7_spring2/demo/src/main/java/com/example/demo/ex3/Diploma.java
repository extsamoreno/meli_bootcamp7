package com.example.demo.ex3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
