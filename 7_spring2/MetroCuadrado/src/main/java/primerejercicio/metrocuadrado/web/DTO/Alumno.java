package primerejercicio.metrocuadrado.web.DTO;

import lombok.*;

import java.util.ArrayList;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class Alumno {
    private String nombre;
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();
}
