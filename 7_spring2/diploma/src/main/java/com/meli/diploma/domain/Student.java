package com.meli.diploma.domain;

import java.util.List;
import lombok.*;

@Setter @Getter
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
