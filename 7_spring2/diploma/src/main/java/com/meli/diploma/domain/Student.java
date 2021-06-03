package com.meli.diploma.domain;

import java.util.List;

import lombok.*;

@Setter
@Getter
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

        double average = totalGrades / subjects.size();
        double roundedAverage =  Math.floor(average * 100) / 100;

        return roundedAverage;
    }
}
