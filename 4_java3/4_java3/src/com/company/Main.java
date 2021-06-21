package com.company;

import com.company.ej1.*;
import com.company.ejTarde.*;

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
        Precedable<Persona> p1 = FactoryPrecedable.generarPrecedable("pepe", 11222333);
        Precedable<Persona> p2 = FactoryPrecedable.generarPrecedable("juan", 11222334);
        Precedable<Persona> p3 = FactoryPrecedable.generarPrecedable("walter", 33222334);
        Precedable<Persona> p4 = FactoryPrecedable.generarPrecedable("luis", 1222334);

        Precedable[] arrPersona = { p1, p2, p3, p4};

        SortUtil.ordenar(arrPersona);

        for(Precedable p : arrPersona) {
            System.out.println(p.toString());
        }

        System.out.println("---------");

        Precedable<Celular> c1 = FactoryPrecedable.generarPrecedable(12344, "jorge");
        Precedable<Celular> c2 = FactoryPrecedable.generarPrecedable(1233, "pedro");
        Precedable<Celular> c3 = FactoryPrecedable.generarPrecedable(1234, "mariano");
        Precedable<Celular> c4 = FactoryPrecedable.generarPrecedable(233, "lucas");

        Precedable[] arrCelular = { c1, c2, c3, c4};

        SortUtil.ordenar(arrCelular);

        for(Precedable c : arrCelular) {
            System.out.println(c.toString());
        }
        */

        // Ej tarde

        //Sorter sorter = new QuickSortSorterImple();
        //Sorter sorter = new HeapSortSorterImple();
        //Sorter sorter = new BubbleSortSorterImple();
        Sorter sorter = (Sorter) MyFactory.getInstance("MyFactory.properties");

        Integer[] arr = {5, 6, 19, 8, 9,89};
        Comparator<Integer> c1 = (a, b)->a-b;

        String[] arrString = {"zzz", "abc", "mmm", "aac", "lll"};
        Comparator<String> c2 = (a, b)->a.compareTo(b);

        Integer[] arrMiles = new Integer[100000];
        Comparator<Integer> c3 = (a, b)->b-a;
        Random generator = new Random();
        Time timer = new Time();

        for (int i = 0; i < arrMiles.length; i++) {
            arrMiles[i] = generator.nextInt();
        }

        //sorter.sort(arr, c1);
        //sorter.sort(arrString, c2);
        timer.start();
        sorter.sort(arrMiles, c3);
        timer.stop();
        //mostrarArreglo(arr);
        //mostrarArreglo(arrString);

        mostrarArreglo(arrMiles);

        System.out.println();
        System.out.println("Tardo en ordenar: " + timer.elapsedTime());

        //  Bubble = 11839
        //  Heap   = 110
        //  Quick  = 111
        //  Los tiempos varian ya que tienen distinta complejidad computacional
        //  Bubble es o(n^2) y Heap y Quick es n log n

    }

    private static <T>void mostrarArreglo(T[] arr) {
        System.out.println("");
        for(T num: arr)
            System.out.print(num+" ");
    }

}
