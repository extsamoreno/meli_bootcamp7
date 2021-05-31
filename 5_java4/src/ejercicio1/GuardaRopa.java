package ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, ArrayList<Prenda>> hm;
    private int contador = 0;

    public GuardaRopa() {
        hm = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.hm.put(contador,(ArrayList)listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer,ArrayList<Prenda>> entry: hm.entrySet()){
            System.out.println("Key numero: " + entry.getKey());

            for(Prenda prenda : entry.getValue()){
                System.out.println(prenda);
            }
        }
        System.out.println();
    }

    public List<Prenda> devolverPrenda(Integer numero){
        List<Prenda> listPrenda = hm.get(numero);
        hm.remove(numero);
        return listPrenda;
    }
}
