package primerejercicio.metrocuadrado.web.DTO;

import lombok.*;

import java.util.ArrayList;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class Casa {
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();


}
