package com.meli.API_diploma.entities;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String name;
    private ArrayList<Course> courses;
}
