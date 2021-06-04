package com.example.APIStudent.repository;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private String name;
    private List<Course> courses;
}
