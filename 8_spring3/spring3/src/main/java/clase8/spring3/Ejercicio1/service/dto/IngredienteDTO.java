package clase8.spring3.Ejercicio1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class IngredienteDTO {
    private String name;
    private double calories;
}
