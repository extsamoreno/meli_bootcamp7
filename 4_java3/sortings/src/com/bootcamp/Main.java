package com.bootcamp;

import java.util.Comparator;


public class Main {

    public static void pruebasSorter() {
        //Pruebas de sorter
        System.out.println("\n===============================\n" +
                "Pruebas de cada Sort");
        Integer[] arr = new Integer[]{9, 8, 6, 7, 5, 4, 3, 2, 0};
        Comparator<Integer> comp = (n1, n2) -> {
            return n1 - n2;
        };

        //QuickSorterImple<Integer> sorter = new QuickSorterImple<>();
        //HeapSorterImple<Integer> sorter = new HeapSorterImple<>();
        BubbleSorterImple<Integer> sorter = new BubbleSorterImple<>();

        sorter.sort(arr, comp);
        for (Integer x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void pruebasSorterDesdeMiFactory() {
        //Probando la implementación del sorter mediante MiFactory
        System.out.println("\n===============================\n" +
                "Sorter mediante MiFactory");

        Integer[] arr = new Integer[]{9, 8, 6, 7, 5, 4, 3, 2, 0};
        Comparator<Integer> comp = (n1, n2) -> n1 - n2;

        //QuickSorterImple<Integer> sorterFac = (QuickSorterImple<Integer>) MiFactory.getInstance("sorter");
        //BubbleSorterImple<Integer> sorterFac = (BubbleSorterImple<Integer>) MiFactory.getInstance("sorter");
        HeapSorterImple<Integer> sorterFac = (HeapSorterImple<Integer>) MiFactory.getInstance("sorter");
        sorterFac.sort(arr, comp);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void pruebasTimer() {
        //Pruebas con Timer
        System.out.println("\n===============================\n" +
                "Pruebas con Timer");

        Timer timer = new Timer();
        Comparator<Integer> comp = (n1, n2) -> n1 - n2;

        Integer[] arr = new Integer[100000];
        int limit = 100000;
        for (int i = 0; i < limit; i++) {
            arr[i] = limit - i;
        }

        //BubbleSorterImple<Integer> sorter = new BubbleSorterImple<>();
        QuickSorterImple<Integer> sorter = new QuickSorterImple<>();
        //HeapSorterImple<Integer> sorter = new HeapSorterImple<>();

        timer.start();
        sorter.sort(arr, comp);
        timer.stop();
        System.out.println("El tiempo en milisegundos es: " + timer.elapsedTime());
    }

    public static void main(String[] args) {
        pruebasSorter();
        pruebasSorterDesdeMiFactory();
        pruebasTimer();
    }
}
