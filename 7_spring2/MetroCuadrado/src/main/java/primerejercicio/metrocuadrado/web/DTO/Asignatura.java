package primerejercicio.metrocuadrado.web.DTO;

import lombok.*;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class Asignatura {
    private String nombre;
    private double nota;
}
