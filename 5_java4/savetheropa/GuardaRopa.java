package savetheropa;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.*;

public class GuardaRopa {
    public HashMap<Integer, ArrayList<savetheropa.Prenda>> diccionario;
    public int contador = 0;

    public GuardaRopa(HashMap<Integer, ArrayList<savetheropa.Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public GuardaRopa() {
        diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<savetheropa.Prenda> listaDePrendas) {
        int key = contador;

        diccionario.put(key, (ArrayList) listaDePrendas);
        contador++;

        return key;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, ArrayList<savetheropa.Prenda>> entry : this.diccionario.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " Prendas: " + entry.getValue().toString());
        }
    }

    public List<savetheropa.Prenda> devolverPrendas(Integer numero){
        List<savetheropa.Prenda> listaPrendas = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<savetheropa.Prenda>> entry : this.diccionario.entrySet()) {
            if (entry.getKey() == numero) {
                listaPrendas = entry.getValue();
            }
        }

        return listaPrendas;
    }
}