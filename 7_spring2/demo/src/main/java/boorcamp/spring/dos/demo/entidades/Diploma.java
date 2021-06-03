package boorcamp.spring.dos.demo.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Diploma {

    private String nombre;
    private boolean felicitaciones;
    private double promedio;
    private final String ENTIDAD="MELI";
}
