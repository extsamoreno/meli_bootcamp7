package com.meli;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        diccionario = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador++;
        diccionario.put(contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer,List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.remove(numero);
    }
}