package com.calculadoras.calculadoras.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Alumno {
    String nombre;
    List<Asignatura> asignaturasAprobadas;

}
