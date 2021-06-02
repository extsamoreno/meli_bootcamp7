package com.example.demo;
import lombok.*;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private String nombre;
    private List<Asignatura> asignaturas;
}
