package com.meli1;

import java.util.HashMap;
import java.util.List;

public class GuardarRopa {
    private static int contador = 0;
    private static HashMap<Integer, List<Prenda>> diccionario = new HashMap<Integer, List<Prenda>>();

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        GuardarRopa.contador = contador;
    }

    public HashMap<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        GuardarRopa.contador ++;
        GuardarRopa.diccionario.put(contador, listaDePrendas);
        return contador;

    }

    public void mostrarPrendas(){
        for (List<Prenda> value : diccionario.values()) {
            System.out.println(value.toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return GuardarRopa.diccionario.get(numero);
    }
}
