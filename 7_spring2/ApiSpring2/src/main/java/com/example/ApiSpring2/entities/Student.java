package com.example.ApiSpring2.entities;

import com.example.ApiSpring2.dto.CourseDTO;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private ArrayList<CourseDTO> course;
}
