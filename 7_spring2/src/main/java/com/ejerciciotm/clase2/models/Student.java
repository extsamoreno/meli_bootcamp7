package com.ejerciciotm.clase2.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private ArrayList<Subject> subjects;
}
