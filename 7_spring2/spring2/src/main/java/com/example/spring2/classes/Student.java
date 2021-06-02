package com.example.spring2.classes;

import com.example.spring2.dto.StudentDTO;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String name;
    private ArrayList<Subject> subjects;

    public Student(StudentDTO dto) {
        this.name = dto.getName();
        this.subjects = new ArrayList<>();
    }
}
