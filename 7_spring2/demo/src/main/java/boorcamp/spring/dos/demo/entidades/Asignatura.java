package boorcamp.spring.dos.demo.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Asignatura {

    private String nombre;
    private double nota;
}
