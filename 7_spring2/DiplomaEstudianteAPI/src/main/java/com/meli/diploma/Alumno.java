package com.meli.diploma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private String nombre;
    private List<Asignatura> asignaturas = new ArrayList<>();

    public double promedioNotas(){
        return asignaturas.stream().mapToDouble(asignatura -> asignatura.getNota()).sum()/asignaturas.size();
    }
}
