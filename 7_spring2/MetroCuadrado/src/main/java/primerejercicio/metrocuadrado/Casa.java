package primerejercicio.metrocuadrado;

import lombok.*;

import java.awt.image.ComponentSampleModel;
import java.util.ArrayList;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class Casa {
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();


}
