package primerejercicio.metrocuadrado.web.DTO;

import lombok.*;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class Habitacion {
    private String nombre;
    private double ancho;
    private double largo;
}
