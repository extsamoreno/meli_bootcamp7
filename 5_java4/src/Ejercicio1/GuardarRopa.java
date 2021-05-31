package Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa<hashMap> {

    private HashMap<Integer, ArrayList<Prenda>> hashMap;
    private int count = 0;

    public GuardarRopa() {
        this.hashMap = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        hashMap.put(count, (ArrayList<Prenda>) listaDePrenda);
        return count++;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, ArrayList<Prenda>> entry: hashMap.entrySet()) {
            System.out.println("\nKey num " + entry.getKey() );

        for (Prenda prenda: entry.getValue()) {
            System.out.println(prenda);
        }}
    }


    public List<Prenda> devolverPrendas(Integer numero){
        ArrayList<Prenda> list = hashMap.get(numero);
        System.out.println("\nSe ha devuelto: ");

        for (Prenda prenda: list) {
            System.out.println(prenda);
        }

        hashMap.remove(numero);
        return list;
    }
}
