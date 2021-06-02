package com.example.exercises.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiplomaDTO {
    private String message;
    private double average;
    private String student;
}

