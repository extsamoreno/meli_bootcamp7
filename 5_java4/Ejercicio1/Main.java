package com.company.Clase4Java.Ejercicio1;

import com.company.Clase4Java.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa ropero= new GuardaRopa();
        Campera camp1= new Campera("Air","Nike");
        Campera camp2= new Campera("ZNE","Adidas");

        Campera camp3= new Campera("otro","Columbia");
        Campera camp4= new Campera("Aconcagua","North Face");

        List<Prenda> lista1= new ArrayList<>();
        lista1.add(camp1);
        lista1.add(camp2);

        List<Prenda> lista2= new ArrayList<>();
        lista2.add(camp3);
        lista2.add(camp4);

        Integer posix= ropero.guardarPrendas(lista1);
        Integer posix1= ropero.guardarPrendas(lista2);


        ropero.mostrarPrendas();

        List<Prenda> listaDev=ropero.devolverPrendas(posix);

        Utils.printArr(listaDev);

    }
}
