package Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.*;

public class GuardaRopa {
    public HashMap<Integer, ArrayList<Prenda>> diccionario;
    public int contador = 0;

    public GuardaRopa(HashMap<Integer, ArrayList<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public GuardaRopa() {
        diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        int key = contador;

        diccionario.put(key, (ArrayList) listaDePrendas);
        contador++;

        return key;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, ArrayList<Prenda>> entry : this.diccionario.entrySet()) {
            System.out.println("ID: " + entry.getKey());
            System.out.println("Prendas: " + entry.getValue().toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer key){
        List<Prenda> listaPrendas = diccionario.get(key);
        diccionario.remove(key);

        return listaPrendas;
    }
}