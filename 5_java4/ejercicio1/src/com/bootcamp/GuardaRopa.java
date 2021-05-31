package com.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private int cont;

    public GuardaRopa() {
        diccionario = new HashMap<>();
        cont = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        cont++;
        diccionario.put(cont, listaDePrenda);
        return cont;
    }

    public void mostrarPrendas() {
        diccionario.forEach((key, value) -> {
            System.out.println(key + " / " + value);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.remove(numero);
    }
}
