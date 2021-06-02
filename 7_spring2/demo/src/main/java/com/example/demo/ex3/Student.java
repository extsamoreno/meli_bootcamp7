package com.example.demo.ex3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String name;
    private String lastname;
    private ArrayList<Subject> subjects;

    public Student(Student dto) {
        this.name = dto.getName();
        this.subjects = new ArrayList<>();
    }
}
