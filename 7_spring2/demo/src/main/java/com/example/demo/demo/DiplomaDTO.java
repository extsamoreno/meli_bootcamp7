package com.example.demo.demo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiplomaDTO {
    private double promedio;
    private Alumno alumno = new Alumno();
    private String mensaje = " ";
}
