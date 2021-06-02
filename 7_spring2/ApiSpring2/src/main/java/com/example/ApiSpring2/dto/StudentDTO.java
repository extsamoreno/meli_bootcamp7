package com.example.ApiSpring2.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    private String name;
    private ArrayList<CourseDTO> courses;
}
