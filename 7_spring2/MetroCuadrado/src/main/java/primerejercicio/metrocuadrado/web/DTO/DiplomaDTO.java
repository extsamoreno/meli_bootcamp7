package primerejercicio.metrocuadrado.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class DiplomaDTO {
    private double promedio;
    private Alumno alumno = new Alumno();
    private String mensaje = " ";

}
