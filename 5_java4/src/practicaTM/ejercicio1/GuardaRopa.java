package practicaTM.ejercicio1;

import practicaTM.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas = new HashMap();
    private Integer cont = -1;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        cont++;
        prendas.put(cont, listaDePrenda);
        return cont;
    }

    public void mostrarPrendas() {
        for (Integer key : prendas.keySet()) {
            System.out.print("Id: " + key+"\t");
            Utils.printArr(prendas.get(key));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
       return prendas.get(numero);
    }

}
