package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private String nombre;
    private String apellido;
    private List<Materia> listMateria;

    @Override
    public String toString() {
        return this.getApellido() + ", " + this.getNombre();
    }
}
