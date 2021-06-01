package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> diccionario;

    public GuardaRopa() {
        this.contador = 0;
        this.diccionario = new HashMap<Integer, List<Prenda>>();
    }

    public GuardaRopa(Map<Integer, List<Prenda>> diccionario) {
        this.contador = 0;
        this.diccionario = diccionario;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        diccionario.put(contador, listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println("Indice: " + entry.getKey());
            for (Prenda prenda : entry.getValue()) {
                System.out.println("    " + prenda);
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) throws Exception {
        if (contador > numero)
            return diccionario.get(numero);
        throw new Exception("No existe esa lista");
    }
}
