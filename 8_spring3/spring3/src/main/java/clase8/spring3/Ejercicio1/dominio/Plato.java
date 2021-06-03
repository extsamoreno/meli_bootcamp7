package clase8.spring3.Ejercicio1.dominio;

import java.util.List;

import lombok.*;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class Plato {
    private String nombre;
    private List<Ingrediente> listaIngredientes;
}
