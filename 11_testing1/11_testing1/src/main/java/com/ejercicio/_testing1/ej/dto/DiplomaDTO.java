package com.ejercicio._spring2.ej3.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiplomaDTO {
    private String message;
    private Double scoreAverage;
    private StudentDTO studentName;
}
