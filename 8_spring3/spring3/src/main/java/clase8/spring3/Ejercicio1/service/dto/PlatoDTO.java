package clase8.spring3.Ejercicio1.service.dto;

import lombok.*;

import java.util.List;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class PlatoDTO {
    private double caloriasTotales;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO maxCalorias;

}
