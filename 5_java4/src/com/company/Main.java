package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Prenda buzo = new Buzo("adidas", "m8");
        Prenda jean = new Jean("nike", "m4");
        Prenda remera = new Remera("puma", "m3");

        HashMap<Integer, ArrayList<Prenda>> miDiccionario = new HashMap<>();

        ArrayList<Prenda> miLista = new ArrayList<>();
        miLista.add(buzo);
        miLista.add(remera);

        ArrayList<Prenda> miLista2 = new ArrayList<>();
        miLista2.add(buzo);
        miLista2.add(jean);
        miLista2.add(remera);

        miDiccionario.put(1,miLista);
        miDiccionario.put(2,miLista2);

        GuardaRopa g = new GuardaRopa(miDiccionario);

        System.out.println(g.guardarPrendas(miLista2));
        g.mostrarPrendas();
    }
}
