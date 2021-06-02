package com.meli;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>();
        Prenda prenda1 = new Prenda("PAB", "LSP");
        Prenda prenda2 = new Prenda("PAB", "LSP2");
        prendas.add(prenda1);
        prendas.add(prenda2);
        GuardaRopa guardaRopa = new GuardaRopa();
        Integer identificador = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        try {
            List<Prenda> mis_prendas;
            mis_prendas = guardaRopa.devolverPrendas(identificador);

            for (Prenda prenda : mis_prendas) {
                System.out.println("marca: " + prenda.getMarca() + " y modelo: " + prenda.getModelo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
