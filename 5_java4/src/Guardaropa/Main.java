package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Prenda prenda = new Prenda("nike", "campera");
        Prenda prenda2 = new Prenda("nike2", "campera2");

        List<Prenda> lista = new ArrayList<>();
        lista.add(prenda);
        lista.add(prenda2);

        GuardaRopa guardaropa = new GuardaRopa();

        int ticket = guardaropa.guardarPrendas(lista);

        List<Prenda> mis_prendas;
        try {
            mis_prendas = guardaropa.devolverPrendas(ticket);

            for (Prenda prenda_aux : mis_prendas) {
                System.out.println(prenda_aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        guardaropa.mostrarPrendas();


    }
}
