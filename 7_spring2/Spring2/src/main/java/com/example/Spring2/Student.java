package com.example.Spring2;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;
    private ArrayList<Subject> listSubject;
}
