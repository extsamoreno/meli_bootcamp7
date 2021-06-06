package SaveTheRopa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private int contador = 1;
    private HashMap<Integer, List<Prenda>> dic = new HashMap<>();

    public GuardarRopa() {
    }

    // Devuelve el número identificador en donde quedaron asignadas las prendas,
    // es decir la clave del diccionario en donde guardamos las prendas.
    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.dic.put(contador, listaDePrenda);
        contador++;
        return contador - 1;
    }

    // Imprime por pantalla todas las prendas que quedan en el guardarropas
    // junto con el número que les corresponde.
    public void mostrarPrendas() {
        for(Map.Entry<Integer,List<Prenda>> entry : dic.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    // Devuelve la lista de prendas que están guardadas bajo ese número.
    public List<Prenda> devolverPrendas(Integer numero) {
        return dic.remove(numero);
    }
}
