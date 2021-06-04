package com.example.springclase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private HashMap<String, Integer> subjects;
    private Double average;
}
