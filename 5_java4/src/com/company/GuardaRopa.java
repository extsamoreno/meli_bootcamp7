package com.company;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.*;

public class GuardaRopa {

    public HashMap<Integer, ArrayList<Prenda>> diccionario;

    public GuardaRopa(HashMap<Integer, ArrayList<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public GuardaRopa() {

    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {

        // ArrayList<Prenda> list = new ArrayList<Prenda>(){listaDePrendas};

        for (Map.Entry<Integer, ArrayList<Prenda>> entry : this.diccionario.entrySet()) {

            if (Arrays.deepEquals(entry.getValue().toArray(), listaDePrendas.toArray())) {

                return entry.getKey();
            }
        }
        return -1;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, ArrayList<Prenda>> entry : this.diccionario.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + entry.getValue().toString());

        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> listaP = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Prenda>> entry : this.diccionario.entrySet()) {
            if (entry.getKey() == numero) {
                listaP = entry.getValue();
            }
        }
        return listaP;
    }
}


