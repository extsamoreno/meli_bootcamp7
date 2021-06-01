package meli.ejerc.PrimerEjercicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    int identificador = 0;
    Map<Integer,List<Prenda>> ropa = new HashMap<Integer, List<Prenda>>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        identificador++;
        ropa.put(identificador,listaDePrenda);
        return identificador;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer,List<Prenda>> entry:ropa.entrySet())
        {
            Integer key = entry.getKey();
            List<Prenda> value = entry.getValue();
            System.out.println("Ticket # "+key+","+value);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return ropa.remove(numero);
    }

}
