package com.ejercicios2;

import java.util.Comparator;

public class MainEjercicioTarde {

    public static void main(String[] args) {

        Sorter<Integer> quicksort = (Sorter)MiFactory.getInstance("sorter");
        Comparator<Integer> c1 = (a, b)->a-b;
        Integer[] arr = {5, 6,12,3, 19, 8, 8,89};
        quicksort.sort(arr, c1);
        mostrarArreglo(arr);

        Sorter<String> heapsort = (Sorter)MiFactory.getInstance("heapsort");
        String[] arr2 = {"hola", "que", "tal", "meli", "mundo"};
        Comparator<String> c2 = (a, b ) -> a.compareTo(b);
        heapsort.sort(arr2, c2);
        mostrarArreglo(arr2);

        Sorter<Integer> bubblesort = (Sorter)MiFactory.getInstance("bubblesort");
        Integer[] arr3 = {5, 6,12,3, 19, 8, 8,89};
        bubblesort.sort(arr3, c1);
        mostrarArreglo(arr3);


        Integer[] arrayGrande = crearArregloGrande(100000);

        Time time = new Time();
        time.start();
        bubblesort.sort(arrayGrande, c1);
        time.stop();
        System.out.println("\n" + "Tiempo bubblesort: " + time.elapsedTime() + " milisegundos");

        Sorter<Integer> heapsortInt = (Sorter)MiFactory.getInstance("heapsort");
        time.start();
        heapsortInt.sort(arrayGrande, c1);
        time.stop();
        System.out.println("Tiempo heapsort: " + time.elapsedTime() + " milisegundos");

    }


    private static Integer[] crearArregloGrande(int cant) {
        Integer[] arr = new Integer[cant];

        for(int i = cant - 1; i >= 0; --i) {
            arr[cant - i - 1] = i;
        }

        return arr;
    }

    private static <T>void mostrarArreglo(T[] arr) {
        System.out.println("");
        for(T num: arr)
            System.out.print(num+" ");
    }
}
