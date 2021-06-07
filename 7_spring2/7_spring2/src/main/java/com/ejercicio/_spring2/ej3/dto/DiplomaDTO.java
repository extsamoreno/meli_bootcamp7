package com.ejercicio._spring2.ej3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiplomaDTO {
    private String message;
    private double scoreAverage;
    private String studentName;
}
