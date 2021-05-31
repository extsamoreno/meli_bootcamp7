package com.meli.tm.ex1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {

    private int contador;
    Map<Integer, List<Prenda>> guardaRopa;

    public GuardarRopa() {
        contador = 0;
        this.guardaRopa = new HashMap<>();

    }

    public Integer guardarPrenda(List<Prenda> prendas) {
        int llave = contador;
        this.guardaRopa.put(contador, prendas);
        contador++;
        return llave;
    }

    public List<Prenda> devolverPrendas(Integer numeroGuardaRopa) {
        return guardaRopa.remove(numeroGuardaRopa);
    }

    public void mostrarPrendas() {
        if (!this.guardaRopa.isEmpty()) {

            for (Map.Entry<Integer, List<Prenda>> entry : this.guardaRopa.entrySet()) {
                System.out.println("Numero de guardaropa : " + entry.getKey());
                for (Prenda prenda : entry.getValue()) {
                    System.out.println("   " + prenda);
                }
            }
        } else {
            System.out.println(" El guardaropa esta vacio");
        }
    }
}
