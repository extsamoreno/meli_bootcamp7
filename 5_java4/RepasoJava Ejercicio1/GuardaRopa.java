package RepasoJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int contador = 1,indice=1;
    ArrayList<Prenda> lisPrendas = new ArrayList<>();

    HashMap<Integer, List<Prenda>> mapPrendas = new HashMap<>();

    public GuardaRopa(ArrayList<Prenda> lisPrendas, HashMap<Integer, List<Prenda>> mapPrendas) {
        this.lisPrendas = lisPrendas;
        this.mapPrendas = mapPrendas;
    }


    //Metodos

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        System.out.println(contador);
        mapPrendas.put(contador, listaDePrendas);
        contador++;
        System.out.println(" Guardado en "+ (contador-1));
        return contador-1;
    }

    public void mostarPrendas() {

        for (int key : this.mapPrendas.keySet()) {
            System.out.println("Key:  "+key);
            ArrayList listaDePrendas = (ArrayList) this.mapPrendas.get(key);
            for (int i = 0; i < listaDePrendas.size(); i++) {
                System.out.println(listaDePrendas.get(i));
            }
            //mapPrendas.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v.toString()));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return mapPrendas.get(numero);
    }
}
