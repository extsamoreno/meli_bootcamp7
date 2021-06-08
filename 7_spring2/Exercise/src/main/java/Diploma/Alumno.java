package Diploma;

import lombok.Data;

import java.util.List;

@Data
public class Alumno {
    private String nombre;
    private List<Asignaturas> asignaturas;
}
