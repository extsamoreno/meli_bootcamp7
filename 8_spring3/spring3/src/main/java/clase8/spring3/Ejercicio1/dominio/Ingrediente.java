package clase8.spring3.Ejercicio1.dominio;

import lombok.*;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class Ingrediente {
    private String nombre;
    private double peso;
}
