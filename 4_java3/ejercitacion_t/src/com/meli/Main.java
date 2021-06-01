package com.meli;

import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Sorter<Integer> iSorter = (Sorter)MiFactory.getInstance("sorter");
        Sorter<String> sSorter = (Sorter)MiFactory.getInstance("sorter");

        Integer[] iArr = {5,3,0,2,6,9,2};
        Comparator<Integer> c1 = (a,b) -> a-b;
        mostrarArr(iArr);
        iSorter.sort(iArr,c1);
        mostrarArr(iArr);

        String[] sArr = {"z", "l", "q", "a", "m"};
        Comparator<String> c2 = (s1,s2) -> s1.compareTo(s2);
        mostrarArr(sArr);
        sSorter.sort(sArr,c2);
        mostrarArr(sArr);

        Integer[] arr = crearArregloEnteros(100000);

        Timer timer = new Timer();
        timer.start();
        iSorter.sort(arr,c1);
        timer.stop();

        long elapsedTime = timer.elapsedTime();
        System.out.println("\n" + elapsedTime + " milisegundos");

        //Tiempo BubleSort: 367 segundos
        //Tiempo HeapSort: 50 milisegundos
        //Tiempo QuickSort: 20 milisegundos
    }

    public static Integer[] crearArregloEnteros(int cantidad) {
        Integer[] arr = new Integer[cantidad];

        for (int i = cantidad-1; i >= 0; i--) {
            arr[cantidad-i-1]=i;
        }

        return arr;
    }

    public static <T> void mostrarArr(T[] arr) {
        System.out.println();
        for (T t : arr) {
            System.out.print(" " + t);
        }
    }
}
