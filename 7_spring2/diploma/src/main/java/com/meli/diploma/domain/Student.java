package com.meli.diploma.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private List<Subject> subjects;

    public double calculateAverage() {
        return (subjects.stream().mapToDouble(x -> x.getGrade())).sum() / subjects.size();
    }
}
