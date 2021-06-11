package com.example.ApiSpring2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class DiplomaDTO {
    private String studentName;
    private String message;
    private float averageScore;
    private ArrayList<AsignaturaDTO> subjects;
}
