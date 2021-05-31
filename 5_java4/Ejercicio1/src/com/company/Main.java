package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Cliente 1:");
        Camisa micamisa = new Camisa("gef", "2018");
        Pantalon mipantalon = new Pantalon("star", "2020");
        List<Prenda> listaprendas = new ArrayList<>();
        listaprendas.add(micamisa);
        listaprendas.add(mipantalon);

        GuardaRopa SaveTheRopa = new GuardaRopa();
        System.out.println("Identificador de guardado:");
        Integer id = SaveTheRopa.guardarPrendas(listaprendas);
        System.out.println(id);
        System.out.println(" ");

        System.out.println("Reclamar prendas:");
        List<Prenda> prendasReclamadas= SaveTheRopa.devolverPrendas(1);
        for (int i = 0; i < prendasReclamadas.size(); i++) {
            String marca=prendasReclamadas.get(i).getMarca();
            String modelo=prendasReclamadas.get(i).getModelo();
            System.out.println("Prenda"+(i+1)+": Marca="+ marca +", Modelo="+ modelo);
        }
    }
}
