package com.springbootday2.springbootday2.dtos;

import com.springbootday2.springbootday2.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    private int id;
    private String name;
    private Course[] courses;
}
