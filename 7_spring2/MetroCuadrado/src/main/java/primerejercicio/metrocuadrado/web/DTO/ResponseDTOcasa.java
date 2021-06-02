package primerejercicio.metrocuadrado.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class ResponseDTOcasa {
    private Casa casa;
    private double metrosTotales;
    private double precio;
    //private ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();

}
