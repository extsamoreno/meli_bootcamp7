package primerejercicio.metrocuadrado.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class ResponseDTOcasa {
    private Casa casa;
    private double metrosTotales;
    private double precio;

}
