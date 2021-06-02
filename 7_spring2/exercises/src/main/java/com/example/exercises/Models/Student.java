package com.example.exercises.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private List<Subject> subjects;

    public double calculateAverage() {
        double totalGrades = 0;
        for (Subject s : subjects) {
            totalGrades += s.getGrade();
        }

        return  totalGrades/subjects.size();
    }
}
