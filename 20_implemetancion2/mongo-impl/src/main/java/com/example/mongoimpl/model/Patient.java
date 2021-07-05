package com.example.mongoimpl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
}