package com.company.CT;

import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {

        Comparator<Integer> c1 = (a,b)->a-b;
        Sorter sorter = new QuickSortImple();
        Integer [] quick={1,4,2,6,7,9,3};
        mostrarArreglo(quick);
        sorter.sort(quick,c1);
        mostrarArreglo(quick);

        System.out.println("Heap");
        Sorter sorterH = new HeapSortImple();
        Integer [] Heap={1,4,2,6,7,9,3};
        mostrarArreglo(Heap);
        sorterH.sort(Heap,c1);
        mostrarArreglo(Heap);

        System.out.println("Buuble");
        Sorter sorterB = new BubbleSortImple();
        Integer [] Bubble={1,4,2,6,7,9,3};
        mostrarArreglo(Bubble);
        sorterB.sort(Bubble,c1);
        mostrarArreglo(Bubble);

        MiFactory SORTE= new MiFactory();
        SORTE.getInstance("/Users/lurrea/Documents/Bootcamp/meli_bootcamp7/4_java3/Clase_3/src/com/company/CT/MiFactory.properties");
    }


    public static <T> void mostrarArreglo(T[] arr){
        for(T num:arr){
            System.out.print(num+" ");

        }
        System.out.println();
    }
}
