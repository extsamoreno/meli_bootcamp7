package GuardaRopaExercise;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> dict = new HashMap<Integer, List<Prenda>>();
    private Integer count = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda)
    {
        Integer k = count ++;
        dict.put(k, listaDePrenda);
        return k;
    }

    public void mostrarPrendas()
    {
        System.out.println("Prendas almacenadas:\n");

        for (Map.Entry<Integer,List<Prenda>> entry : dict.entrySet()) {
            Integer key = entry.getKey();
            List value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero)
    {
        if (dict.containsKey(numero))
        {
            List out = dict.get(numero);
            dict.remove(numero);
            return out;
        }
        else {
            System.out.println("No existen prendas almacenadas bajo la clave: " + numero);
            return List.of();
        }
    }


}
