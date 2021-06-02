package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private ArrayList<Course> listCourse;
    public double average(){
        double sum=0;
        double average;
        for (int i = 0; i<this.listCourse.size();i++){
            sum += this.listCourse.get(i).getQualification();
        }
        average=sum/this.listCourse.size();
        return average;
    }
}
