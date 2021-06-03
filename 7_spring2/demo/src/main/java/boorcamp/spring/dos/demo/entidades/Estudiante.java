package boorcamp.spring.dos.demo.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estudiante {

    private String nombre;
    private ArrayList<Asignatura> asignaturas;
}
