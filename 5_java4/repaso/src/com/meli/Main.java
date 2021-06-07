package com.meli;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Prenda> prendas = new ArrayList<>();
        Prenda prenda = new Prenda("Gucci", "Pantalón verano");
        Prenda remera = new Prenda("Dolce&Gabbana", "Remera manga corta");
        prendas.add(prenda);
        prendas.add(remera);

        GuardaRopa guardarropa = new GuardaRopa();
        int numero = guardarropa.guardaPrendas(prendas);
        guardarropa.mostrarPrendas();
        System.out.println(guardarropa.devolverPrendas(numero));
    }

}