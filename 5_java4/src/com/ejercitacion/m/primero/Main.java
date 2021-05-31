package com.ejercitacion.m.primero;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>();
        Prenda prenda = new Prenda("Gucci", "Pantalón verano");
        Prenda remera = new Prenda("Dolce&Gabbana", "Remera manga corta");
        prendas.add(prenda);
        prendas.add(remera);

        GuardaRopa guardarropa = new GuardaRopa();
        int numero = guardarropa.guardarPrendas(prendas);
        guardarropa.mostrarPrendas();
        System.out.println(guardarropa.devolverPrendas(numero));

    }
}
