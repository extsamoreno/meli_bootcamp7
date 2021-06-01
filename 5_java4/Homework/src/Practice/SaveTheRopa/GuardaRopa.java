package Practice.SaveTheRopa;

import Practice.Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class GuardaRopa {
    private HashMap<Integer, ArrayList<Prenda>> prendasGuardadas = new HashMap<>();
    private Integer contador = 0;

    public Integer guardarPrenda(ArrayList<Prenda> listaDePrenda) {
        prendasGuardadas.put(contador, listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas() {
        System.out.println("[");
        for (Integer i : prendasGuardadas.keySet()) {
            System.out.println("\t" + i + " {");
            Utils.printArrayList(prendasGuardadas.get(i));
            System.out.println("\t}");
        }
        System.out.println("]");
    }

    public ArrayList<Prenda> devolverPrendas(Integer numero){
        return prendasGuardadas.get(numero);
    }
}
